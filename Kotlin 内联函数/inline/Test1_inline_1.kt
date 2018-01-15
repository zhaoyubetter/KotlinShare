package com.better.inline

/**
 * 反编译看源码，就明白 inline 的意思了
 * Created by zhaoyu1 on 2018/1/3.
 */
inline fun lock() {
    println("lock() called")
}

fun main(args: Array<String>) {
    lock()
}