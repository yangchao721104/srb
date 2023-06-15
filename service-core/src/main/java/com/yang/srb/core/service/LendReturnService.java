package com.yang.srb.core.service;

import com.yang.srb.core.pojo.entity.LendReturn;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 还款记录表 服务类
 * </p>
 *
 * @author Yang
 * @since 2022-07-17
 */
public interface LendReturnService extends IService<LendReturn> {

    List<LendReturn> selectByLendId(Long lendId);

    String commitReturn(Long lendReturnId, Long userId);

    void notify(Map<String, Object> paramMap);
}
