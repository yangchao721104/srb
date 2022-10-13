package com.yang.srb.core.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.yang.srb.core.listener.ExcelDictDTOLinstener;
import com.yang.srb.core.pojo.entity.Dict;
import com.yang.srb.core.mapper.DictMapper;
import com.yang.srb.core.pojo.entity.dto.ExcelDictDTO;
import com.yang.srb.core.service.DictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;

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

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void importData(InputStream inputStream) {
        EasyExcel.read(inputStream, ExcelDictDTO.class, new ExcelDictDTOLinstener(baseMapper))
                .excelType(ExcelTypeEnum.XLS).sheet().doRead();
        log.info("Excel导入成功！");
    }
}
