package com.better.lambda.code

// 完整格式
val sum : (Int, Int) -> Int = fun(x:Int, y:Int) :Int {
    return x + y
}

// 簡寫1
val sum1: (Int, Int) -> Int = fun(x:Int, y:Int) = x + y

// 簡寫2
val sum2  = fun(x:Int, y:Int) = x + y

// 简写三
val sum3 = {x:Int, y:Int -> x + y}

fun main(args: Array<String>) {
    println(sum1(1,2))
    println(sum2.invoke(4,5))
}
