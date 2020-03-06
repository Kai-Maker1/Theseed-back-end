package com.seed.converter;

import com.seed.model.CourseStatusOne;
import com.seed.vo.CourseStatusOneVo;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/1 21:14
 */
public class StatusOne2StatusOneVoConverter {
    public static CourseStatusOneVo convert(CourseStatusOne courseStatusOne) {

        CourseStatusOneVo courseStatusOneVo = new CourseStatusOneVo();
        BeanUtils.copyProperties(courseStatusOne, courseStatusOneVo);
        return courseStatusOneVo;
    }
    public static List<CourseStatusOneVo> convert(List<CourseStatusOne> courseStatusOneList) {
        return courseStatusOneList.stream().map(e ->
                convert(e)
        ).collect(Collectors.toList());
    }
}
