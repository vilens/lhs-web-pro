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
public class FollowPainter extends Model<FollowPainter> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
	private Long id;
	private Long userId;
    /**
     * 画家id
     */
	private Long painterId;
    /**
     * 画家id
     */
	private Long painterUserId;
	private Date createTime;


	public Long getId() {
		return id;
	}

	public FollowPainter setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getUserId() {
		return userId;
	}

	public FollowPainter setUserId(Long userId) {
		this.userId = userId;
		return this;
	}

	public Long getPainterId() {
		return painterId;
	}

	public FollowPainter setPainterId(Long painterId) {
		this.painterId = painterId;
		return this;
	}

	public Long getPainterUserId() {
		return painterUserId;
	}

	public FollowPainter setPainterUserId(Long painterUserId) {
		this.painterUserId = painterUserId;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public FollowPainter setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "FollowPainter{" +
			"id=" + id +
			", userId=" + userId +
			", painterId=" + painterId +
			", painterUserId=" + painterUserId +
			", createTime=" + createTime +
			"}";
	}
}
