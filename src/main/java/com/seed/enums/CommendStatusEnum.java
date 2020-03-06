package com.seed.enums;

import lombok.Getter;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/2 10:50
 */
@Getter
public enum CommendStatusEnum {
    NOTCOMMENDED(0, false, "课程未推荐"),
    COMMENDED(1, true, "，课程已推荐"),
    ;

    private Integer code;

    private Boolean value;

    private String message;

    CommendStatusEnum(Integer code, Boolean value, String message) {
        this.code = code;
        this.value = value;
        this.message = message;
    }
}
