package com.better.reflect

fun main(args: Array<String>) {

    val prop = "abcde"::length
    println(prop.get())

}