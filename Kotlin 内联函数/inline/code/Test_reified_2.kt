package com.better.inline.code

inline fun <reified T> Iterator<*>.filterIsInstance(): List<T> {
     val dest = mutableListOf<T>()
     for(item in this) {
         if(item is T) {
             dest.add(item)
         }
     }
     return dest
}

fun main(args: Array<String>) {
    val list = listOf("abb", 123, "ccc", "abcd")

    val list2 = listOf<Int>(1,2,3,4)

    println(list.filterIsInstance<String>())
}