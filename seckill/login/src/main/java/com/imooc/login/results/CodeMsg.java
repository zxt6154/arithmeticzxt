package com.imooc.login.results;

public class CodeMsg {
    private int code;
    private String msg;
    //
    public static CodeMsg SUCCESS = new CodeMsg(0,"success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100,"服务端异常");
    public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500211,"密码不能为空");
    public static CodeMsg MOBILE_EMPTY = new CodeMsg(500212,"手机号不能为空");
    public static CodeMsg MOBILE_ERROR  = new CodeMsg(500213,"手机号格式错误");
    public static CodeMsg MOBILE_NOTEXIST = new CodeMsg(500214,"手机号不存在");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(500215,"密码输入错误");
    public static CodeMsg BIND_ERROR = new CodeMsg(500215,"参数校验错误： %$");
    //

    public CodeMsg(int code,String msg){
        this.code = code;
        this.msg = msg;
    }
    public CodeMsg(){}
    public CodeMsg findArgs(Object ... args){
        int code = this.code;
        String message = String.format(this.msg,args);
        return new CodeMsg(code,message);
    }







    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
