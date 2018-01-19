package com.better.reflect

import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties

open class Anim(val typeName:String)

fun main(args: Array<String>) {
    val person = Person("better", 30)
    val kClass = person.javaClass.kotlin

    // 反射訪問所有非擴展屬性(包括父)
    kClass.memberProperties.forEach {
        println(it.name)        // KProperty
    }

    val kNameProp = Person::name
    println(kNameProp.getter.call(person))
    println(kNameProp.get(person))
    println(kNameProp.invoke(person))

    kNameProp.set(person, "hello")
}

class Person(var name:String, var age:Int):Anim("huminbeans") {
    fun method() {
        println("method called()")
    }
}
