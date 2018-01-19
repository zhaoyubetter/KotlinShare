package com.better.reflect.code;

import java.lang.reflect.Field;

public class JavaCode {
    void test() throws Exception {
        Class<?> aClass = Class.forName("java.lang.String");
        Field[] declaredFields = aClass.getDeclaredFields();
        Field hash = aClass.getDeclaredField("hash");
    }
}
