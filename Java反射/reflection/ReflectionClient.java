package com.sugarya.base.reflection;

import com.sugarya.utils.Out;

import java.lang.reflect.*;

/**
 * 反射
 */
public class ReflectionClient {

    public static void main(String[] args) {
//        testInstance(Man.class);
//        testInstances(Man.class);

//        int[] atrs = {11, 32, 12, 5, 19};
//        changeArraySize(atrs, 10);

//        testClass("com.sugarya.base.reflection.Man");
//        testParticularField(Man.class, "clothes");
        testFields(Man.class);
//        testFieldAssignment(Man.class);
//        testDeclaredFields(Man.class);
//          testMethod(Man.class, 22);
//        testMethods(Man.class);
//        testDeclaredMethods(Man.class);
//        testStaticMethod(Man.class);
    }




    /**
     * getDeclaredMethods（） 该类所有的方法（不包括父类的）
     * @param clazz
     */
    private static void testDeclaredMethods(Class<Man> clazz){
        Method[] methods = clazz.getDeclaredMethods();
        if(methods != null){
            for(Method m : methods){
                int modifiers = m.getModifiers();
                String s = Modifier.toString(modifiers);
                String name = m.getName();
                Class<?> returnType = m.getReturnType();
                Class<?>[] parameterTypes = m.getParameterTypes();
                StringBuilder parameterSB = new StringBuilder();
                if(parameterTypes != null){
                    for(Class parameter : parameterTypes){
                        String simpleName = parameter.getSimpleName();
                        parameterSB.append(simpleName + " ");
                    }
                }
                System.out.println(s + " " + returnType + " " + name + " (" + parameterSB.toString() + ")");
            }
        }
    }

    /**
     * getMethods()  该类和父类所有public方法
     * @param clazz
     */
    private static void testMethods(Class<Man> clazz){
        Method[] methods = clazz.getMethods();
        if(methods != null){
            for(Method m : methods){
                int modifiers = m.getModifiers();
                String s = Modifier.toString(modifiers);

                String name = m.getName();
                Class<?> returnType = m.getReturnType();
                Class<?>[] parameterTypes = m.getParameterTypes();
                StringBuilder parameterSB = new StringBuilder();
                if(parameterTypes != null){
                    for(Class parameter : parameterTypes){
                        String simpleName = parameter.getSimpleName();
                        parameterSB.append(simpleName + " ");
                    }
                }
                System.out.println(s + " " + returnType + " " + name + " (" + parameterSB.toString() + ")");
            }
        }
    }

    /**
     * 调用静态方法
     * @param clazz
     */
    private static void testStaticMethod(Class<Man> clazz){
        try {
            Method compute = clazz.getMethod("compute", String.class);
            Object o = compute.invoke(null, "测试内容");
            println(o.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 调用实例方法
     * @param clazz
     * @param a
     */
    private static void testMethod(Class<Man> clazz, int a) {
        try {
            Man man = clazz.newInstance();
            Method method = clazz.getMethod("fun", Integer.TYPE);
            method.invoke(man, a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 给属性赋值
     * @param clazz
     */
    private static void testFieldAssignment(Class<Man> clazz){
        try {
            Man man = clazz.newInstance();
            Field gender = clazz.getDeclaredField("gender");
            gender.setAccessible(true);
            gender.set(man, "男");
            Object o = gender.get(man);
            println("gender = " + o.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * getDeclaredFields()表示该类任何修饰符的所有属性（不包括父类中属性）
     * @param clazz
     */
    private static void testDeclaredFields(Class<Man> clazz){
        Field[] fields = clazz.getDeclaredFields();
        if(fields != null){
            for(Field f : fields){
                int modifiers = f.getModifiers();
                String s = Modifier.toString(modifiers);
                Type genericType = f.getGenericType();
                Class<?> type = f.getType();
                String simpleName = type.getSimpleName();
                String name = f.getName();
                println(s + " " + simpleName + " " + name);
            }
        }
    }

    /**
     * getFields() 该类和父类所有修饰符为public的属性
     * @param clazz
     */
    private static void testFields(Class<Man> clazz){
        Field[] fields = clazz.getFields();
        if(fields != null){
            for(Field f : fields){
                int modifiers = f.getModifiers();
                String s = Modifier.toString(modifiers);
                Type genericType = f.getGenericType();
                Class<?> type = f.getType();
                String simpleName = type.getSimpleName();
                String name = f.getName();
                println(s + " " + simpleName + " " + name);
            }
        }
    }

    /**
     * 获取特定属性的
     * @param clazz
     */
    private static void testParticularField(Class<Man> clazz, String fieldName){
        try {
            Constructor<Man> constructor = clazz.getConstructor(String.class, int.class, int.class, int.class);
            Man kotlin = constructor.newInstance("Kotlin", 7, 180, 1);
            Field clothes = clazz.getField(fieldName);
            int clothesInt = clothes.getInt(kotlin);
            println("kotlin clothes = " + clothesInt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 实例化类
     * @param className
     */
    private static void testClass(String className){
        ClassLoader classLoader = ReflectionClient.class.getClassLoader();
        try {
            Class<?> aClass = Class.forName(className, false, classLoader);
            Class<?> aClass2 = Class.forName(className, true, classLoader);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 改变数组，生成新的数组
     * @param obj
     * @param len
     * @return
     */
    private static Object changeArraySize(Object obj, int len){
        Class<?> componentType = obj.getClass().getComponentType();
        Array.setInt(obj,2, 99);
        int anInt = Array.getInt(obj, 2);
        int objSize = Array.getLength(obj);
        println("anInt = " + anInt);

        Object newArray = Array.newInstance(componentType, len);
        System.arraycopy(obj,0, newArray,0,objSize);

        return newArray;
    }

    /**
     * 实例化带参数类
     * @param clazz
     */
    private static void testInstance(Class<Man> clazz) {
        try {
            Constructor<Man> clazzConstructor = clazz.getConstructor(String.class, int.class);
            Man ethan = clazzConstructor.newInstance("Ethan", 28);
            System.out.println(ethan.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 遍历实例
     * @param clazz
     */
    private static void testInstances(Class<Man> clazz) {
        Constructor<?>[] constructors = clazz.getConstructors();
        try {
            Object o = constructors[0].newInstance();
            Object jeff = constructors[1].newInstance("Jeff", 32);
            println(o.toString());
            println(jeff.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    private static  void println(String msg){
        Out.println(msg);
    }
}
