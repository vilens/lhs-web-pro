package com.lhs.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 画家标签关系表
 * </p>
 *
 * @author Leonid
 * @since 2018-07-12
 */
public class PainterTagRelation extends Model<PainterTagRelation> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
	private Long id;
    /**
     * 画家id
     */
	private Long painterId;
    /**
     * 画家标签id
     */
	private Long painterTagId;


	public Long getId() {
		return id;
	}

	public PainterTagRelation setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getPainterId() {
		return painterId;
	}

	public PainterTagRelation setPainterId(Long painterId) {
		this.painterId = painterId;
		return this;
	}

	public Long getPainterTagId() {
		return painterTagId;
	}

	public PainterTagRelation setPainterTagId(Long painterTagId) {
		this.painterTagId = painterTagId;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "PainterTagRelation{" +
			"id=" + id +
			", painterId=" + painterId +
			", painterTagId=" + painterTagId +
			"}";
	}
}
