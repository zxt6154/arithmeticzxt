package com.imooc.login.redis;

public class UserKey extends BasePrefix {

    public static final int TOKEN_EXPIRE = 3600*24*2;


    public UserKey(int expireSeconds, String prefix) {
        super( prefix);
    }
    private UserKey(String prefix) {
        super(prefix);
    }

    public static UserKey token = new UserKey(TOKEN_EXPIRE,"tk");
    public static UserKey getById = new UserKey(0,"id");
    //public static UserKey getById = new UserKey("id");
    public static UserKey getByName = new UserKey("name");
}
