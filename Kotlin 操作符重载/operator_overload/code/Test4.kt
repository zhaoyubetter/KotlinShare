package com.better.operator_overload.code

fun main(args: Array<String>) {
    val list = ArrayList<Int>()
    list += 48      //
    println(list)

    // ==================
    val list2 = mutableListOf(1,2)
    list2.plusAssign(48)
    list2 -= 20
}