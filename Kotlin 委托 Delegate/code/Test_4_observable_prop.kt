package com.better.delegate.code

import kotlin.properties.Delegates

class Baby {
    var myName: String by Delegates.observable("better") {
        property, oldValue, newValue ->
        println("${property.name} $oldValue - > $newValue")
    }
}

fun main(args: Array<String>) {
    val b = Baby()
    println(b.myName)
    b.myName = "ergouzi"
    println(b.myName)
}