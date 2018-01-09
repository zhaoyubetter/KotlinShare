package com.better.lambda


/**
 * Created by zhaoyu on 2018/1/1.
 */
val list = listOf(1, 2, 3, 4, 5, 6)

fun main(args: Array<String>) {
    val map = list.map { it -> it * 2 }
    println(map)

    println(list.filter { it > 2 }.map { it * 2 })

}