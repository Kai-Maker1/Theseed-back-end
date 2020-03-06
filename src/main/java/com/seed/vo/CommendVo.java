package com.seed.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/2 16:40
 */
@Data
/*@JsonInclude(JsonInclude.Include.NON_NULL)*/
public class CommendVo {
    private String title="推荐课程";
    @JsonProperty("courses")
    private List<CurriculumVo> curriculumVoList;
}
