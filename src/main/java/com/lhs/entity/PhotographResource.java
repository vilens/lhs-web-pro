package com.lhs.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 摄影图片表
 * </p>
 *
 * @author Leonid
 * @since 2018-07-12
 */
public class PhotographResource extends Model<PhotographResource> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
	private Long id;
    /**
     * 名称
     */
	private String name;
    /**
     * 图片url地址
     */
	private String url;
    /**
     * md5加密
     */
	private String md5;
    /**
     * 摄影图片标签id
     */
	private Long photographTagId;
	private Date createTime;


	public Long getId() {
		return id;
	}

	public PhotographResource setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public PhotographResource setName(String name) {
		this.name = name;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public PhotographResource setUrl(String url) {
		this.url = url;
		return this;
	}

	public String getMd5() {
		return md5;
	}

	public PhotographResource setMd5(String md5) {
		this.md5 = md5;
		return this;
	}

	public Long getPhotographTagId() {
		return photographTagId;
	}

	public PhotographResource setPhotographTagId(Long photographTagId) {
		this.photographTagId = photographTagId;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public PhotographResource setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "PhotographResource{" +
			"id=" + id +
			", name=" + name +
			", url=" + url +
			", md5=" + md5 +
			", photographTagId=" + photographTagId +
			", createTime=" + createTime +
			"}";
	}
}
