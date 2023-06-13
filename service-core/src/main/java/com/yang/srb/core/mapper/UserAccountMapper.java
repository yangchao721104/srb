package com.yang.srb.core.mapper;

import com.yang.srb.core.pojo.entity.UserAccount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * <p>
 * 用户账户 Mapper 接口
 * </p>
 *
 * @author Yang
 * @since 2022-07-17
 */
public interface UserAccountMapper extends BaseMapper<UserAccount> {

    void updateAccount(@Param("bindCode") String bindCode,
                       @Param("chargeAmt") BigDecimal chargeAmt,
                       @Param("freezeAmount") BigDecimal freezeAmount);
}
