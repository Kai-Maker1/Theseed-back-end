package com.seed.vo;

import com.seed.model.CourseSection;
import lombok.Data;

import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/6 17:06
 */
@Data
public class CourseSectionVo {
    private String chapterName;
    private List<CourseSection> sectionList;
}
