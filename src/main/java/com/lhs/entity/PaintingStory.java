package com.lhs.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 画作心路
 * </p>
 *
 * @author Leonid
 * @since 2018-07-12
 */
public class PaintingStory extends Model<PaintingStory> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
	private Long id;
    /**
     * 标题
     */
	private String title;
    /**
     * 故事图片url地址
     */
	private String imageUrl;
    /**
     * 故事详细
     */
	private String desc;
    /**
     * 排序
     */
	private Integer sort;
    /**
     * 画作id
     */
	private Long paintingId;
    /**
     * 作者名称
     */
	private String author;
    /**
     * 作者id
     */
	private Long authorId;
    /**
     * 1 文本 2 图片
     */
	private Integer type;
    /**
     * 浏览量
     */
	private Integer browseCount;
    /**
     * 点赞量
     */
	private Integer likes;
	private Date createTime;
	private Date modifyTime;
    /**
     * 0 已删除 1 未删除
     */
	private Integer delFlag;


	public Long getId() {
		return id;
	}

	public PaintingStory setId(Long id) {
		this.id = id;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public PaintingStory setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public PaintingStory setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
		return this;
	}

	public String getDesc() {
		return desc;
	}

	public PaintingStory setDesc(String desc) {
		this.desc = desc;
		return this;
	}

	public Integer getSort() {
		return sort;
	}

	public PaintingStory setSort(Integer sort) {
		this.sort = sort;
		return this;
	}

	public Long getPaintingId() {
		return paintingId;
	}

	public PaintingStory setPaintingId(Long paintingId) {
		this.paintingId = paintingId;
		return this;
	}

	public String getAuthor() {
		return author;
	}

	public PaintingStory setAuthor(String author) {
		this.author = author;
		return this;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public PaintingStory setAuthorId(Long authorId) {
		this.authorId = authorId;
		return this;
	}

	public Integer getType() {
		return type;
	}

	public PaintingStory setType(Integer type) {
		this.type = type;
		return this;
	}

	public Integer getBrowseCount() {
		return browseCount;
	}

	public PaintingStory setBrowseCount(Integer browseCount) {
		this.browseCount = browseCount;
		return this;
	}

	public Integer getLikes() {
		return likes;
	}

	public PaintingStory setLikes(Integer likes) {
		this.likes = likes;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public PaintingStory setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public PaintingStory setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
		return this;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public PaintingStory setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "PaintingStory{" +
			"id=" + id +
			", title=" + title +
			", imageUrl=" + imageUrl +
			", desc=" + desc +
			", sort=" + sort +
			", paintingId=" + paintingId +
			", author=" + author +
			", authorId=" + authorId +
			", type=" + type +
			", browseCount=" + browseCount +
			", likes=" + likes +
			", createTime=" + createTime +
			", modifyTime=" + modifyTime +
			", delFlag=" + delFlag +
			"}";
	}
}
