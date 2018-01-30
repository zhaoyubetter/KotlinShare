package com.better.dsl.code

fun main(args: Array<String>) {
   val strings = with(StringBuilder()) {
        for (alpha in 'A'..'Z') {
            append(alpha)
        }
      this.toString()
    }
    println(strings)
}