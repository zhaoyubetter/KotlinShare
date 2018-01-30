package com.better.dsl

fun main(args: Array<String>) {
    val l = StringBuilder().apply {
        for(a in 'a'..'z') {
            append(a)
        }
    }.toString()
    println(l)
}