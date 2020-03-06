package com.seed.enums;

import lombok.Getter;

/**
 * @Author: Li Yawei
 * @Date: 2019/2/26 21:04
 */
@Getter
public enum PageConstant {

    PAGE_NUM(1),
    PAGE_SIZE(10)
    ;

    private int value;

    PageConstant(int value) {

        this.value = value;
    }
}
