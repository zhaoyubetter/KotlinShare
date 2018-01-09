package com.better.lambda

/**
 * lambda返回值
 * Created by zhaoyu on 2018/1/1.
 */
fun main(args: Array<String>) {
    val list = listOf(0, 1, -3, -2, 9)
    val tmp = list.filter {
        //        val filter = it > 0
//        return@filter filter

        // or
//        val filter = it > 0
//        filter

        // or

        it > 0
    }
    println(tmp)

    // 匿名函数形式
    println(list.filter(fun(item) = item > 0))
}


