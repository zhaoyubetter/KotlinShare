package com.better.lambda

/**
 * 带接收者的函数字面值
 * Created by zhaoyu on 2018/1/1.
 */

/*
 字面值就是那些具体的数或者字符或者字符串。
例如定义一个整型变量 int a=20；
这里a是一个整型的变量，里面存放一个整数，这里被初始化为20。
而这里的20就是字面值，它不是数据类型。
又例如，string str=“I am Chinese !”
I am Chinese !就是字面值，str是存放这个字面值的字符串变量。
 */


val mySum = fun Int.(other: Int): Int = this + other

fun main(args: Array<String>) {
    // 函数字面值的类型是一个带有接收者的函数类型
    // 匿名函数
    val sumOk : Int.(other:Int) -> Int = {this + it}   // 有点像扩展函数
    println(1.sumOk(2))
}