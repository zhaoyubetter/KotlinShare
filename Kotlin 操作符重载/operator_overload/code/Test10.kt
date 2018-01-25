package com.better.operator_overload.code



data class Rectangle(val left: Pointer, val right: Pointer)

operator fun Rectangle.contains(p: Pointer): Boolean {
    return p.x in left.x until right.x &&
            p.y in left.y until right.y
}

fun main(args: Array<String>) {
    val rect = Rectangle(Pointer(10, 20), Pointer(50, 50))
    println(Pointer(20, 48) in rect)
}