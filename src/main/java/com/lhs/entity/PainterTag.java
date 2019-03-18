package com.lhs.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 画家标签
 * </p>
 *
 * @author Leonid
 * @since 2018-07-12
 */
public class PainterTag extends Model<PainterTag> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
	private Long id;
    /**
     * 标签名称
     */
	private String name;


	public Long getId() {
		return id;
	}

	public PainterTag setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public PainterTag setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "PainterTag{" +
			"id=" + id +
			", name=" + name +
			"}";
	}
}
