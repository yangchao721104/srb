package com.yang.srb.core.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yang.srb.core.pojo.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yang.srb.core.pojo.entity.query.UserInfoQuery;
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


    IPage<UserInfo> listPage(Page<UserInfo> pageParam, UserInfoQuery userInfoQuery);

    void lock(Long id, Integer status);
}
