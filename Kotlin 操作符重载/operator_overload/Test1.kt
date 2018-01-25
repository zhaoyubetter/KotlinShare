package com.better.operator_overload

fun main(args: Array<String>) {
    val pointer1 = Pointer(2,2)
    val pointer2 = Pointer(3,4)

    println(pointer1 + pointer2)
    println(pointer1.plus(pointer2))
}