package com.better.reflect.code

import kotlin.reflect.KFunction2
import kotlin.reflect.KFunction3

class Anim {
    fun test() {
        println("test called")
    }
}


fun main(args: Array<String>) {
    val kMethod = ::Anim        // 無參構造方法的引用
    val anim = kMethod.invoke()
    anim.test()

    // 有參構造
    //val person:KFunction2<String, Int, Person> = ::Person
}