package com.imooc.login.redis;

public interface KeyPrefix {
    public int expireSeconds();
    public String getPrefix();
}
