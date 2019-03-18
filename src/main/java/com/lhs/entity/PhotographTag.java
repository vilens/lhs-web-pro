package com.lhs.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 摄影标签表
 * </p>
 *
 * @author Leonid
 * @since 2018-07-12
 */
public class PhotographTag extends Model<PhotographTag> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
	private Long id;
    /**
     * 地点
     */
	private String place;
    /**
     * 时间字符串
     */
	private String time;
    /**
     * 活动名称
     */
	private String activity;
    /**
     * 摄影师
     */
	private String photographer;
	private Date createTime;


	public Long getId() {
		return id;
	}

	public PhotographTag setId(Long id) {
		this.id = id;
		return this;
	}

	public String getPlace() {
		return place;
	}

	public PhotographTag setPlace(String place) {
		this.place = place;
		return this;
	}

	public String getTime() {
		return time;
	}

	public PhotographTag setTime(String time) {
		this.time = time;
		return this;
	}

	public String getActivity() {
		return activity;
	}

	public PhotographTag setActivity(String activity) {
		this.activity = activity;
		return this;
	}

	public String getPhotographer() {
		return photographer;
	}

	public PhotographTag setPhotographer(String photographer) {
		this.photographer = photographer;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public PhotographTag setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "PhotographTag{" +
			"id=" + id +
			", place=" + place +
			", time=" + time +
			", activity=" + activity +
			", photographer=" + photographer +
			", createTime=" + createTime +
			"}";
	}
}
