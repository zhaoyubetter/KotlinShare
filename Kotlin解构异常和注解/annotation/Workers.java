package com.pei.app.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface Workers {
    Worker[] value();
}
