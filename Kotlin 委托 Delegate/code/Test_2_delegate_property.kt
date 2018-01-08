package com.better.delegate.code

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class Test_2_delegate_property {
    var myName: String by MyDelegate()
}

class MyDelegate : ReadWriteProperty<Test_2_delegate_property, String> {
    override fun setValue(thisRef: Test_2_delegate_property, property: KProperty<*>, value: String) {
        println("setValue called()")
    }

    override fun getValue(thisRef: Test_2_delegate_property, property: KProperty<*>): String {
        return "abc"
    }
}

fun main(args: Array<String>) {
    val test = Test_2_delegate_property()
    println(test.myName)
    test.myName = "better"
    println(test.myName)
}

