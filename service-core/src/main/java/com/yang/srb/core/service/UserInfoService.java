package com.yang.srb.core.service;

import com.yang.srb.core.pojo.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yang.srb.core.pojo.entity.vo.LoginVo;
import com.yang.srb.core.pojo.entity.vo.RegisterVo;
import com.yang.srb.core.pojo.entity.vo.UserInfoVo;

/**
 * <p>
 * 用户基本信息 服务类
 * </p>
 *
 * @author Yang
 * @since 2022-07-17
 */
public interface UserInfoService extends IService<UserInfo> {

    void register(RegisterVo registerVo);

    UserInfoVo login(LoginVo loginVo, String addr);
}
