package com.seed.converter;

import com.seed.model.CourseStatusTwo;
import com.seed.vo.CourseStatusTwoVo;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/1 21:57
 */
public class StatusTwo2StatusTwoVoConverter {
    public static CourseStatusTwoVo convert(CourseStatusTwo courseStatusTwo) {

        CourseStatusTwoVo courseStatusTwoVo = new CourseStatusTwoVo();
        BeanUtils.copyProperties(courseStatusTwo, courseStatusTwoVo);
        return courseStatusTwoVo;
    }
    public static List<CourseStatusTwoVo> convert(List<CourseStatusTwo> courseStatusTwoList) {
        return courseStatusTwoList.stream().map(e ->
                convert(e)
        ).collect(Collectors.toList());
    }
}
