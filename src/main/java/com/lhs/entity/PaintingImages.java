package com.lhs.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;

import java.io.Serializable;

/**
 * <p>
 * 补充图片表
 * </p>
 *
 * @author Leonid
 * @since 2018-07-12
 */
public class PaintingImages extends Model<PaintingImages> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
	private Long id;
    /**
     * 画作id
     */
	private Long paintingId;
    /**
     * 图片url地址
     */
	private String imgUrl;
	private Date createTime;
    /**
     * 0 已删除 1 未删除
     */
	private Integer delFlag;


	public Long getId() {
		return id;
	}

	public PaintingImages setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getPaintingId() {
		return paintingId;
	}

	public PaintingImages setPaintingId(Long paintingId) {
		this.paintingId = paintingId;
		return this;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public PaintingImages setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public PaintingImages setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public PaintingImages setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "PaintingImages{" +
			"id=" + id +
			", paintingId=" + paintingId +
			", imgUrl=" + imgUrl +
			", createTime=" + createTime +
			", delFlag=" + delFlag +
			"}";
	}
}
