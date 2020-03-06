package com.seed.enums;

import lombok.Getter;

/**
 * Created by 廖师兄
 * 2017-06-11 18:56
 */
@Getter
public enum ResultEnum {

    SUCCESS(0, "成功"),

    COMMENDLIST_IS_NULL(1, "用户当前推荐列表为空"),

    PARAM_ERROR(2, "参数不正确"),

    USER_NOT_EXIST(3,"用户不存在"),

    USER_INFO_LACK(6,"用户信息不全"),

    COURSE_NOT_EXIST(4,"课程不存在"),

    USER_NOT_JOIN(5,"用户未参与任何课程"),

    COLLEGE_NOT_EXIST(6,"学院不存在"),

    MAJOR_NOT_EXIST(7,"专业不存在"),

    GRADE_NOT_EXIST(8,"年级不存在"),

    NO_LESSON(9,"课程表当前没有课程"),

    COURSE_SECTION_NOT_EXIST(10,"课程章节id不存在"),

    NO_AUTHORITY(33,"该用户没有管理权限"),

    LOGIN_FAIL(25, "登录失败, 登录信息不正确"),

    LOGOUT_SUCCESS(26, "登出成功"),


    /*PRODUCT_NOT_EXIST(10, "商品不存在"),

    PRODUCT_STOCK_ERROR(11, "商品库存不正确"),

    ORDER_NOT_EXIST(12, "订单不存在"),

    ORDERDETAIL_NOT_EXIST(13, "订单详情不存在"),

    ORDER_STATUS_ERROR(14, "订单状态不正确"),

    ORDER_UPDATE_FAIL(15, "订单更新失败"),

    ORDER_DETAIL_EMPTY(16, "订单详情为空"),

    ORDER_PAY_STATUS_ERROR(17, "订单支付状态不正确"),

    CART_EMPTY(18, "购物车为空"),

    ORDER_OWNER_ERROR(19, "该订单不属于当前用户"),

    WECHAT_MP_ERROR(20, "微信公众账号方面错误"),

    WXPAY_NOTIFY_MONEY_VERIFY_ERROR(21, "微信支付异步通知金额校验不通过"),

    ORDER_CANCEL_SUCCESS(22, "订单取消成功"),

    ORDER_FINISH_SUCCESS(23, "订单完结成功"),

    PRODUCT_STATUS_ERROR(24, "商品状态不正确"),*/


    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
