package com.better.reflect.code

import java.lang.reflect.Field
import java.lang.reflect.Method
import kotlin.reflect.KClass
import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.javaGetter

class A(p:Int) {
    val p = p
        get() = field * 2
}

fun main(args: Array<String>) {
    val a = A(2)

    // java
    val javaGetter: Method? = A::p.javaGetter
    val javaField : Field? = A::p.javaField
    val clazz:Class<A> = A::class.java
    println(javaGetter?.invoke(a))  // 4
    javaField?.isAccessible = true
    println(javaField?.get(a))      // 2

    // kotlin
    val kClass : KClass<A> = A::class.java.kotlin
    println(A::p.javaGetter)
    println(A::p.javaField)
}