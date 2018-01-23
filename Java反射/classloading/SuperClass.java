package com.sugarya.base.classloading;

import com.sugarya.utils.Out;

public class SuperClass {

    public static String sValue = "666";

    public static final String HELLO_WORLD = "hello world!";

    static {
        Out.println("SuperClass init");
    }

    public String getContent(){
        return "This is String result";
    }

    public static void setsValue(String value){
        sValue = value;
    }
}
