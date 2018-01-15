package com.better.inline

inline fun repeat(times:Int, action: (Int)->Unit) {
    for(index in (0 until times)) {
        action(index)
    }
}

fun main(args: Array<String>) {
    repeat(10) { it ->
        println(it)
    }
}