package com.yang.srb.core.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yang.srb.core.listener.ExcelDictDTOLinstener;
import com.yang.srb.core.pojo.entity.Dict;
import com.yang.srb.core.mapper.DictMapper;
import com.yang.srb.core.pojo.dto.ExcelDictDTO;
import com.yang.srb.core.service.DictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 数据字典 服务实现类
 * </p>
 *
 * @author Yang
 * @since 2022-07-17
 */
@Slf4j
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void importData(InputStream inputStream) {
        EasyExcel.read(inputStream, ExcelDictDTO.class, new ExcelDictDTOLinstener(baseMapper))
                .excelType(ExcelTypeEnum.XLS).sheet().doRead();
        log.info("Excel导入成功！");
    }

    @Override
    public List<ExcelDictDTO> listDictData() {
        List<Dict> dictList = baseMapper.selectList(null);
        //创建ExcelDictDTO列表，将Dict列表转换成ExcelDictDTO列表
        List<ExcelDictDTO> excelDictDTOList = new ArrayList<>(dictList.size());
        dictList.forEach(dict -> {

            ExcelDictDTO excelDictDTO = new ExcelDictDTO();
            BeanUtils.copyProperties(dict, excelDictDTO);
            excelDictDTOList.add(excelDictDTO);
        });
        return excelDictDTOList;
    }

    @Override
    public List<Dict> listByParentId(Long parentId) {
        try {
            log.info("从redis服务器获取数据");
            List<Dict> dictList2  = (List<Dict> )redisTemplate.opsForValue().get("srb:core:dictList"+parentId);
            if (dictList2 !=null){
                return dictList2;
            }
        } catch (Exception e) {
            log.error("redis服务器异常" + ExceptionUtils.getStackTrace(e));
        }

        QueryWrapper<Dict> dictQueryWrapper = new QueryWrapper<>();
        dictQueryWrapper.lambda().eq(Dict::getParentId,parentId);
        List<Dict> dictList = baseMapper.selectList(dictQueryWrapper);
        //填充hasChildren字段
        dictList.forEach(dict -> {
            //判断当前id所在的节点是否有子节点
            boolean hasChildren = this.hasChildren(dict.getId());
            dict.setHasChildren(hasChildren);
        });

        try {
            log.info("将数据存入redis");
            redisTemplate.opsForValue().set("srb:core:dictList"+parentId,dictList,5, TimeUnit.MINUTES);
        } catch (Exception e) {
            log.info("redis服务器异常");
        }

        return dictList;
    }

    @Override
    public List<Dict> findByDictCode(String dictCode) {

        QueryWrapper<Dict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dict_code",dictCode);
        Dict dict = baseMapper.selectOne(queryWrapper);
        return this.listByParentId(dict.getId());
    }

    @Override
    public String getNameByParentDictCodeAndValue(String dictCode, Integer value) {
        QueryWrapper<Dict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dict_code",dictCode);
        Dict dict = baseMapper.selectOne(queryWrapper);
        if (dict == null){
            return "";
        }

        queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("parent_id",dict.getId())
                .eq("value",value);
        Dict dict1 = baseMapper.selectOne(queryWrapper);

        if (dict1 == null){
            return "";
        }
        return dict1.getName();
    }

    /**
     * 判断当前id所在的节点是否有子节点
     * @return
     */
    private boolean hasChildren(Long id){
        QueryWrapper<Dict> dictQueryWrapper = new QueryWrapper<>();
        dictQueryWrapper.lambda().eq(Dict::getId,id);
        Integer count = baseMapper.selectCount(dictQueryWrapper);
        if (count.intValue() >0){
            return true;
        }
        return false;
    }
}
