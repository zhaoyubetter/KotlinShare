package com.pei.app.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})
@Repeatable(Workers.class)
public @interface Worker {

}
