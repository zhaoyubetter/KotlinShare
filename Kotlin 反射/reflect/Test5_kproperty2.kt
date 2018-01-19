package com.better.reflect

fun main(args: Array<String>) {
    val person = Person("better", 30)
    val name = Person::name     // 获取name引用
    println(name.invoke(person))
    println(name.get(person))

    // 使用方法
    val method = Person::method
    method.call(person)
    method.invoke(person)
    method(person)
}