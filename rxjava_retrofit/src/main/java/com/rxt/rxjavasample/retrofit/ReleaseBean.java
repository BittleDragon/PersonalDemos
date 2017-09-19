package com.rxt.rxjavasample.retrofit;

/**
 * 发布需求bean类
 * Created by raoxuting on 2017/9/19.
 */

public class ReleaseBean {

    private String QuestionContent;

    private String ContactName;

    private double ContactTel;

    public String getQuestionContent() {
        return QuestionContent;
    }

    public void setQuestionContent(String questionContent) {
        QuestionContent = questionContent;
    }

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String contactName) {
        ContactName = contactName;
    }

    public double getContactTel() {
        return ContactTel;
    }

    public void setContactTel(double contactTel) {
        ContactTel = contactTel;
    }
}
