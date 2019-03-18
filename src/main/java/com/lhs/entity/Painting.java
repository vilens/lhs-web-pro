package com.lhs.entity;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 画作表
 * </p>
 *
 * @author Leonid
 * @since 2018-07-12
 */
public class Painting extends Model<Painting> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
	private Long id;
    /**
     * 画作名称
     */
	private String name;
    /**
     * 用户id
     */
	private Long userId;
    /**
     * 画家id
     */
	private Long painterId;
    /**
     * 分类id
     */
	private Long classifyId;
    /**
     * 作品url地址
     */
	private String url;
    /**
     * 作品价格
     */
	private BigDecimal price;
    /**
     * 0 未装裱 1 已装裱
     */
	private Integer paintingMount;
    /**
     * 材质
     */
	private String materialQuality;
    /**
     * 宽
     */
	private Integer width;
    /**
     * 高
     */
	private Integer height;
    /**
     * 所在地
     */
	private String location;
	/**
	 * 权重值
	 */
	private Integer weight;
    /**
     * 创作年份
     */
	private String drawYear;
    /**
     * 0 不可出售 1 可出售
     */
	private Integer salability;
    /**
     * 0 未售出 1 已售出
     */
	private Integer status;
    /**
     * 作者手札
     */
	private String personalLetter;
	private Date createTime;
	private Date modifyTime;
    /**
     * 0 已删除 1 未删除
     */
	private Integer delFlag;



	public Long getId() {
		return id;
	}

	public Painting setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Painting setName(String name) {
		this.name = name;
		return this;
	}

	public Integer getWeight() {
		return weight;
	}

	public Painting setWeight(Integer weight) {
		this.weight = weight;
		return this;
	}

	public Long getUserId() {
		return userId;
	}

	public Painting setUserId(Long userId) {
		this.userId = userId;
		return this;
	}

	public Long getPainterId() {
		return painterId;
	}

	public Painting setPainterId(Long painterId) {
		this.painterId = painterId;
		return this;
	}

	public Long getClassifyId() {
		return classifyId;
	}

	public Painting setClassifyId(Long classifyId) {
		this.classifyId = classifyId;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public Painting setUrl(String url) {
		this.url = url;
		return this;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Painting setPrice(BigDecimal price) {
		this.price = price;
		return this;
	}

	public Integer getPaintingMount() {
		return paintingMount;
	}

	public Painting setPaintingMount(Integer paintingMount) {
		this.paintingMount = paintingMount;
		return this;
	}

	public String getMaterialQuality() {
		return materialQuality;
	}

	public Painting setMaterialQuality(String materialQuality) {
		this.materialQuality = materialQuality;
		return this;
	}

	public Integer getWidth() {
		return width;
	}

	public Painting setWidth(Integer width) {
		this.width = width;
		return this;
	}

	public Integer getHeight() {
		return height;
	}

	public Painting setHeight(Integer height) {
		this.height = height;
		return this;
	}

	public String getLocation() {
		return location;
	}

	public Painting setLocation(String location) {
		this.location = location;
		return this;
	}

	public String getDrawYear() {
		return drawYear;
	}

	public Painting setDrawYear(String drawYear) {
		this.drawYear = drawYear;
		return this;
	}

	public Integer getSalability() {
		return salability;
	}

	public Painting setSalability(Integer salability) {
		this.salability = salability;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public Painting setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public String getPersonalLetter() {
		return personalLetter;
	}

	public Painting setPersonalLetter(String personalLetter) {
		this.personalLetter = personalLetter;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Painting setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public Painting setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
		return this;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public Painting setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Painting{" +
			"id=" + id +
			", name=" + name +
			", userId=" + userId +
			", painterId=" + painterId +
			", classifyId=" + classifyId +
			", url=" + url +
			", price=" + price +
			", paintingMount=" + paintingMount +
			", materialQuality=" + materialQuality +
			", width=" + width +
			", height=" + height +
			", location=" + location +
			", drawYear=" + drawYear +
			", salability=" + salability +
			", status=" + status +
			", personalLetter=" + personalLetter +
			", createTime=" + createTime +
			", modifyTime=" + modifyTime +
			", delFlag=" + delFlag +
			"}";
	}
}
