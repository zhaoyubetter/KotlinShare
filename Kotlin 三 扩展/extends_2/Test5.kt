package com.better.extends_2

/**
 * Created by zhaoyu1 on 2017/12/21.
 */
class Test5(val name: String) {
    var size: Int = 0
}

fun Test5.say() {
    this.nameLength
}

val Test5.nameLength
    get() = name.length

fun main(args: Array<String>) {
    val t = Test5("better")
    println("--->${t.nameLength}")
}