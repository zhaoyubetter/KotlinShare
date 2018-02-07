package com.better.dsl

fun main(args: Array<String>) {
    val abc = buildString {
        for (alpha in 'A'..'Z') {
            append(alpha)
        }
    }
    println(abc)
}