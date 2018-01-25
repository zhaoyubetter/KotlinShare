package com.better.operator_overload

operator fun Pointer.get(i: Int): Int {
    return when (i) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException("Invalid params: $i")
    }
}

fun main(args: Array<String>) {
    val p = Pointer(1, 2)
    println(p[0])
    println(p.get(0))
}