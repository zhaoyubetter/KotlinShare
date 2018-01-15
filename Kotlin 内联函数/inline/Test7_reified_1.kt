package com.better.inline

import java.lang.reflect.Method
import java.util.Arrays


// 获取T类型的所有方法
inline fun <reified T> listMethodsOf() = T::class.java.methods.toList()

fun javalistMethodsOf(classIn: Class<*>): List<Method>? {
    return Arrays.asList<Method>(*classIn.methods)
}

fun main(args: Array<String>) {
    println(listMethodsOf<String>())
}