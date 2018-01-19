package com.better.reflect.code

fun main(args: Array<String>) {
    val kClass1 = String::class  // java.lang.Class

    val jClazz:Class<String> = String::class.java
    val clazz = String.javaClass

    val kClasszz2 = clazz.kotlin

    println(jClazz == clazz)    // 不一样
}