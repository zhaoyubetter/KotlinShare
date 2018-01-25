package com.better.operator_overload.code

import java.math.BigDecimal

operator fun Pointer.unaryMinus() = Pointer(-x, -y)

// inc dec 编译器支持 ++a 与 a++
operator fun BigDecimal.inc() = this + BigDecimal.ONE

fun main(args: Array<String>) {
    var n = BigDecimal.ZERO
    println(n++)        // 0
    println(++n)        // 2
}