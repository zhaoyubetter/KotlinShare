package com.better.extends_2

/**
 * Created by zhaoyu1 on 2017/12/21.
 */
class NullTest {}

fun NullTest?.method() {
    if (this == null) {
        println("this is null")
        return
    }
    println("NullTest method called()")
}

fun main(args: Array<String>) {
    val n: NullTest? = null
    n.method()
}