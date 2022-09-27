package com.yang.srb.core.service.impl;

import com.yang.srb.core.pojo.entity.UserInfo;
import com.yang.srb.core.mapper.UserInfoMapper;
import com.yang.srb.core.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户基本信息 服务实现类
 * </p>
 *
 * @author Yang
 * @since 2022-07-17
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
