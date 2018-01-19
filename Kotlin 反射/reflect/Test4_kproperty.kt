package com.better.reflect

import kotlin.reflect.KProperty0

var myNum = 10

fun main(args: Array<String>) {
    val kProperty = ::myNum
    println(kProperty.get())
    kProperty.set(100)
    // kProperty.setter.call(21)
    println(kProperty.get())
    println(kProperty.call())
}