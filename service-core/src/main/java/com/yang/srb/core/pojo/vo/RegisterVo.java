package com.yang.srb.core.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yang
 * @date 2023/6/4 2:36
 */
@Data
public class RegisterVo {

    @ApiModelProperty(value = "用戶類型")
    private Integer UserType;
    @ApiModelProperty(value = "手機號")
    private String mobile;
    @ApiModelProperty(value = "验证码")
    private String code;
    @ApiModelProperty(value = "密码")
    private String password;

}
