package com.better.reflect

val String.lastChar : Char
    get() = this[length - 1]

// 扩展属性引用
fun main(args: Array<String>) {
    val list = listOf("a","ab","abc")
    println(String::lastChar.get("zhaoyu"))
}