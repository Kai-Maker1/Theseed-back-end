package com.seed.controller.backend;

import com.seed.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/21 11:39
 */
@Controller
@RequestMapping("/seed/course")
public class CourseManageController {

    @GetMapping("/")
    public ModelAndView index(){
        return new ModelAndView("/course/upload");
    }
    @GetMapping("/upload2")
    public ModelAndView index2(){
        return new ModelAndView("/course/upload2");
    }
    @GetMapping("/notice")
    public ModelAndView notice(){
        return new ModelAndView("/course/notice");
    }
}
