package com.seed.handler;

/*import com.imooc.config.ProjectUrlConfig;
import com.imooc.exception.SellerAuthorizeException;*/

import com.seed.exception.OtherException;
import com.seed.exception.SchoolException;
import com.seed.util.ResultVOUtil;
import com.seed.vo.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SchoolExceptionHandler {

    /*返回的status是200*/
    @ExceptionHandler(value = SchoolException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResultVO handlerSchoolException(SchoolException e){
        return ResultVOUtil.error(e.getCode(),e.getMessage());
    }

    /*指定返回的status*/
    @ExceptionHandler(value = OtherException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handlerOtherException(){

    }
   /* @Autowired
    private ProjectUrlConfig projectUrlConfig;

    //拦截登录异常
    //http://sell.natapp4.cc/sell/wechat/qrAuthorize?returnUrl=http://sell.natapp4.cc/sell/seller/login
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException() {
        return new ModelAndView("redirect:"
        .concat(projectUrlConfig.getWechatOpenAuthorize())
        .concat("/sell/wechat/qrAuthorize")
        .concat("?returnUrl=")
        .concat(projectUrlConfig.getSell())
        .concat("/sell/seller/login"));
    }*/
}
