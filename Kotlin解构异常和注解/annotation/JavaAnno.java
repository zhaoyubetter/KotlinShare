package com.pei.app.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Repeatable(AnnoContainer.class)
public @interface JavaAnno {
    int intValue() default 0;
    String stringValue() default "";
}
