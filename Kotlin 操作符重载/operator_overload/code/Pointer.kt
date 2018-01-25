package com.better.operator_overload.code

data class Pointer(val x:Int, val y:Int) {
    operator fun plus(p:Pointer) :Pointer {
        return Pointer(this.x + p.x, this.y + p.y)
    }
}

fun main(args: Array<String>) {

    val p1 = Pointer(0, 0)
    val p2 = Pointer(5, 5)

    println(p1 + p2)
    println(p1.plus(p2))


}