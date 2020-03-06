package com.seed.util;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/1 22:35
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 */

public class   DateUtil {

    private static Logger logger= LoggerFactory.getLogger(DateUtil.class);
    private final SimpleDateFormat format;

    public DateUtil(SimpleDateFormat format) {
        this.format = format;
    }

    public SimpleDateFormat getFormat() {
        return format;
    }

    // 紧凑型日期格式，也就是纯数字类型yyyyMMdd
    public static final DateUtil COMPAT = new DateUtil(new SimpleDateFormat("yyyyMMdd"));

    // 紧凑型日期格式，也就是纯数字类型yyyyMMdd
    public static final DateUtil COMPAT_FULL = new DateUtil(new SimpleDateFormat("yyyyMMddHHmmss"));

    // 常用日期格式，yyyy-MM-dd
    public static final DateUtil COMMON = new DateUtil(new SimpleDateFormat("yyyy-MM-dd"));
    public static final DateUtil COMMON_TWO = new DateUtil(new SimpleDateFormat("HH:mm:ss"));
    public static final DateUtil COMMON_FULL = new DateUtil(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    // 使用斜线分隔的，西方多采用，yyyy/MM/dd
    public static final DateUtil SLASH = new DateUtil(new SimpleDateFormat("yyyy/MM/dd"));

    // 中文日期格式常用，yyyy年MM月dd日
    public static final DateUtil CHINESE = new DateUtil(new SimpleDateFormat("yyyy年MM月dd日"));
    public static final DateUtil CHINESE_FULL = new DateUtil(new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒"));

    /**
     * 日期获取字符串
     */
    public String getDateText(Date date) {
        return getFormat().format(date);
    }

    /**
     * 字符串获取日期
     * @throws ParseException
     */
    public Date getTextDate(String text) throws ParseException {
        return getFormat().parse(text);
    }

    /**
     * 日期获取字符串
     */
    public static String getDateText(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 字符串获取日期
     * @throws ParseException
     */
    public static Date getTextDate(String dateText, String format) throws ParseException {
        return new SimpleDateFormat(format).parse(dateText);
    }

    /**
     * 根据日期，返回其星期数，周一为1，周日为7
     * @param date
     * @return
     */
    public static int getWeekDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int w = calendar.get(Calendar.DAY_OF_WEEK);
        int ret;
        if (w == Calendar.SUNDAY)
            ret = 7;
        else
            ret = w - 1;
        return ret;
    }

    public static int getAge(Date birthday) {
        Calendar calendar = Calendar.getInstance();
        if (calendar.before(birthday)) {
            throw new IllegalArgumentException("出生时间大于当前时间!");
        }
        int yearNow = calendar.get(Calendar.YEAR);
        int monthNow = calendar.get(Calendar.MONTH) + 1;// 注意此处，如果不加1的话计算结果是错误的
        int dayOfMonthNow = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.setTime(birthday);
        int yearBirth = calendar.get(Calendar.YEAR);
        int monthBirth = calendar.get(Calendar.MONTH);
        int dayOfMonthBirth = calendar.get(Calendar.DAY_OF_MONTH);
        int age = yearNow - yearBirth;
        if (monthNow < monthBirth ||(monthNow == monthBirth && dayOfMonthNow < dayOfMonthBirth)) {
            age--;
        }
        return age;

    }

        /**
         * @Description 是否为当天24h内
         * @param inputJudgeDate 要判断是否在当天24h内的时间
         * @return
         * boolean
         */
        public static boolean isToday(Date inputJudgeDate) {
            boolean flag = false;
            //获取当前系统时间
            long longDate = System.currentTimeMillis();
            Date nowDate = new Date(longDate);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = dateFormat.format(nowDate);
            String subDate = format.substring(0, 10);
            //定义每天的24h时间范围
            String beginTime = subDate + " 00:00:00";
            String endTime = subDate + " 23:59:59";
            Date paseBeginTime = null;
            Date paseEndTime = null;
            try {
                paseBeginTime = dateFormat.parse(beginTime);
                paseEndTime = dateFormat.parse(endTime);

            } catch (ParseException e) {
                logger.error(e.getMessage());
            }
            if(inputJudgeDate.after(paseBeginTime) && inputJudgeDate.before(paseEndTime)) {
                flag = true;
            }
            return flag;
        }

    /**
     * 获得当天零时零分零秒
     * @return
     */
    public static Date todayStart(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
    /**
     * 获得当天23时59分59秒
     * @return
     */
    public static Date todayEnd() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    /**
     * 计算距离同一天零点的分钟数
     */
    public static double countMinutes(String text) throws ParseException {
        Long date0 = DateUtil.COMMON_TWO.getTextDate("00:00:00").getTime();
        Long date1 = DateUtil.COMMON_TWO.getTextDate(text).getTime();
        return (double)(date1-date0)/60/1000;
    }
    /**
     * 获得当天零时零分零秒
     * @return
     */
    public static LocalDateTime getTodayStart(){

        return LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
    }
    /**
     * 获得当天23时59分59秒
     * @return
     */
    public static LocalDateTime getTodayEnd(){

        return LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
    }

}
