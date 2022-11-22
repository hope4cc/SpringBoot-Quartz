package com.hope.quartz.Utils;

import com.sun.istack.internal.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 文件名：SpringBeanUtils
 * 创建者：hope
 * 邮箱：1602774287@qq.com
 * 微信：hope4cc
 * 创建时间：2022/11/21-23:15
 * 描述：方便获得ApplicationContext中的所有bean
 */
@Component
public class SpringBeanUtils  implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(@NotNull ApplicationContext applicationContext) throws BeansException {
        if (SpringBeanUtils.applicationContext == null) {
            SpringBeanUtils.applicationContext = applicationContext;
        }
    }
    // 通过name获取 Bean.
    @NotNull
    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }

    // 通过class获取Bean.
    @NotNull
    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    // 通过name,以及Clazz返回指定的Bean
    @NotNull
    public static <T> T getBean(String name, Class<T> clazz) {
        return applicationContext.getBean(name, clazz);
    }
}
