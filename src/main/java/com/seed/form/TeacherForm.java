package com.seed.form;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.seed.util.serializer.Date2StringSerializer;
import lombok.Data;

import java.util.Date;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/20 9:39
 */
@Data
public class TeacherForm {

    private String teacherId;

    private String teacherName;

    private String openId;

    private String nickname;

    private Boolean gender;

    private String header;

    private Boolean status;

    private String collegeId;
   /* @JsonSerialize(using = Date2StringSerializer.class)*/
    private Date createTime;

    private Date updateTime;
}
