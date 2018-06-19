package com.itrug.mobile.model;
/**
 * 手机类
 */
public class Mobile {
    //编号
    private int id;

    //手机名称
    private String  name;

    //手机价格
    private double  price;

    //手机图片路径
    private String image;

    //手机型号
    private String model;

    //生产厂商
    private String  vendor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
}

