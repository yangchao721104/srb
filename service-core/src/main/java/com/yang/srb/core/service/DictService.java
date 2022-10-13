package com.yang.srb.core.service;

import com.yang.srb.core.pojo.entity.Dict;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.InputStream;

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
}
