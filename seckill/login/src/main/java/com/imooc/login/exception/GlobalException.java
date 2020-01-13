package com.imooc.login.exception;

import com.imooc.login.results.CodeMsg;

public class GlobalException extends RuntimeException {
    private static final long servialVersionUID = 1L;
    private CodeMsg cm;
    public GlobalException(CodeMsg cm){
        super(cm.toString());
        this.cm = cm;
    }
    public CodeMsg getCm(){return cm;}
    public void setCm(CodeMsg cm){this.cm = cm;}
}
