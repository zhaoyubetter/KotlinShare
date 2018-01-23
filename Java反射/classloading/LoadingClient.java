package com.sugarya.base.classloading;

import com.sugarya.base.reflection.Man;
import com.sugarya.utils.Out;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class LoadingClient {


    public static void main(String[] args) {
        testVersion1_1();
    }


    /**
     * 类初始化1 主动引用／被动引用
     */
    private static void testVersion1_1() {
        Out.println(SubClass.sValue);
    }

    /**
     * 类初始化
     */
    private static void testVersion1_2() {
        SubClass subClass = new SubClass();
    }

    /**
     * 类初始化3
     */
    private static void testVersion1_3() {
        Out.println(SubClass.sTemp);
    }

    /**
     * 类初始化4 数组
     */
    private static void testVersion2() {
        SuperClass[] superClasses = new SuperClass[8];
    }

    /**
     * 相等判断 除了 instanceof
     */
    private static void testVersion2_1() {
        Out.println(SuperClass.HELLO_WORLD);
    }

    private static void testVersion3_1() {
        boolean isAssignable = SuperClass.class.isAssignableFrom(SuperClass.class);
        Out.println("isAssignable = " + isAssignable);
    }

    private static void testVersion3_2() {
        SubClass subClass = new SubClass();
        boolean isInstance = SuperClass.class.isInstance(subClass);
        Out.println("isInstance = " + isInstance);
    }

    /**
     * Java三种类加载器的关系
     */
    private static void testVersion4() {
//        ClassLoader systemClassLoader = System.class.getClassLoader();
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Out.println("systemClassLoader = " + systemClassLoader.toString());

        ClassLoader extendClassLoader = systemClassLoader.getParent();
        Out.println("extendClassLoader = " + extendClassLoader);
        Out.println("extendClassLoader path = " + System.getProperty("java.ext.dirs"));

        ClassLoader bootstrapClassLoader = extendClassLoader.getParent();

        try {
            Constructor<Man> manConstructor = Man.class.getConstructor(String.class, Integer.TYPE);
            Man man = manConstructor.newInstance("", 11);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

}
