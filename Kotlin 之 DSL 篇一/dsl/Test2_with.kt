package com.better.dsl

fun main(args: Array<String>) {
    val sb = StringBuilder()
    val s = with(sb) {
        for(a in 'a'..'z') {
            append(a)
        }
        this.toString()
    }
    println(s)
}