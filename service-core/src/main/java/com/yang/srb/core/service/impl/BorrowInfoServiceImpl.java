package com.yang.srb.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yang.common.exception.Assert;
import com.yang.common.result.ResponseEnum;
import com.yang.srb.core.enums.BorrowInfoStatusEnum;
import com.yang.srb.core.enums.BorrowerStatusEnum;
import com.yang.srb.core.enums.UserBindEnum;
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
import java.util.List;

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
        if (integralGradeConfig == null) {
            return new BigDecimal("0");
        }
        return integralGradeConfig.getBorrowAmount();

    }

    @Override
    public void saveBorrowInfo(BorrowInfo borrowInfo, Long userId) {

        //获取userInfo的用户数据
        UserInfo userInfo = userInfoMapper.selectById(userId);

        //判断用户绑定状态
        Assert.isTrue(
                userInfo.getBindStatus().intValue() == UserBindEnum.BIND_OK.getStatus().intValue(),
                ResponseEnum.USER_NO_BIND_ERROR);

        //判断用户信息是否审批通过
        Assert.isTrue(
                userInfo.getBorrowAuthStatus().intValue() == BorrowerStatusEnum.AUTH_OK.getStatus().intValue(),
                ResponseEnum.USER_NO_AMOUNT_ERROR);

        //判断借款额度是否足够
        BigDecimal borrowAmount = this.getBorrowAmount(userId);
        Assert.isTrue(
                borrowInfo.getAmount().doubleValue() <= borrowAmount.doubleValue(),
                ResponseEnum.USER_AMOUNT_LESS_ERROR);

        //存储数据
        borrowInfo.setUserId(userId);
        //百分比转成小数
        borrowInfo.setBorrowYearRate(borrowInfo.getBorrowYearRate().divide(new BigDecimal(100)));
        borrowInfo.setStatus(BorrowInfoStatusEnum.CHECK_RUN.getStatus());
        baseMapper.insert(borrowInfo);
    }

    @Override
    public Integer getStatusByUserId(Long userId) {
        QueryWrapper<BorrowInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("status").eq("user_id",userId);
        List<Object> objects = baseMapper.selectObjs(queryWrapper);
        if (objects.size() == 0){
            return BorrowerStatusEnum.NO_AUTH.getStatus();
        }
        Integer status = (Integer) objects.get(0);
        return status;
    }
}
