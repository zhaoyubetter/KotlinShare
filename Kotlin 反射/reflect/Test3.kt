package com.better.reflect

import kotlin.reflect.KFunction2

fun foo(x:Int, y:Int) = x+y

fun main(args: Array<String>) {
    // 返回KFunction的实例
    val kFun:KFunction2<in Int,in Int,out Int> = ::foo    // 函数的引用
    println(kFun::class)
    println(kFun.call(1,2))  // KFunction.call()
    println(kFun.invoke(3,5))   // 必须用2个参数
}
