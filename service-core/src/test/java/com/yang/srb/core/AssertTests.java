package com.yang.srb.core;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.tomcat.util.security.MD5Encoder;
import org.junit.Assert;
import org.junit.Test;
import sun.security.provider.MD5;

/**
 * @author yang
 * @date 2022/7/19 0:31
 */
public class AssertTests {

    @Test
    public void test3(){

        String a = DigestUtils.md5Hex("yang");
        System.out.println("a = " + a);
    }

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
