package com.better.operator_overload

data class MutablePointer(var x: Int, var y: Int)

operator fun MutablePointer.set(index: Int, value: Int) {
    when (index) {
        0 -> x = value
        1 -> y = value
        else -> throw IndexOutOfBoundsException("Invalid params: $index")
    }
}


fun main(args: Array<String>) {
    val p = MutablePointer(1, 2)
    println(p)
    p[1] = 20
    println(p)
}