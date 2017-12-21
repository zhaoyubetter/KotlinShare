package com.better.extends_

import top_level.swap
import java.util.*

/**
 * Created by zhaoyu1 on 2017/12/8.
 */

// 定义扩展函数
fun MutableList<Int>.swap(index1: Int, index2: Int): Unit {
    val tmp = this[index1]       // this  表示列表
    this[index1] = this[index2]
    this[index2] = tmp
}

fun main(args: Array<String>) {
    val list = mutableListOf<Int>(1, 2, 3)
    list.swap(1, 2)
    println(list.toString())

    val list2 = mutableListOf<String>("one", "two", "three")
    list2.swap(1, 2)
    println(list2.toString())
}




