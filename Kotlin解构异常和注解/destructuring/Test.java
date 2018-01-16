package com.pei.app.destructuring;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args){
        Map<String,String> map = new HashMap<>();
        for (Map.Entry<String,String> entry : map.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key: " + key + "value: " + value);
        }
    }
}
