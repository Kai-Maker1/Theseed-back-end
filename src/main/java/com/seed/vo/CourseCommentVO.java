package com.seed.vo;

import com.seed.model.CourseComment;
import lombok.Data;

import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/11 14:55
 */
@Data
public class CourseCommentVO {
    private CourseComment courseComment;

    private List<CourseComment> answers;
}
