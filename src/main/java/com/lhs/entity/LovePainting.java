package com.lhs.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 喜欢作品表
 * </p>
 *
 * @author Leonid
 * @since 2018-07-12
 */
public class LovePainting extends Model<LovePainting> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
	private Long id;
	private Long userId;
    /**
     * 画作id
     */
	private Long paintingId;
	private Date createTime;


	public Long getId() {
		return id;
	}

	public LovePainting setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getUserId() {
		return userId;
	}

	public LovePainting setUserId(Long userId) {
		this.userId = userId;
		return this;
	}

	public Long getPaintingId() {
		return paintingId;
	}

	public LovePainting setPaintingId(Long paintingId) {
		this.paintingId = paintingId;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public LovePainting setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "LovePainting{" +
			"id=" + id +
			", userId=" + userId +
			", paintingId=" + paintingId +
			", createTime=" + createTime +
			"}";
	}
}
