package com.seed.controller.frontend;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.seed.enums.ResultEnum;
import com.seed.model.Teacher;
import com.seed.service.TeacherService;
import com.seed.util.ResultVOUtil;
import com.seed.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping(value = "/teacher")
@CacheConfig(cacheNames = "teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    private RedisTemplate redisTemplate;

    private static Logger logger =  LoggerFactory.getLogger(TeacherController.class);

    @PostMapping(value = "/findByOpenId")
    @Cacheable(keyGenerator = "keyGenerator",unless = "#result.code!=0")
/*
* condition = "#result.code!=0"
* EL1007E: Property or field 'code' cannot be found on null",
*/
    public ResultVO<Teacher> findTeacherByOpenId(@RequestBody String request){
        JSONObject params= JSON.parseObject(request);
        String openId=params.getString("openId");
        Teacher teacher = teacherService.findTeacherByOpenId(openId);
        ResultVO<Teacher> res=null;
        try {
            if (teacher == null) {
                res = ResultVOUtil.error(ResultEnum.USER_NOT_EXIST);
                redisTemplate.opsForValue().set(openId, res, 60, TimeUnit.SECONDS);
            } else {
                res = ResultVOUtil.success(teacher);
                redisTemplate.opsForValue().set(openId, res, 360, TimeUnit.SECONDS);
            }
        }catch (Exception e){
            logger.error("用户不存在");
        }
        return res;
    }


}
