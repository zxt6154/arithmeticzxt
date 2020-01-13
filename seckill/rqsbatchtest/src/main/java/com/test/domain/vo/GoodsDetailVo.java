package com.test.domain.vo;


import com.test.domain.PurchaseUser;

public class GoodsDetailVo {
    private int purchaseStatus = 0;
    private int remainSeconds = 0;
    private GoodsVo goods ;
    private PurchaseUser user;
    public int getPurchaseStatus() {
        return purchaseStatus;
    }
    public void setPurchaseStatus(int purchaseStatus) {
        this.purchaseStatus = purchaseStatus;
    }
    public int getRemainSeconds() {
        return remainSeconds;
    }
    public void setRemainSeconds(int remainSeconds) {
        this.remainSeconds = remainSeconds;
    }
    public GoodsVo getGoods() {
        return goods;
    }
    public void setGoods(GoodsVo goods) {
        this.goods = goods;
    }
    public PurchaseUser getUser() {
        return user;
    }
    public void setUser(PurchaseUser user) {
        this.user = user;
    }
}
