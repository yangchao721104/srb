package com.yang.srb.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yang.common.exception.Assert;
import com.yang.common.result.ResponseEnum;
import com.yang.srb.core.mapper.IntegralGradeMapper;
import com.yang.srb.core.mapper.UserInfoMapper;
import com.yang.srb.core.pojo.entity.BorrowInfo;
import com.yang.srb.core.mapper.BorrowInfoMapper;
import com.yang.srb.core.pojo.entity.IntegralGrade;
import com.yang.srb.core.pojo.entity.UserInfo;
import com.yang.srb.core.service.BorrowInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * <p>
 * 借款信息表 服务实现类
 * </p>
 *
 * @author Yang
 * @since 2022-07-17
 */
@Service
public class BorrowInfoServiceImpl extends ServiceImpl<BorrowInfoMapper, BorrowInfo> implements BorrowInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private IntegralGradeMapper integralGradeMapper;

    @Override
    public BigDecimal getBorrowAmount(Long userId) {
        //获取用户积分表
        UserInfo userInfo = userInfoMapper.selectById(userId);
        Assert.notNull(userInfo, ResponseEnum.LOGIN_MOBILE_ERROR);
        Integer integral = userInfo.getIntegral();

        //根据积分查询额度
        //根据积分查询借款额度
        QueryWrapper<IntegralGrade> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .le("integral_start", integral)
                .ge("integral_end", integral);
        IntegralGrade integralGradeConfig = integralGradeMapper.selectOne(queryWrapper);
        if(integralGradeConfig == null){
            return new BigDecimal("0");
        }
        return integralGradeConfig.getBorrowAmount();

    }
}
