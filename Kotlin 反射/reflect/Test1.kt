package com.better.reflect

fun main(args: Array<String>) {
    println(String::class)      // 获取KClass
    println(String.javaClass)   // 获取java.lang.Class
    // 从Java切换到Kotlin的反射API
    println(String.javaClass.kotlin)
    println(String.javaClass.kotlin.simpleName)
}