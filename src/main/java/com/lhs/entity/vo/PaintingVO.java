package com.lhs.entity.vo;

import com.lhs.entity.Painting;
import com.lhs.entity.PaintingImages;

import java.util.List;

public class PaintingVO extends Painting {

    private String wxOpenid;

    private List<PaintingImages> images;

    public String getWxOpenid() {
        return wxOpenid;
    }

    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid;
    }

    public List<PaintingImages> getImages() {
        return images;
    }

    public void setImages(List<PaintingImages> images) {
        this.images = images;
    }
}
