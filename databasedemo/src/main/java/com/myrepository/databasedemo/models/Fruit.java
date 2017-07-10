package com.myrepository.databasedemo.models;

import org.litepal.crud.DataSupport;

/**
 * 水果模型
 * Created by raoxuting on 2017/7/10.
 */

public class Fruit extends DataSupport{

    private String name;

    private double price;

    private String origin;

    private String priceUnit;

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
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

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
