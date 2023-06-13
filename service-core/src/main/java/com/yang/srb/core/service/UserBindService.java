package com.yang.srb.core.service;

import com.yang.srb.core.pojo.entity.UserBind;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yang.srb.core.pojo.vo.UserBindVo;

import java.util.Map;

/**
 * <p>
 * 用户绑定表 服务类
 * </p>
 *
 * @author Yang
 * @since 2022-07-17
 */
public interface UserBindService extends IService<UserBind> {

    String commitBindUser(UserBindVo userBindVO, Long userId);

    void notify(Map<String, Object> map);

    String getBindCodeByUserId(Long investUserId);
}
