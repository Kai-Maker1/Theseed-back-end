package com.seed;

import com.seed.model.CourseClassify;
import com.seed.model.CourseSection;
import com.seed.model.Teacher;
import com.seed.model.UserCourseSection;
import com.seed.service.CourseClassifyService;
import com.seed.service.CourseSectionService;
import com.seed.service.MajorService;
import com.seed.service.TeacherService;
import com.seed.service.impl.CourseSectionServiceImpl;
import com.seed.util.DateUtil;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeedApplicationTests {

    @Test
    @Ignore
    public void contextLoads() {
        System.out.println("hello world!");
    }

    @Autowired
    MajorService majorService;
    @Autowired
    TeacherService teacherService;

    @Autowired
    CourseClassifyService courseClassify;
    @Autowired
    CourseSectionService courseSectionService;
    @Test
    public void test() throws ParseException {

        /*CourseClassify c = courseClassify.fineOneById(1);
        System.out.println(c);
        Teacher t = teacherService.findTeacherByTeacherId("t001");
        System.out.println(t.getCreateTime());
        System.out.println(DateUtil.todayStart());
        System.out.println(DateUtil.todayEnd());*/
        int sum =
        courseSectionService.count("csp001");
        System.out.println(sum);
       List<CourseSection> courseSectionList = courseSectionService.findChapterByCourseId("csp001");

            System.out.println(courseSectionList);

        /*List<Major> majorList=majorService.listAll();
        System.out.println(majorList.get(0).getMajorName());*/
        /*int i=1;
        try{
            if(i == 0){
                System.out.println(i);
        }
            System.out.println(i);
        }catch (SchoolException e){
            System.out.println(e.getMessage());
        }
        System.out.println(MD5Utils.getMD5Code("123456789"));*/
        /*LocalDateTime today_start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);//当天零点
        System.out.println(toay_start);*/
        /*Long date0 = DateUtil.COMMON_TWO.getTextDate("00:00:00").getTime();
        Long date1 = DateUtil.COMMON_TWO.getTextDate("01:06:30").getTime();
        Date date2 = DateUtil.COMMON_TWO.getTextDate("02:06:30");
        Date date3 = DateUtil.COMMON_TWO.getTextDate("00:06:30");
        Date date4 =DateUtil.COMMON_TWO.getTextDate("00:00:30");
        System.out.println(DateUtil.countMinutes("00:35:30"));*/
    }
}


