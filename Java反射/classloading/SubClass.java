package com.sugarya.base.classloading;

import com.sugarya.utils.Out;

public class SubClass extends SuperClass {

    public static String sTemp = "";

    static {
        sTemp = "sub class temp";
        Out.println("Subclass init");
    }

    public void instanceTest(){
        Out.println("instanceTest");
    }
}
