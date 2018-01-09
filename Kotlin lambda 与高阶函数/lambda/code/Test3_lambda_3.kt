package com.better.lambda.code

fun main(args: Array<String>) {
    val list = listOf(1,2,3,4,5,7,8)
    val list2 = list.map(fun(it:Int) = it * 2)
    val list3 = list.map(::test)
    println(list3)
}

fun test(x:Int):Int {
    return x * 2
}