package com.better.operator_overload

data class Pointer(val x: Int, val y: Int) {
    operator fun plus(other: Pointer): Pointer {
        return Pointer(x + other.x, y + other.y)
    }

    operator fun times(o: Pointer): Pointer {
        return Pointer(x * o.x, y * o.y)
    }

    operator fun div(scale: Float): Pointer {
        return Pointer((x * scale).toInt(), (y * scale).toInt())
    }

    operator fun unaryMinus() = Pointer(-x, -y)

    infix fun test(a:Int) = 2

}
