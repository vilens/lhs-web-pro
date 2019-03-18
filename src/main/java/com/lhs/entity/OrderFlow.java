package com.lhs.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 订单流水表
 * </p>
 *
 * @author Leonid
 * @since 2018-07-12
 */
public class OrderFlow extends Model<OrderFlow> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
	private Long id;
    /**
     * 交易流水
     */
	private String orderFlowCode;
    /**
     * 第三方支付流水
     */
	private String tradingFlowCode;
    /**
     * 支付类型 1 微信 2 支付宝
     */
	private Integer paymentType;
    /**
     * 状态 1 成功 0 失败
     */
	private Integer status;
	private Date createTime;
	private Date updateTime;


	public Long getId() {
		return id;
	}

	public OrderFlow setId(Long id) {
		this.id = id;
		return this;
	}

	public String getOrderFlowCode() {
		return orderFlowCode;
	}

	public OrderFlow setOrderFlowCode(String orderFlowCode) {
		this.orderFlowCode = orderFlowCode;
		return this;
	}

	public String getTradingFlowCode() {
		return tradingFlowCode;
	}

	public OrderFlow setTradingFlowCode(String tradingFlowCode) {
		this.tradingFlowCode = tradingFlowCode;
		return this;
	}

	public Integer getPaymentType() {
		return paymentType;
	}

	public OrderFlow setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public OrderFlow setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public OrderFlow setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public OrderFlow setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "OrderFlow{" +
			"id=" + id +
			", orderFlowCode=" + orderFlowCode +
			", tradingFlowCode=" + tradingFlowCode +
			", paymentType=" + paymentType +
			", status=" + status +
			", createTime=" + createTime +
			", updateTime=" + updateTime +
			"}";
	}
}
