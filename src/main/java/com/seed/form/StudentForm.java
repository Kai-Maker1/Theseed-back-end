package com.seed.form;

import lombok.Data;

import java.util.Date;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/20 20:44
 */
@Data
public class StudentForm {
    private String stuId;

    private String stuName;

    private String openId;

    private String nickname;

    private Boolean gender;

    private String header;

    private Boolean status;

    private String majorId;

    private String classId;

    private String collegeId;

    private Date createTime;

    private Date updateTime;
}
