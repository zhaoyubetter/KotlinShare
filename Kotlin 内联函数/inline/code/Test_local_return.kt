package com.better.inline.code


inline fun <T> Iterable<T>.myForEach(action: (T)->Unit) {
    for (element in this) {
        action(element)
    }
}

fun testMethod1() : Boolean {
    val list = listOf(1,2,3,4,5,6)
    list.myForEach {
        if(it % 2 == 0) return true		// not allow
    }
    return false
}

fun main(args: Array<String>) {
}