package com.seed.enums;

import lombok.Getter;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/2 17:10
 */
@Getter
public enum CourseStatusEnum {
    ALL(0, "全部"),
    NEWEST(1, "最新"),
    HOT(2,"热门"),
    NOT_BEGIN(1, "未开始"),
    GOING(2, "进行中"),
    END(3, "已结束"),
    USER_NOT_JOIN(0,"未参加"),
    USER_BESPEAKED(1,"预约中"),
    USER_LEARNING(2,"学习中"),
    USER_LEARN_END(3,"已结束")
    ;

    private Integer code;

    private String value;

    CourseStatusEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }
}