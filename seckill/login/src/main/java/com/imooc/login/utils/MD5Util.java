package com.imooc.login.utils;

import com.imooc.login.domain.User;
import com.imooc.login.service.serviceImpl.UserServiceImpl;
import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {
    //
    public static String md5(String str){
        return DigestUtils.md2Hex(str);
    }
    private static final String SALTVAR = "zxt123456";


    //输入->页面密码加密
    public static String inputPassFormPass(String inputPass){
        String strsalt = SALTVAR .charAt(0) + SALTVAR .charAt(2) + inputPass + SALTVAR .charAt(6) + SALTVAR .charAt(8);
        return md5(strsalt);
    }
    //页面->数据库密码加密
    public static String formPassDBPass(String formPass,String saltDB){
        String strsalt = saltDB.charAt(0) + saltDB.charAt(2) + formPass + saltDB.charAt(6) + saltDB.charAt(8);
        return md5(strsalt);
    }
    //输入->页面->数据库密码加密
    //明文密码转换成数据库密码
    public static String inputPassToDBPass(String inputPass,String salt){
        String formPass = inputPassFormPass(inputPass);
        String DBPass = formPassDBPass(formPass,salt);
        return DBPass;
    }
/*
    public static void main(String[] args) {
        String dbPass = MD5Util.inputPassToDBPass("Richard123", "zxt123456");
        System.out.println(dbPass);
    }*/
}
