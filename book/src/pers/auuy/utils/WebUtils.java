package pers.auuy.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {
    /**
     * 把 Map 中的值注入到对应的 JavaBean 属性中。
     * @param value
     * @param bean
     */
    public  static <T> T copyParaToBean(Map value, T bean) {
        try {
            // 把所有请求的参数都注入到 bean 对象中
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符串转换为 Int 类型
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parasInt(String strInt,int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }
}
