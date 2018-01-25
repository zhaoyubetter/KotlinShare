package com.better.operator_overload.code

operator fun Pointer.unaryPlus() : Pointer {
    return Pointer(x = x+1, y = y +1)
}

fun main(args: Array<String>) {
    val p = Pointer(2,1)
    println(+p)
}