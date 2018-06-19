package com.itrug.mobile.model;

import java.util.Date;

/**
 * 订单类
 */
public class Order {
    //编号
    private int id;

    //用户编号
    private int userId;

    //手机编号
    private int mobileId;

    //商品总价格
    private double price;

    //商品数量
    private int number;

    //支付状态  支付/未支付
    private boolean isPay;

    //创建时间
    private Date crateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMobileId() {
        return mobileId;
    }

    public void setMobileId(int mobileId) {
        this.mobileId = mobileId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isPay() {
        return isPay;
    }

    public void setPay(boolean pay) {
        isPay = pay;
    }

    public Date getCrateTime() {
        return crateTime;
    }

    public void setCrateTime(Date crateTime) {
        this.crateTime = crateTime;
    }
}
