package com.seed.enums;

import lombok.Getter;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/21 23:50
 */
@Getter
public enum UserCourseSectionStatusEnum {
    LEARNING(0,0),
    END_LEARN(1,1);

    private Integer code;

    private Integer value;

    UserCourseSectionStatusEnum(Integer code, Integer value) {
        this.code = code;
        this.value = value;
    }
}
