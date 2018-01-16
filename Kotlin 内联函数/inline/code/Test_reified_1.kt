package com.better.inline.code

// 不允许，泛型被擦除
// fun <T> isA(value:Any?) = value is T

// 使用内联结合reified，类型参数可以实例化
inline fun <reified T> isA(value:Any) = value is T

fun main(args: Array<String>) {
    println(isA<String>("better"))
    println(isA<String>(123))
}