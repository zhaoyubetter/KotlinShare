package com.better.reflect.code

import kotlin.reflect.full.memberProperties


class Person(var name:String, var age:Int) {
    constructor(fullName: String, name:String,age:Int)
            :this(name, age)
}

fun main(args: Array<String>) {
//    val kClass = Person::class
//    val nameProp = Person::name
//
//    val person = Person("better", 30)
//    println(nameProp.invoke(person))
//    println(nameProp.getter(person))
//
//    nameProp.set(person, "zhaoyu")
//    println(nameProp.invoke(person))


    try {
        val kClass = Class.forName("com.better.reflect.code.P33erson").kotlin
        kClass.memberProperties.forEach {
            println(it.name)
        }
    } catch (e:Exception) {
        println(e.toString())
    }



}