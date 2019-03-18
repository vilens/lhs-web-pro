package com.lhs.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 收货信息表
 * </p>
 *
 * @author Leonid
 * @since 2018-07-12
 */
public class RecipientInfo extends Model<RecipientInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
	private Long id;
	private Long userId;
    /**
     * 收件人
     */
	private String recipient;
    /**
     * 详细地址
     */
	private String address;
	private Date createTime;


	public Long getId() {
		return id;
	}

	public RecipientInfo setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getUserId() {
		return userId;
	}

	public RecipientInfo setUserId(Long userId) {
		this.userId = userId;
		return this;
	}

	public String getRecipient() {
		return recipient;
	}

	public RecipientInfo setRecipient(String recipient) {
		this.recipient = recipient;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public RecipientInfo setAddress(String address) {
		this.address = address;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public RecipientInfo setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "RecipientInfo{" +
			"id=" + id +
			", userId=" + userId +
			", recipient=" + recipient +
			", address=" + address +
			", createTime=" + createTime +
			"}";
	}
}
