package com.yang.srb.core.service;

import com.yang.srb.core.pojo.entity.Dict;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yang.srb.core.pojo.entity.dto.ExcelDictDTO;

import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 数据字典 服务类
 * </p>
 *
 * @author Yang
 * @since 2022-07-17
 */
public interface DictService extends IService<Dict> {

    void importData(InputStream inputStream);

    List<ExcelDictDTO> listDictData();

    List<Dict> listByParentId(Long parentId);

    List<Dict> findByDictCode(String dictCode);

    String getNameByParentDictCodeAndValue(String dictCode, Integer value);
}
