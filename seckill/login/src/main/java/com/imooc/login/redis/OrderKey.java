package com.imooc.login.redis;

public class OrderKey extends BasePrefix {

    public OrderKey(String prefix) {
        super(prefix);
    }
    public static OrderKey getPurchaseOrderByUidGid = new OrderKey("purchaseOrderUidGid");
}