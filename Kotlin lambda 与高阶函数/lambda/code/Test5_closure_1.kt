package com.better.lambda.code

fun main(args: Array<String>) {
    val list = listOf(1,2,3,4,5,7,8)
    var oddNum = 0
    list.forEach { it->
        if(it % 2 == 0) {
            oddNum++
        }
    }
}