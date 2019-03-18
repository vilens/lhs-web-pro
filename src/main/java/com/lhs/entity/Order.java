package com.lhs.entity;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author Leonid
 * @since 2018-07-12
 */
public class Order extends Model<Order> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
	private Long id;
    /**
     * 订单号
     */
	private String orderCode;
    /**
     * 订单名称
     */
	private String name;
    /**
     * 画作id
     */
	private Long paintingId;
    /**
     * 买方id
     */
	private Long purchaserId;
    /**
     * 卖方id
     */
	private Long sellerId;
    /**
     * 成交价格
     */
	private BigDecimal price;
    /**
     * 订单状态 0.待付款 1.已付款 （用户创建完订单，付款） 2.已发货  （买家已经发货） 3.交易完成 （完成所有流程） 4.交易取消 （买家或者买家取消订单）
     */
	private Integer status;
    /**
     * 支付类型 1 微信 2 支付宝
     */
	private Integer paymentType;
    /**
     * 订单明细
     */
	private String desc;
    /**
     * 付款时间
     */
	private Date paymentTime;
	private Date createTime;
	private Date updateTime;


	public Long getId() {
		return id;
	}

	public Order setId(Long id) {
		this.id = id;
		return this;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public Order setOrderCode(String orderCode) {
		this.orderCode = orderCode;
		return this;
	}

	public String getName() {
		return name;
	}

	public Order setName(String name) {
		this.name = name;
		return this;
	}

	public Long getPaintingId() {
		return paintingId;
	}

	public Order setPaintingId(Long paintingId) {
		this.paintingId = paintingId;
		return this;
	}

	public Long getPurchaserId() {
		return purchaserId;
	}

	public Order setPurchaserId(Long purchaserId) {
		this.purchaserId = purchaserId;
		return this;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public Order setSellerId(Long sellerId) {
		this.sellerId = sellerId;
		return this;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Order setPrice(BigDecimal price) {
		this.price = price;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public Order setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public Integer getPaymentType() {
		return paymentType;
	}

	public Order setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
		return this;
	}

	public String getDesc() {
		return desc;
	}

	public Order setDesc(String desc) {
		this.desc = desc;
		return this;
	}

	public Date getPaymentTime() {
		return paymentTime;
	}

	public Order setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Order setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public Order setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Order{" +
			"id=" + id +
			", orderCode=" + orderCode +
			", name=" + name +
			", paintingId=" + paintingId +
			", purchaserId=" + purchaserId +
			", sellerId=" + sellerId +
			", price=" + price +
			", status=" + status +
			", paymentType=" + paymentType +
			", desc=" + desc +
			", paymentTime=" + paymentTime +
			", createTime=" + createTime +
			", updateTime=" + updateTime +
			"}";
	}
}
