package com.lhs.entity.vo;

import com.lhs.entity.Painter;
import com.lhs.entity.Painting;

import java.util.List;

public class PainterVO extends Painter {
    private String wxOpenid;
    private List<Painting> paintingList;
    private Integer followCount;
    private Integer fansCount;
    private Integer paintingCount;
    private Integer soldCount;

    public String getWxOpenid() {
        return wxOpenid;
    }

    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid;
    }

    public List<Painting> getPaintingList() {
        return paintingList;
    }

    public void setPaintingList(List<Painting> paintingList) {
        this.paintingList = paintingList;
    }

    public Integer getFollowCount() {
        return followCount;
    }

    public void setFollowCount(Integer followCount) {
        this.followCount = followCount;
    }

    public Integer getFansCount() {
        return fansCount;
    }

    public void setFansCount(Integer fansCount) {
        this.fansCount = fansCount;
    }

    public Integer getPaintingCount() {
        return paintingCount;
    }

    public void setPaintingCount(Integer paintingCount) {
        this.paintingCount = paintingCount;
    }

    public Integer getSoldCount() {
        return soldCount;
    }

    public void setSoldCount(Integer soldCount) {
        this.soldCount = soldCount;
    }
}
