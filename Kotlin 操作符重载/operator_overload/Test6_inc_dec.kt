package com.better.operator_overload

import java.math.BigDecimal

operator fun BigDecimal.inc() = this + BigDecimal.ONE

fun main(args: Array<String>) {
    var n = BigDecimal.ZERO
    println(n++)        // 0
    println(++n)        // 2
}