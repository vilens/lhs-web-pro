package com.lhs.entity;

import java.io.Serializable;

import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;

import java.io.Serializable;

/**
 * <p>
 * 画家表
 * </p>
 *
 * @author Leonid
 * @since 2018-07-12
 */
public class Painter extends Model<Painter> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long id;
    private Long userId;
    /**
     * 画家姓名
     */
    private String name;
    private String city;
    /**
     * 画家头像地址
     */
    private String headUrl;
    /**
     * 身价
     */
    private String painterValue;
    /**
     * 性别
     */
    private Integer sex;
    private Date birthday;
    /**
     * 简介
     */
    private String summary;
    private Date createTime;
    /**
     * 0 已删除 1 未删除
     */
    private Integer delFlag;


    public Long getId() {
        return id;
    }

    public Painter setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public Painter setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Painter setName(String name) {
        this.name = name;
        return this;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public Painter setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
        return this;
    }

    public String getPainterValue() {
        return painterValue;
    }

    public Painter setPainterValue(String painterValue) {
        this.painterValue = painterValue;
        return this;
    }

    public Integer getSex() {
        return sex;
    }

    public Painter setSex(Integer sex) {
        this.sex = sex;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Painter setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getSummary() {
        return summary;
    }

    public Painter setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Painter setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public Painter setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Painter{" +
                "id=" + id +
                ", userId=" + userId +
                ", name=" + name +
                ", city=" + city +
                ", headUrl=" + headUrl +
                ", painterValue=" + painterValue +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", summary=" + summary +
                ", createTime=" + createTime +
                ", delFlag=" + delFlag +
                "}";
    }
}
