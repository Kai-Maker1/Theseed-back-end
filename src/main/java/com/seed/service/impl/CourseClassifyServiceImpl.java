package com.seed.service.impl;

import com.seed.dao.CourseClassifyMapper;
import com.seed.enums.RecordStatusEnum;
import com.seed.model.CourseClassify;
import com.seed.model.CourseClassifyExample;
import com.seed.service.CourseClassifyService;
import com.seed.util.PojoUtil;
import com.seed.vo.CourseClassifyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CourseClassifyServiceImpl implements CourseClassifyService {

    private  int theFirstClassifyCount=0;

    @Autowired
    private CourseClassifyMapper courseClassifyMapper;


    @Override
    public List<CourseClassify> listAllClassify() {
        CourseClassifyExample courseClassifyExample=new CourseClassifyExample();
        courseClassifyExample.setOrderByClause("sort ASC");
        courseClassifyExample.or().andDelEqualTo(RecordStatusEnum.NOTDELETE.getValue());
        List<CourseClassify> courseClassifies=courseClassifyMapper.selectByExample(courseClassifyExample);

        return courseClassifies;
    }

    @Override
    public List<CourseClassifyVo> listTheFirstClassify() {
        List<String> parentCodeList = new ArrayList<>();
        parentCodeList.add("0");
        //查询到所有父级课程信息
        CourseClassifyExample courseClassifyExample = new CourseClassifyExample();
        CourseClassifyExample.Criteria criteria = courseClassifyExample.createCriteria();
        criteria.andParentCodeIn(parentCodeList);
        List<CourseClassify> courseClassifiesOne = courseClassifyMapper.selectByExample(courseClassifyExample);
        List<CourseClassifyVo> theFirstClassifyList = new ArrayList<>();
        try {
            theFirstClassifyList = (List<CourseClassifyVo>) PojoUtil.convertToPojoByAddAttr(courseClassifiesOne, "courseClassifyId,name,code,sort");

        } catch (Exception e) {
            e.printStackTrace();
        }
        theFirstClassifyCount=theFirstClassifyList.size();
        System.out.println("theFirstClassifyCount"+theFirstClassifyCount);
        return theFirstClassifyList;
    }

    @Override
    public List<CourseClassifyVo> listTheSecondClassify() {
        /* List<List<CourseClassify>> classifyList=new ArrayList<>();*/
        System.out.println("theFirstClassifyCount" + theFirstClassifyCount);
        /*String [] arry=new String[theFirstClassifyCount];*/
        List<String> arry = new ArrayList<>();
        CourseClassifyExample courseClassifyExample = new CourseClassifyExample();
        CourseClassifyExample.Criteria criteria = courseClassifyExample.createCriteria();


        //只取了需要的字段，封装到一个新的对象里
        try {
            /* CourseClassifyServiceImpl courseClassifyService=new CourseClassifyServiceImpl();*/

            List<CourseClassifyVo> theFirstClassifyList = listTheFirstClassify();
                /*for(int i=0;i<theFirstClassifyCount;i++) {
                    CourseClassify theFirstClassify=theFirstClassifyList.get(i);
                    String parentCode = theFirstClassify.getCode();
                    System.out.println(parentCode);
                    arry[i]=parentCode;

                }*/
            for (CourseClassifyVo theFirstClassify : theFirstClassifyList) {
                String parentCode = theFirstClassify.getCode();
                System.out.println(parentCode);
                arry.add(parentCode);
            }
            criteria.andParentCodeIn(arry);
            courseClassifyExample.setOrderByClause("sort ASC");
            List<CourseClassify> courseClassifiesTwo = courseClassifyMapper.selectByExample(courseClassifyExample);
            for (CourseClassify c : courseClassifiesTwo) {
                System.out.println(c.getCourseClassifyId());
                System.out.println(c.getName());
                System.out.println(c.getParentName());
            }
            List<CourseClassifyVo> theFirstAndSecondClassifyList =
                    (List<CourseClassifyVo>) PojoUtil.convertToPojoByAddAttr(courseClassifiesTwo, "courseClassifyId,name,parentName,sort");
            return theFirstAndSecondClassifyList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CourseClassify fineOneById(Integer id) {
        CourseClassifyExample courseClassifyExample=new CourseClassifyExample();
        CourseClassifyExample.Criteria criteria=courseClassifyExample.createCriteria();
        criteria.andCourseClassifyIdEqualTo(id);
        List<CourseClassify> list=courseClassifyMapper.selectByExample(courseClassifyExample);
        CourseClassify courseClassify=list.get(0);
        return courseClassify;
    }

    @Override
    public int updateOneById(CourseClassify courseClassify, Integer id) {
        CourseClassifyExample courseClassifyExample=new CourseClassifyExample();
        CourseClassifyExample.Criteria criteria=courseClassifyExample.createCriteria();
        criteria.andCourseClassifyIdEqualTo(id);
        int result=courseClassifyMapper.updateByExampleSelective(courseClassify,courseClassifyExample);
        return result;
    }

    @Override
    public int insertOne(CourseClassify courseClassify) {
        int result=courseClassifyMapper.insertSelective(courseClassify);
        return result;
    }


}
