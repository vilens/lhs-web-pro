package com.lhs.entity.vo;

import com.lhs.entity.RecipientInfo;

import java.io.Serializable;

public class RecipientInfoVO implements Serializable {
    private RecipientInfo recipientInfo;
    private String wxOpenid;

    public String getWxOpenid() {
        return wxOpenid;
    }

    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid;
    }

    public RecipientInfo getRecipientInfo() {
        return recipientInfo;
    }

    public void setRecipientInfo(RecipientInfo recipientInfo) {
        this.recipientInfo = recipientInfo;
    }
}
