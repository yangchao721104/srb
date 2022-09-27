package com.yang.srb.core;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author yang
 * @date 2022/7/19 0:31
 */
public class AssertTests {

    @Test
    public void test1(){
        Object o = null;
        if (o ==null){
            throw new IllegalArgumentException("参数错误");
        }
    }

    @Test
    public void test2(){
        Object o = null;
        Assert.assertNotNull("参数错误",o);
    }
}
