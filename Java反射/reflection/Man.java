package com.sugarya.base.reflection;

public class Man extends Person{

    static {
        System.out.println("loading the Man");
    }

    private String gender;
    public int clothes;

    public Man() {
    }

    public Man(String name, int age) {
        super(name, age);
    }

    public Man(String name, int age, int height) {
        super(name, age, height);
    }

    public Man(String name, int age, String gender) {
        super(name, age);
        this.gender = gender;
    }

    public Man(String name, int age, int height, int clothes) {
        super(name, age, height);
        this.clothes = clothes;
    }

    public Man(String name, int age, int height, String gender) {
        super(name, age, height);
        this.gender = gender;
    }

    public Man(String name, int age, int height, String gender, int clothes) {
        super(name, age, height);
        this.gender = gender;
        this.clothes = clothes;
    }

    public void fun() {
        System.out.println("person fun");
    }

    public void fun(int a) {
        System.out.println("Person fun a = " + a);
    }

    private void privateFun(){
        System.out.println("Man privateFun");
    }

    public static String compute(String s){
        return s;
    }

    private int walk(){
        System.out.println("Man walking...");
        return 111;
    }

    @Override
    public String toString() {
        return "Man{" +
                "gender='" + gender + '\'' +
                '}';
    }
}
