package com.rxt.retrofit.model;

/**
 * 地址bean类
 * Created by raoxuting on 2017/9/17.
 */

public class AddressBean {

    private String Recipient;

    private String Address;

    private double Mobile;

    private int TPIUserId;

    private String Area;

    public String getRecipient() {
        return Recipient;
    }

    public void setRecipient(String recipient) {
        Recipient = recipient;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public double getMobile() {
        return Mobile;
    }

    public void setMobile(double mobile) {
        Mobile = mobile;
    }

    public int getTPIUserId() {
        return TPIUserId;
    }

    public void setTPIUserId(int TPIUserId) {
        this.TPIUserId = TPIUserId;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }
}
