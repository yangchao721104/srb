package com.yang.srb.core.controller.api;

import com.alibaba.fastjson.JSON;
import com.yang.common.result.R;
import com.yang.srb.base.util.JwtUtils;
import com.yang.srb.core.hfb.RequestHelper;
import com.yang.srb.core.pojo.entity.vo.UserBindVo;
import com.yang.srb.core.service.UserBindService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author yang
 * @date 2023/6/5 15:16
 */
@Api(tags = "会员账号绑定")
@RestController("UserBindController")
@RequestMapping("/api/core/userBind")
@Slf4j
public class UserBindController {

    @Resource
    private UserBindService userBindService;

    @ApiOperation("账户绑定异步回调")
    @PostMapping("/notify")
    public String notify(HttpServletRequest request) {
        Map<String, Object> map = RequestHelper.switchMap(request.getParameterMap());
        log.info("账户绑定异步回调接受的参数如下" + JSON.toJSONString(map));

        if (!RequestHelper.isSignEquals(map)){
            log.error("用户账号绑定异步回调签名验证错误："+ JSON.toJSONString(map));
            return "fail";
        }

        log.info("验签成功！开始绑定账户");
        userBindService.notify(map);

        return "success";
    }

    @ApiOperation("账户绑定提交数据")
    @PostMapping("/auth/bind")
    public R bind(@RequestBody UserBindVo userBindVO, HttpServletRequest request) {
        String token = request.getHeader("token");
        Long userId = JwtUtils.getUserId(token);
        String formStr = userBindService.commitBindUser(userBindVO, userId);
        return R.ok().data("formStr", formStr);
    }
}
