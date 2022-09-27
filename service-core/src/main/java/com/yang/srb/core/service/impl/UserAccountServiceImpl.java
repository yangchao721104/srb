package com.yang.srb.core.service.impl;

import com.yang.srb.core.pojo.entity.UserAccount;
import com.yang.srb.core.mapper.UserAccountMapper;
import com.yang.srb.core.service.UserAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户账户 服务实现类
 * </p>
 *
 * @author Yang
 * @since 2022-07-17
 */
@Service
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements UserAccountService {

}
