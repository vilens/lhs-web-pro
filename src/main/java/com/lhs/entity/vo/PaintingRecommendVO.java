package com.lhs.entity.vo;

import java.io.Serializable;

/**
 * Created by Leonid on 2018/7/13.
 */
public class PaintingRecommendVO implements Serializable {

    private Long painterId;

    private String painterName;

    private Integer isLike = 0;

    private Integer isFollow = 0;

    private Long paintingId;

    private String paintintName;

    private String paintingUrl;

    private String paintingDesc;

    public Long getPainterId() {
        return painterId;
    }

    public void setPainterId(Long painterId) {
        this.painterId = painterId;
    }

    public String getPainterName() {
        return painterName;
    }

    public void setPainterName(String painterName) {
        this.painterName = painterName;
    }

    public Integer getIsLike() {
        return isLike;
    }

    public void setIsLike(Integer isLike) {
        this.isLike = isLike;
    }

    public Integer getIsFollow() {
        return isFollow;
    }

    public void setIsFollow(Integer isFollow) {
        this.isFollow = isFollow;
    }

    public Long getPaintingId() {
        return paintingId;
    }

    public void setPaintingId(Long paintingId) {
        this.paintingId = paintingId;
    }

    public String getPaintintName() {
        return paintintName;
    }

    public void setPaintintName(String paintintName) {
        this.paintintName = paintintName;
    }

    public String getPaintingUrl() {
        return paintingUrl;
    }

    public void setPaintingUrl(String paintingUrl) {
        this.paintingUrl = paintingUrl;
    }

    public String getPaintingDesc() {
        return paintingDesc;
    }

    public void setPaintingDesc(String paintingDesc) {
        this.paintingDesc = paintingDesc;
    }
}
