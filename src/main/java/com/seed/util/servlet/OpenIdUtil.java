package com.seed.util.servlet;

public class OpenIdUtil {
    public static String oauth2GetOpenid(String code) {
        String appid="";
        String appsecret="";
        //自己的配置appid*/
        appid = "wx542b5e86d7797b30";
        //自己的配置APPSECRET;
        appsecret = "08f04173f5eee1b4dc11cb7f7dc85e63";
       /* switch (classify){
            case "jiankangka":
                //自己的配置appid
                appid = "wx542b5e86d7797b30";
                //自己的配置APPSECRET;
                appsecret = "08f04173f5eee1b4dc11cb7f7dc85e63";
                break;
        }*/

        //授权（必填）
        String grant_type = "authorization_code";
        //URL
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
        //请求参数
        String params = "appid=" + appid + "&secret=" + appsecret + "&js_code=" + code + "&grant_type=" + grant_type;
        //发送请求
        String data = HttpUtil.get(requestUrl, params);
        return data;//获取openId
    }
}
