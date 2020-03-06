package com.seed.controller.frontend;

import com.seed.converter.CourseClassify2CourseClassifyCoConverter;
import com.seed.model.CourseClassify;
import com.seed.service.CourseClassifyService;
import com.seed.util.ResultVOUtil;
import com.seed.vo.CourseClassifyVo;
import com.seed.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/classify")
@CacheConfig(cacheNames = "classify")
public class CourseClassifyController {
    private Logger logger = LoggerFactory.getLogger(CourseClassifyController.class);
    @Autowired
    private CourseClassifyService courseClassifyService;
    @PostMapping("/findAll")
    @Cacheable(keyGenerator = "keyGenerator")
    public ResultVO findAllClassify(){
        logger.info("查询课程分类列表！");

        List<CourseClassify> courseClassifies=courseClassifyService.listAllClassify();
        List<CourseClassifyVo> courseClassifyVoList=
                CourseClassify2CourseClassifyCoConverter.convert(courseClassifies);

        logger.info("返回数据成功！");
        return ResultVOUtil.success(courseClassifyVoList);
    }
    /*==========================================================================*/
    @GetMapping("/findfirstclassify")
    public List<CourseClassifyVo> findTheFirstClassify(){
        List<CourseClassifyVo> firstClassifyList=courseClassifyService.listTheFirstClassify();
        return firstClassifyList;
    }
    @GetMapping("/findsecondclassify")
    public List<CourseClassifyVo> findTheSecondClassify(){
        List<CourseClassifyVo> classifyList=courseClassifyService.listTheSecondClassify();
        return classifyList;

    }
    @PostMapping("/UpdateOne")
    public int updateOne(@RequestBody CourseClassifyVo courseClassifyVo){

        CourseClassify courseClassify=courseClassifyService.fineOneById(courseClassifyVo.getCourseClassifyId());
        BeanUtils.copyProperties(courseClassifyVo,courseClassify);
        //TODO
        courseClassify.setUpdateTime(new Date());//到优化！！！！
        int result=courseClassifyService.updateOneById(courseClassify,courseClassifyVo.getCourseClassifyId());
        return result;
    }

}
