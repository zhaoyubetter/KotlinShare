package com.better.lambda.code

fun main(args: Array<String>) {
    val list = listOf(1,2,3,4,5,7,8)
    println(list
            .map { it * 2 }
            .filter { (it % 4 == 0) })
}