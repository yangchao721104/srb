package com.yang.srb.core.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yang.common.result.R;
import com.yang.srb.core.pojo.entity.UserInfo;
import com.yang.srb.core.pojo.entity.query.UserInfoQuery;
import com.yang.srb.core.pojo.entity.vo.RegisterVo;
import com.yang.srb.core.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author yang
 * @date 2023/6/4 15:21
 */
@Api(tags = "会员管理")
@RestController
@RequestMapping("/admin/core/userInfo")
@Slf4j
//@CrossOrigin
public class AdminUserInfoController {

    @Resource
    private UserInfoService userInfoService;

    @ApiOperation("锁定和解锁")
    @PutMapping("/lock/{id}/{status}")
    public R lock(
            @ApiParam(value = "用户id", required = true)
            @PathVariable("id") Long id,
            @ApiParam(value = "锁定状态（0：锁定 1：解锁）", required = true)
            @PathVariable("status") Integer status){

        userInfoService.lock(id, status);
        return R.ok().message(status==1?"解锁成功":"锁定成功");
    }

    @ApiOperation("会员注册")
    @GetMapping("/list/{page}/{limit}")
    public R listPage(@ApiParam(value = "当前页码",required = true)
                      @PathVariable Long page,
                      @ApiParam(value = "每页记录数",required = true)
                      @PathVariable Long limit,
                      UserInfoQuery userInfoQuery){

        Page<UserInfo> pageParam =  new Page<>(page, limit);
        IPage<UserInfo> pageModel = userInfoService.listPage(pageParam,userInfoQuery);
        return R.ok().data("pageModel",pageModel);
    }
}
