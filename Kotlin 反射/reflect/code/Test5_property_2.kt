package com.better.reflect.code

import com.better.reflect.lastChar


val String.myLast : Char
    get() = this[length -1]

fun main(args: Array<String>) {
    val test = "zhaoyubetter"

    val lastChar = String::myLast   // ::

    println(lastChar.invoke(test))
    println(test.lastChar)
    println(String::lastChar.get(test))
}
