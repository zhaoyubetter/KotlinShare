package com.better.operator_overload.code

operator fun Char.times(count:Int):String {
    return toString().repeat(count)
}

operator fun Char.times(s:String) {

}

fun main(args: Array<String>) {
    println('a' * 10)

    5 shl 2     // infix
}