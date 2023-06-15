package com.yang.srb.core.service;

import com.yang.srb.core.pojo.entity.LendItem;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yang.srb.core.pojo.vo.InvestVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 标的出借记录表 服务类
 * </p>
 *
 * @author Yang
 * @since 2022-07-17
 */
public interface LendItemService extends IService<LendItem> {

    String commitInvest(InvestVO investVO);

    void notify(Map<String, Object> paramMap);

    List<LendItem> selectByLendId(Long lendId, int i);

    List<LendItem> selectByLendId(Long lendId);
}
