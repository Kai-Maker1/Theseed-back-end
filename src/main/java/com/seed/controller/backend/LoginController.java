package com.seed.controller.backend;

import com.seed.constant.CookieConstant;
import com.seed.constant.RedisConstant;
import com.seed.converter.LoginForm2AdminUserConverter;
import com.seed.enums.ResultEnum;
import com.seed.form.LoginForm;
import com.seed.model.AdminUser;
import com.seed.service.AdminUserService;
import com.seed.util.CookieUtil;
import com.seed.util.MD5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/20 8:44
 */
@Controller
public class LoginController {
    private Logger logger= LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private AdminUserService adminUserService;

    @GetMapping("/")
    public ModelAndView homePage( Map<String , Object> map) {
        LoginForm loginForm =new LoginForm();
        map.put("loginForm",loginForm);
        return new ModelAndView("/login",map);
    }
    @GetMapping("/seed/welcome")
    public ModelAndView welcomePage() {
        return new ModelAndView("/welcome");
    }
    @PostMapping("/login")
    public ModelAndView login(@Valid LoginForm form, BindingResult bindingResult,
                              HttpServletResponse response
    ) {
        if (bindingResult.hasErrors()) {
            logger.error("【用户登陆】参数不正确, loginForm={}", form);
            Map<String, Object> map =new HashMap<>();
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url", "/seed/");
            return new ModelAndView("/common/error",map);
            /*throw new SchoolException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());*/
        }
        AdminUser adminUser= LoginForm2AdminUserConverter.convert(form);
        //1.数据库里的数据匹配
        try {
            adminUser = adminUserService.userToLogin(adminUser.getAdminName(), MD5Utils.getMD5Code(adminUser.getPassword()));
        }catch (Exception e){
            /*如果用户不存在*/
            Map<String, Object> map =new HashMap<>();
            map.put("msg", ResultEnum.USER_NOT_EXIST.getMessage());
            map.put("url", "/seed/");
            return new ModelAndView("/common/error", map);
        }


        //2. 设置token至redis
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;

        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX, token), form.getName(), expire, TimeUnit.SECONDS);

        //3. 设置token至cookie
        CookieUtil.set(response, CookieConstant.TOKEN, token, expire);

        return new ModelAndView("/index");

    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                               HttpServletResponse response,
                               Map<String, Object> map) {
        //1. 从cookie里查询
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie != null) {
            //2. 清除redis
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));

            //3. 清除cookie
            CookieUtil.set(response, CookieConstant.TOKEN, null, 0);
        }

        map.put("msg", ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url", "/");
        return new ModelAndView("/login");
    }
}
