package com.seed.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * @Author: Li Yawei
 * @Date: 2019/3/18 0:10
 */
@Data
public class LoginForm {
    /**
     * 管理员用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String name;

    /**
     * 买家手机号
     */
    @NotBlank(message = "密码不能为空")
    private String password;
}
