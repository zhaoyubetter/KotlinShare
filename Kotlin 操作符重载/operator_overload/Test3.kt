package com.better.operator_overload

operator fun Char.times(count:Int):String {
    return toString().repeat(count)
}


fun main(args: Array<String>) {
    println('a'.times(10))
}