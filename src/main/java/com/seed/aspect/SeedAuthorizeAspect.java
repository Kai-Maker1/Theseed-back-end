package com.seed.aspect;

import com.seed.constant.CookieConstant;
import com.seed.constant.RedisConstant;
import com.seed.exception.SeedAuthorizeException;
import com.seed.util.CookieUtil;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *
 */
/*@Aspect
@Component
public class SeedAuthorizeAspect {

    private Logger logger = LoggerFactory.getLogger(SeedAuthorizeAspect.class);

        @Autowired
        private StringRedisTemplate redisTemplate;

        @Pointcut("execution(public * com.seed.controller.Seller*.*(..))" +
                "&& !execution(public * com.seed.controller.SellerUserController.*(..))")
        public void verify() {}

        @Before("verify()")
        public void doVerify() {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();

            //查询cookie
            Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
            if (cookie == null) {
                logger.warn("【登录校验】Cookie中查不到token");
                throw new SeedAuthorizeException();
            }

            //去redis里查询
            String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
            if (StringUtils.isEmpty(tokenValue)) {
                logger.warn("【登录校验】Redis中查不到token");
                throw new SeedAuthorizeException();
            }
        }
}*/
