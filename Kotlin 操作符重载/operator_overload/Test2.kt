package com.better.operator_overload

operator fun Pointer.minus(other:Pointer) :Pointer {
    return Pointer(x - other.x, y - other.y)
}

fun main(args: Array<String>) {
    val pointer = Pointer(3,3)
    println(pointer - Pointer(5,5) * Pointer(10,10))
}