package com.better.operator_overload.code

infix fun Int.test(x:Int) :Int {
    return this + x
}

fun main(args: Array<String>) {
    println( 1 test 3)
    println(1.test(3))
}