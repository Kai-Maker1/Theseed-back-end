package com.seed.enums;

import lombok.Getter;

/**
 * @Author: Li Yawei
 * @Date: 2019/2/28 21:05
 */
@Getter
public enum RecordStatusEnum implements CodeEnum {
    NOTDELETE(0, false,"记录未删除"),
    DELETE(1, true,"记录已删除"),
    ;

    private Integer code;

    private Boolean value;

    private String message;

    RecordStatusEnum(Integer code, Boolean value,String message) {
        this.code = code;
        this.value=value;
        this.message = message;
    }

}