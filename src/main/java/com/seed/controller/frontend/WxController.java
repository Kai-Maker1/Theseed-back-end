package com.seed.controller.frontend;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.seed.enums.ResultEnum;
import com.seed.exception.SchoolException;
import com.seed.model.Student;
import com.seed.service.StudentService;
import com.seed.util.KeyUtil;
import com.seed.util.ResultVOUtil;
import com.seed.util.servlet.CheckUtil;
import com.seed.util.servlet.OpenIdUtil;
import com.seed.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//异常处理 参见http://www.cnblogs.com/wangyingli/p/5912269.html
@RestController
@RequestMapping("/wx")
public class WxController {

    private static Logger logger = LoggerFactory.getLogger(WxController.class);

    @Autowired
    private StudentService studentService;
    /* private CheckUtil checkUtil;*/

    @PostMapping(value = "/auth")
    public ResultVO<String> PostOpenId(@RequestBody String request) {
        //TODO
        //只有openid请成功了才将用户信息写入数据库
        logger.info("请求用户openid");
        logger.info("请求数据内容：{}",request);
        System.out.println(request);
        ResultVO<String> result=new ResultVO<>();
        JSONObject params = JSON.parseObject(request);
        Student student = new Student();

        String code = params.getString("code");
        String res=null;
        if (!CheckUtil.checkNulls(code)) {

             res = OpenIdUtil.oauth2GetOpenid(code);
        }


        System.out.println(res);
        String openid=JSON.parseObject(res).getString("openid");
        System.out.println(openid);
        if (!CheckUtil.checkNulls(openid,
                                params.getString("nickname"),
                                params.getString("header"),
                                params.getBoolean("gender").toString())) {
            student.setStuId(KeyUtil.getUniqueKey("S"));
            student.setNickname(params.getString("nickname"));
            student.setHeader(params.getString("header"));
            student.setGender(params.getBoolean("gender"));
            student.setOpenId(openid);
            int records = studentService.createOne(student);
            logger.info("【创建一个用户】受影响行数：records={}", records);
            result= ResultVOUtil.success(openid);
        }else{
            logger.error("【创建一个用户】用户部分信息为空");
            throw new SchoolException(ResultEnum.USER_INFO_LACK);
            //若抛出异常后，不再运行return

        }
        logger.info("成功返回数据！");
       return result;
    }
}