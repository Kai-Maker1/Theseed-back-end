package com.seed.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/2 18:20
 */
@Data
public class CourseVo {
    @JsonProperty("collegeId")
    private String teacherCollegeId;

    @JsonProperty("status")
    private String userJoinStatus;

    @JsonProperty("course")
    private CurriculumVo curriculumVo;
}
