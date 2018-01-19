package com.better.reflect

import java.lang.reflect.Method
import kotlin.reflect.KClass
import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.javaGetter

class A(val p:Int)

fun main(args: Array<String>) {
    // java
    val javaGetter: Method? = A::p.javaGetter
    val clazz:Class<A> = A::class.java
    // kotlin
    val kClass : KClass<A> = A::class.java.kotlin
    println(A::p.javaGetter)
    println(A::p.javaField)
}