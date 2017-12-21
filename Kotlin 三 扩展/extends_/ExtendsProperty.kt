package com.better.extends_

/**
 * Created by zhaoyu1 on 2017/12/14.
 */
val <T> List<T>.lastIndex: Int get() = size - 1

fun main(args: Array<String>) {
    val list = mutableListOf(1, 2, 3, 4, 5, 7, 8)
    println("lastIndex:${list.lastIndex}")
    // list.lastIndex = 20  // 不能赋值
}