package com.better.inline

// 理解 crossinline
inline fun <T> Iterable<T>.m2ForEach(
        crossinline action: (T)->Unit,
         action2:(T,T) -> Boolean) {
    for (element in this) {
        action(element)
        action2(element,element)
    }
}

fun main(args: Array<String>) {
    val list = listOf(1,2,3,4,5,6,6)
    list.m2ForEach({ if(it % 2 == 0) {
        return@m2ForEach        //
    }}, { a, b->
       return
    })
    println("aaaa")
}