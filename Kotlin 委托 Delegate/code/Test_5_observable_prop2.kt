package com.better.delegate.code

import kotlin.properties.Delegates

class Test_5_observable_prop2 {
    var myName: String by Delegates.vetoable("better") { prop, old, new ->
        if ("ergouzi" == new) {
            println("shit!!! back")
            return@vetoable false
        }
        return@vetoable true
    }
}

fun main(args: Array<String>) {
    val test = Test_5_observable_prop2()
    test.myName = "ergouzi"
    println(test.myName)
}