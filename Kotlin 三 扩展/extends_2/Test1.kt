package com.better.extends_2

/**
 * Created by zhaoyu1 on 2017/12/21.
 */
class Hello {
    fun method() {
        println("Hello method called()")
    }
}

fun Hello.sayHello(name: String) {
    println("Hello $name")
}

fun main(args: Array<String>) {
    val h = Hello()
    h.sayHello("better")
}
