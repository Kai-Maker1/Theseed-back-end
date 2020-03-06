package com.seed.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.seed.util.serializer.Date2StringSerializer;
import lombok.Data;

import java.util.Date;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/1 23:26
 */
@Data
/*成员变量为NULL时,在json中不显示,已在yml中进行全局配置*/
/*@JsonInclude(JsonInclude.Include.NON_NULL)*/
public class CurriculumVo {
    /*课程ID*/
    private String courseId;

    /*课程名称*/
    private String courseName;

    /*参与人数*/
    private Integer studyCount;

    /*老师ID*/
    private String teacherId;

    /*老师姓名*/
    private String teacherName;

    /*课程介绍*/
    private String brief;

    /*图片url*/
    private String picture;

    /*课程一级分类ID*/
    private Integer classifyId;

    /*课程一级分类名称*/
    private String classifyName;

    @JsonSerialize(using = Date2StringSerializer.class)
    private Date begintime;

    @JsonSerialize(using = Date2StringSerializer.class)
    private Date endtime;

    /*private String status;*/

    private String icon;

    private Boolean recommend;

    private Integer weight;

    @JsonSerialize(using = Date2StringSerializer.class)
    private Date createTime;

    @JsonSerialize(using = Date2StringSerializer.class)
    private Date updateTime;

    private Boolean del;

    private Integer subClassifyId;

    private String subClassifyName;

    /*private Integer subClassifyId;

    private String subClassifyName;

    private String level;

    private Boolean free;

    private BigDecimal price;*/

}
