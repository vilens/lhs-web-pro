package com.lhs.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author Leonid
 * @since 2018-07-12
 */
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
	private Long id;
    /**
     * 用户名
     */
	private String username;
    /**
     * mobile
     */
	private String mobile;
	private String wxOpenid;
	private String wxAccessToken;
	private String wxNickname;
	private Integer wxSex;
	private String wxCity;
	private String wxProvince;
	private String wxCountry;
	private String wxHeadimgurl;
	private String wxPrivilege;
	private Date createTime;
	private Date updateTime;


	public Long getId() {
		return id;
	}

	public User setId(Long id) {
		this.id = id;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public User setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getMobile() {
		return mobile;
	}

	public User setMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}

	public String getWxOpenid() {
		return wxOpenid;
	}

	public User setWxOpenid(String wxOpenid) {
		this.wxOpenid = wxOpenid;
		return this;
	}

	public String getWxAccessToken() {
		return wxAccessToken;
	}

	public User setWxAccessToken(String wxAccessToken) {
		this.wxAccessToken = wxAccessToken;
		return this;
	}

	public String getWxNickname() {
		return wxNickname;
	}

	public User setWxNickname(String wxNickname) {
		this.wxNickname = wxNickname;
		return this;
	}

	public Integer getWxSex() {
		return wxSex;
	}

	public User setWxSex(Integer wxSex) {
		this.wxSex = wxSex;
		return this;
	}

	public String getWxCity() {
		return wxCity;
	}

	public User setWxCity(String wxCity) {
		this.wxCity = wxCity;
		return this;
	}

	public String getWxProvince() {
		return wxProvince;
	}

	public User setWxProvince(String wxProvince) {
		this.wxProvince = wxProvince;
		return this;
	}

	public String getWxCountry() {
		return wxCountry;
	}

	public User setWxCountry(String wxCountry) {
		this.wxCountry = wxCountry;
		return this;
	}

	public String getWxHeadimgurl() {
		return wxHeadimgurl;
	}

	public User setWxHeadimgurl(String wxHeadimgurl) {
		this.wxHeadimgurl = wxHeadimgurl;
		return this;
	}

	public String getWxPrivilege() {
		return wxPrivilege;
	}

	public User setWxPrivilege(String wxPrivilege) {
		this.wxPrivilege = wxPrivilege;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public User setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public User setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "User{" +
			"id=" + id +
			", username=" + username +
			", mobile=" + mobile +
			", wxOpenid=" + wxOpenid +
			", wxAccessToken=" + wxAccessToken +
			", wxNickname=" + wxNickname +
			", wxSex=" + wxSex +
			", wxCity=" + wxCity +
			", wxProvince=" + wxProvince +
			", wxCountry=" + wxCountry +
			", wxHeadimgurl=" + wxHeadimgurl +
			", wxPrivilege=" + wxPrivilege +
			", createTime=" + createTime +
			", updateTime=" + updateTime +
			"}";
	}
}
