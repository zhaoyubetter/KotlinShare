package com.better.extends_

/**
 * Created by zhaoyu1 on 2017/12/14.
 */
// 定义扩展函数
fun <T> MutableList<T>.betterSwap(index1: Int, index2: Int): Unit {
    val tmp = this[index1]       // this  表示列表
    this[index1] = this[index2]
    this[index2] = tmp
}