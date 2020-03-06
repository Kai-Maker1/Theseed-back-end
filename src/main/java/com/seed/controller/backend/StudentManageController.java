package com.seed.controller.backend;

import com.seed.exception.SchoolException;
import com.seed.form.StudentForm;
import com.seed.form.TeacherForm;
import com.seed.model.Student;
import com.seed.model.Teacher;
import com.seed.service.StudentService;
import com.seed.service.TeacherService;
import com.seed.util.KeyUtil;
import com.seed.util.PojoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/20 20:13
 */
@Controller
@RequestMapping("/seed/student")
public class StudentManageController {
    private Logger logger= LoggerFactory.getLogger(ManagerTeacherController.class);
    @Autowired
    private StudentService studentService;

    @GetMapping("/major")
    public ModelAndView majorManager() {
        return new ModelAndView("/major/major");
    }

    @GetMapping(value = "/findAll")
    /*@Cacheable(keyGenerator = "keyGenerator")*/
    public ModelAndView findAllStudent() throws Exception {
        logger.info("查询全部学生！");
        // 假如前端传来的参数
        int pageNum = 1; // 第几页
        int pageSize = 30; // 每页记录数
        List<Student> studentList = studentService.findAll(pageNum, pageSize);
        List<Student> students = ( List<Student>) PojoUtil.convertToPojoByAddAttr(studentList,
                "stuId,stuName,openId,nickname,gender,header,status,majorId,classId,collegeId,createTime,updateTime");
        Map<String,Object> map = new HashMap<>();
        map.put("students",students);
        return new ModelAndView("/student/list",map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(name = "stuId",required = false) String stuId,
                              Map<String, Object> map){
        if(!StringUtils.isEmpty(stuId)){
            Student student = studentService.findStudentByStuId(stuId);
            map.put("student",student);
        }
        return new ModelAndView("/student/index",map);
    }

    @GetMapping("/index2")
    public ModelAndView index(Map<String, Object> map){
        Student student = new Student();
        map.put("studet",student);
        return new ModelAndView("/student/index2",map);
    }
    @PostMapping("/insert")
    public ModelAndView insertOne(@Valid StudentForm form,
                                  BindingResult bindingResult,
                                  Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            String url = "/seed/student/index";
            map.put("url", url);
            return new ModelAndView("/common/error", map);
        }
        Student student = new Student();
        try {
            BeanUtils.copyProperties(form, student);
            if (StringUtils.isEmpty(form.getStuId())) {
                student.setStuId(KeyUtil.getUniqueKey("S"));
            }
            int result = studentService.createOne(student);
            logger.info("{}条记录受影响,成功插入stuId={}的信息", result, student.getStuId());
        }catch (Exception e) {
            map.put("msg", e.getMessage());
            String url = "/seed/student/index";
            map.put("url", url);
            return new ModelAndView("/common/error", map);
        }
        map.put("url", "/seed/student/findAll");
        return new ModelAndView("/common/success", map);
    }

    @PostMapping("/update")
    public ModelAndView updateOne(@Valid StudentForm form,
                                  BindingResult bindingResult,
                                  Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            String url = "/seed/student/index?" + form.getStuId();
            map.put("url", url);
            return new ModelAndView("/common/error", map);
        }

        Student student = new Student();
        try {
            //stuId不存在会抛出异常
            if (form.getStuId() != null) {
                student = studentService.findStudentByStuId(form.getStuId());
            }
            BeanUtils.copyProperties(form, student);
            int result = studentService.update(student);
            logger.info("{}条记录受影响,成功更新stuId={}的信息",result,student.getStuId());
        } catch (Exception e) {
            map.put("msg", e.getMessage());
            String url = "/seed/student/index?" + form.getStuId();
            map.put("url", url);
            return new ModelAndView("/common/error", map);
        }
        map.put("url", "/seed/student/findAll");
        return new ModelAndView("/common/success", map);
    }
    @RequestMapping("/delete")
    public ModelAndView deleteOne(@RequestParam(name = "stuId",required = false) String stuId,
                                  Map<String, Object> map) {
        try {
            int result = 0;
            if (!StringUtils.isEmpty(stuId)) {
                result = studentService.deleteOne(stuId);
                logger.info("{}条记录受影响,成功删除stuId={}的信息", result,stuId);
                map.put("url", "/seed/student/findAll");
                return new ModelAndView("/common/success", map);
            } else {
                map.put("url", "/seed/student/findAll");
                return new ModelAndView("/common/error", map);
            }
        } catch (Exception e) {
            map.put("msg", e.getMessage());
            map.put("url", "/seed/student/findAll");
            return new ModelAndView("/common/error", map);
        }
    }
}
