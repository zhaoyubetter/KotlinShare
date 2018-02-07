package com.better.dsl

val cc : StringBuilder.() -> Unit = {
    this.append("better")
    this.append("wolrd")
}

fun main(args: Array<String>) {
    val sb = StringBuilder("good luck ")
    sb.cc()
    println(sb)

    buildString {  }
}