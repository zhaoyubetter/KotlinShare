package com.better.lambda

/**
 * Created by zhaoyu on 2018/1/1.
 */

// 定义lambda，这个有点像 Groovy 的闭包定义
val sum = { a: Int, b: Int -> a + b }

fun main(args: Array<String>) {
    val sum = sum.invoke(1,2)  // invoke lambda
    println(sum)
}