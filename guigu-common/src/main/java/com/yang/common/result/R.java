package com.yang.common.result;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yang
 * @date 2022/7/17 17:43
 */
@Data
public class R {

    private Integer code;
    private String message;
    private Map<String,Object> data = new HashMap<>();

    /**
     * 构造器私有
     */
    private R (){}

    /**
     * 返回失败结果
     * @return
     */
    public static R error(){
        R r = new R();
        r.setCode(ResponseEnum.EOORO.getCode());
        r.setMessage(ResponseEnum.EOORO.getMessage());
        return r;
    }

    /**
     * 返回失败成功
     * @return
     */
    public static R ok(){
        R r = new R();
        r.setCode(ResponseEnum.SUCCESS.getCode());
        r.setMessage(ResponseEnum.SUCCESS.getMessage());
        return r;
    }

    /**
     * 设置特定的结果
     * @param responseEnum
     * @return
     */
    public static R setResult(ResponseEnum responseEnum){
        R r = new R();
        r.setCode(responseEnum.getCode());
        r.setMessage(responseEnum.getMessage());
        return r;
    }

    public R data(String key,Object value){
        this.data.put(key,value);
        return this;
    }

    public R data(Map<String,Object> map){
        this.setData(map);
        return this;
    }

    /**
     * 设置特定的响应信息
     * @param message
     * @return
     */
    public R message(String message){
        this.setMessage(message);
        return this;
    }

    /**
     * 设置特定的响应信息
     * @param code
     * @return
     */
    public R code(Integer code){
        this.setCode(code);
        return this;
    }


}
