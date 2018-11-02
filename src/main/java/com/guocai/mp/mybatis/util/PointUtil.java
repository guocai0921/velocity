package com.guocai.mp.mybatis.util;

/**
 * java类简单作用描述
 *
 * @ClassName: PointUtil
 * @Package: com.guocai.mp.mybatis.util
 * @Description: 小数点保留工具类
 * @Author: Sun GuoCai
 * @Version: 1.0
 * @Create: 2018-11-02-10:35
 */
public class PointUtil {

    /**
     * @description: 保留两位小数
     * @auther: Sun GuoCai
     * @datetime: 2018/11/2 10:54
     * @param: divisor
     * @param: dividend
     * @return: java.lang.String
     */
    public static String reservedTwoDecimalPoints(Double divisor,Double dividend) {
        if (dividend!=0) {
            return String.format("%.2f",divisor/dividend);
        } else {
            return "被除数不能为零";
        }
    }
    /**
     * @description: 自定义保留小数位数
     * @auther: Sun GuoCai
     * @datetime: 2018/11/2 10:55
     * @param: divisor
     * @param: dividend
     * @param: num
     * @return: java.lang.String
     */
    public static String reservedCustomizeDecimalPoints(Double divisor,Double dividend,Integer num) {
        if (dividend!=0) {
            return String.format("%."+num+"f",divisor/dividend);
        } else {
            return "被除数不能为零";
        }
    }

}
