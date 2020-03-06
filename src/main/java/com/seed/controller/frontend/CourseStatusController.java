package com.seed.controller.frontend;

import com.seed.converter.StatusOne2StatusOneVoConverter;
import com.seed.converter.StatusTwo2StatusTwoVoConverter;
import com.seed.model.CourseStatusOne;
import com.seed.model.CourseStatusTwo;
import com.seed.service.CourseStatusOneService;
import com.seed.service.CourseStatusTwoService;
import com.seed.util.ResultVOUtil;
import com.seed.vo.CourseStatusOneVo;
import com.seed.vo.CourseStatusTwoVo;
import com.seed.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/1 10:45
 */
@RestController
@RequestMapping("/course")
public class CourseStatusController {
    @Autowired
    private CourseStatusOneService courseStatusOneService;

    @Autowired
    private CourseStatusTwoService courseStatusTwoService;

    @PostMapping("/statusOne")
    /*@Cacheable(cacheNames = "status",key ="'one'")*/
    public ResultVO findAllCourseStatusOne(){

        List<CourseStatusOne> courseStatusOneList=courseStatusOneService.listAllCourseStatusOne();
        List<CourseStatusOneVo> courseStatusOneVoList=
                        StatusOne2StatusOneVoConverter.convert(courseStatusOneList);
        return ResultVOUtil.success(courseStatusOneVoList);
    }
    @PostMapping("/statusTwo")
    public ResultVO findAllCourseStatusTwo(){
        List<CourseStatusTwo> courseStatusTwoList=courseStatusTwoService.listAllCourseStatusTwo();
        List<CourseStatusTwoVo> courseStatusTwoVoList=
                StatusTwo2StatusTwoVoConverter.convert(courseStatusTwoList);
        return ResultVOUtil.success(courseStatusTwoVoList);
    }

}
