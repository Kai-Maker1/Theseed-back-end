package com.seed.service;

        import com.seed.model.AdminUser;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/18 0:47
 */
public interface AdminUserService {
    AdminUser userToLogin(String adminName,String password);
}
