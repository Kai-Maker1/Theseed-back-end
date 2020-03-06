package com.seed.converter;

import com.seed.form.LoginForm;
import com.seed.model.AdminUser;


/**
 * @Author: Li Yawei
 * @Date: 2019/3/18 0:23
 */
public class LoginForm2AdminUserConverter {
    public static AdminUser convert(LoginForm loginForm) {
        AdminUser adminUser = new AdminUser();

        adminUser.setAdminName(loginForm.getName());
        adminUser.setPassword(loginForm.getPassword());

        return adminUser;
    }
}
