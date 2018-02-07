package com.better.dsl.code

fun main(args: Array<String>) {
    val str = StringBuilder().apply {
        for (alpha in 'A'..'Z') {
            append(alpha)
        }
    }.toString()

    println(str)

}