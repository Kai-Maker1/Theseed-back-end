package com.seed.converter;


import com.seed.model.CourseClassify;
import com.seed.vo.CourseClassifyVo;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 廖师兄
 * 2017-06-11 22:02
 */
public class CourseClassify2CourseClassifyCoConverter {

    public static CourseClassifyVo convert(CourseClassify courseClassify) {

        CourseClassifyVo courseClassifyVo = new CourseClassifyVo();
        BeanUtils.copyProperties(courseClassify, courseClassifyVo);
        return courseClassifyVo;
    }
    public static List<CourseClassifyVo> convert(List<CourseClassify> courseClassifyList) {
        return courseClassifyList.stream().map(e ->
                convert(e)
        ).collect(Collectors.toList());
    }
}
