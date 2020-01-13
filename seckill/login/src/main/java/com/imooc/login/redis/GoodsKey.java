package com.imooc.login.redis;

public class GoodsKey extends BasePrefix{


    public GoodsKey(int expireSeconds, String prefix) { super(expireSeconds, prefix); }
    public GoodsKey(String prefix) {
        super(prefix);
    }
    public static GoodsKey getGoodsList = new GoodsKey(60,"gl");
    public static GoodsKey getGoodsDetail = new GoodsKey(60,"gd");

}
