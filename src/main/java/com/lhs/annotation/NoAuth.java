package com.lhs.annotation;

import java.lang.annotation.*;

/**
 * Created by Leonid on 2018/7/3.
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NoAuth {
}
