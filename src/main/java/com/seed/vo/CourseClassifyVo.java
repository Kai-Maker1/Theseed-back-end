package com.seed.vo;

import lombok.Data;


/**
 * @Author: Li Yawei
 * @Date: 2019/2/12 13:23
 */
@Data
public class CourseClassifyVo  {
    private Integer courseClassifyId;

    private String name;

    private String parentName;

    private String code;

    private Integer sort;

    public  CourseClassifyVo(){}
    public CourseClassifyVo(Integer courseClassifyId, String name, String parentName, String code, Integer sort) {
        this.courseClassifyId = courseClassifyId;
        this.name = name;
        this.parentName = parentName;
        this.code = code;
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "CourseClassifyVo{" +
                "courseClassifyId='" + courseClassifyId + '\'' +
                ", name='" + name + '\'' +
                ", parentName='" + parentName + '\'' +
                ", code='" + code + '\'' +
                ", sort=" + sort +
                '}';
    }
}
