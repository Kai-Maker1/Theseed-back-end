package com.seed.exception;


import com.seed.enums.ResultEnum;
import lombok.Getter;

@Getter
public class SchoolException extends RuntimeException{

    private Integer code;

    public SchoolException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SchoolException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
