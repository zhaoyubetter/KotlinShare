package com.pei.app.exception;

public class ExceptionTest {

    public static void main(String[] args){
        ExceptionTest exceptionTest = new ExceptionTest();
        try {
            exceptionTest.method();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void method() throws Exception{
        System.out.println("method called");
        throw new Exception("error!");
    }
}
