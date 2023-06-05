package com.yang.srb.core.pojo.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yang
 * @date 2023/6/5 2:04
 */
@Data
@ApiModel(description = "账户绑定")
public class UserBindVo {

    @ApiModelProperty(value = "身份证号")
    private String idCard;

    @ApiModelProperty(value = "用户姓名")
    private String name;

    @ApiModelProperty(value = "银行类型")
    private String bankType;

    @ApiModelProperty(value = "银行卡号")
    private String bankNo;

    @ApiModelProperty(value = "手机号")
    private String mobile;
}
