package com.seed.model;

import java.util.Date;

public class AdminUser {
    private String adminId;

    private String adminName;

    private String password;

    private Date createTime;

    private Date updateTime;

    private Boolean del;

    public AdminUser(String adminId, String adminName, String password, Date createTime, Date updateTime, Boolean del) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.password = password;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.del = del;
    }

    public AdminUser() {
        super();
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId == null ? null : adminId.trim();
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDel() {
        return del;
    }

    public void setDel(Boolean del) {
        this.del = del;
    }
}