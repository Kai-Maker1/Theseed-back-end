package com.seed.controller.backend;

import com.seed.exception.SchoolException;
import com.seed.form.TeacherForm;
import com.seed.model.Teacher;
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
 * @Date: 2019/3/17 23:59
 */
@Controller
@RequestMapping("/seed/teacher")
public class ManagerTeacherController {
    private Logger logger= LoggerFactory.getLogger(ManagerTeacherController.class);
   @Autowired
   private TeacherService teacherService;

    @GetMapping(value = "/findAll")
    /*@Cacheable(keyGenerator = "keyGenerator")*/
    public ModelAndView findAllTeacher() throws Exception {
        logger.info("查询全部老师！");
        // 假如前端传来的参数
        int pageNum = 1; // 第几页
        int pageSize = 30; // 每页记录数
        List<Teacher> teacherList = teacherService.listAllTeachers(pageNum, pageSize);
        List<Teacher> teachers = ( List<Teacher>) PojoUtil.convertToPojoByAddAttr(teacherList,
                "teacherId,teacherName,openId,nickname,gender,header,status,collegeId,createTime,updateTime");
        Map<String,Object> map = new HashMap<>();
        map.put("teachers",teachers);
        return new ModelAndView("/teacher/list",map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(name = "teacherId",required = false) String teacherId,
                                    Map<String, Object> map){
        if(!StringUtils.isEmpty(teacherId)){
            Teacher teacher = teacherService.findTeacherByTeacherId(teacherId);
            map.put("teacher",teacher);
        }
        return new ModelAndView("/teacher/index",map);
    }

    @GetMapping("/index2")
    public ModelAndView index(Map<String, Object> map){
        Teacher teacher = new Teacher();
        map.put("teacher",teacher);
        return new ModelAndView("/teacher/index2",map);
    }
    @PostMapping("/insert")
    public ModelAndView insertOne(@Valid TeacherForm form,
                                  BindingResult bindingResult,
                                  Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            String url = "/seed/teacher/index";
            map.put("url", url);
            return new ModelAndView("/common/error", map);
        }
        Teacher teacher = new Teacher();
        try {
            BeanUtils.copyProperties(form, teacher);
            if (StringUtils.isEmpty(form.getTeacherId())) {
                teacher.setTeacherId(KeyUtil.getUniqueKey("t"));
            }
            int result = teacherService.insertOne(teacher);
            logger.info("{}条记录受影响,成功插入teacherId={}的信息", result, teacher.getTeacherId());
        }catch (Exception e) {
            map.put("msg", e.getMessage());
            String url = "/seed/teacher/index";
            map.put("url", url);
            return new ModelAndView("/common/error", map);
        }
        map.put("url", "/seed/teacher/findAll");
        return new ModelAndView("/common/success", map);
    }

    @PostMapping("/update")
    public ModelAndView updateOne(@Valid TeacherForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            String url = "/seed/teacher/index?" + form.getTeacherId();
            map.put("url", url);
            return new ModelAndView("/common/error", map);
        }

        Teacher teacher = new Teacher();

        try {
            //teacherId不存在会抛出异常
            if (form.getTeacherId() != null) {
                teacher = teacherService.findTeacherByTeacherId(form.getTeacherId());
            }
            BeanUtils.copyProperties(form, teacher);
            int result = teacherService.updateOne(teacher);
            logger.info("{}条记录受影响,成功更新teacherId={}的信息",result,teacher.getTeacherId());
        } catch (Exception e) {
            map.put("msg", e.getMessage());
            String url = "/seed/teacher/index?" + form.getTeacherId();
            map.put("url", url);
            return new ModelAndView("/common/error", map);
        }
        map.put("url", "/seed/teacher/findAll");
        return new ModelAndView("/common/success", map);
    }
    @RequestMapping("/delete")
    public ModelAndView deleteOne(@RequestParam(name = "teacherId",required = false) String teacherId,
                                  Map<String, Object> map) {
        try {
            int result = 0;
            if (!StringUtils.isEmpty(teacherId)) {
                result = teacherService.deleteOne(teacherId);
                logger.info("{}条记录受影响,成功删除teacherId={}的信息", result,teacherId);
                map.put("url", "/seed/teacher/findAll");
                return new ModelAndView("/common/success", map);
            } else {
                map.put("url", "/seed/teacher/findAll");
                return new ModelAndView("/common/error", map);
            }
        } catch (Exception e) {
            map.put("msg", e.getMessage());
            map.put("url", "/seed/teacher/findAll");
            return new ModelAndView("/common/error", map);
        }
    }
}
