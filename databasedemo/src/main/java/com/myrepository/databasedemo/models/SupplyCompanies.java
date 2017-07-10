package com.myrepository.databasedemo.models;

import org.litepal.crud.DataSupport;

/**
 * Created by raoxuting on 2017/7/10.
 */

public class SupplyCompanies extends DataSupport {

    private int companyId;

    private String companyName;

    private int companyPhone;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(int companyPhone) {
        this.companyPhone = companyPhone;
    }
}
