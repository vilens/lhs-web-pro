package com.lhs.entity.vo;

import com.lhs.entity.Classify;

import java.util.List;

/**
 * Created by Leonid on 2018/7/3.
 */
public class ClassifyVO extends Classify {

    private List<ClassifyVO> classifyVOList;

    public List<ClassifyVO> getClassifyVOList() {
        return classifyVOList;
    }

    public void setClassifyVOList(List<ClassifyVO> classifyVOList) {
        this.classifyVOList = classifyVOList;
    }
}
