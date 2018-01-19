package com.better.reflect.code

import kotlin.reflect.KFunction2
import kotlin.reflect.KFunction1

fun sum(x:Int, y:Int) = x + y

fun add(x:String, y:String) = x + y

fun printOne(x:Int) = x

fun main(args: Array<String>) {
    val kFun:KFunction2<Int,Int,Int> = ::sum
    val kFun1:KFunction1<Int,Int> = ::printOne
    val kFun2 = ::add

    kFun.call(1,2)      // KCallable
    kFun.invoke(2,3)
    println(kFun(5,6))
}