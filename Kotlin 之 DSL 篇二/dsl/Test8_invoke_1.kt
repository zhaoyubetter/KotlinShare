package com.better.dsl

class Greeter(val greeting:String) {
    operator fun invoke(name:String) {
        println("$greeting, $name")
    }
}

val myFun = fun(s:String) = println(s)

fun main(args: Array<String>) {
    val g = Greeter("Hello")
    g("better")
    myFun("aaa")
}