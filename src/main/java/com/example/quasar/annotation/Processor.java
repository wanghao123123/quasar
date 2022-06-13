package com.example.quasar.annotation;


import java.lang.annotation.*;

/**
 * @author hao.wong
 * @create 2022/3/24
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Processor {

    /**
     * 服务类型
     * @return
     */
    int serviceType() default 0;

}
