package com.sugarya.example.classandobject

import com.sugarya.example.others.Personz


object Client {
    @JvmStatic
    fun main(args: Array<String>) {
//        testObject()
        testInheritance()
    }

    fun testObject(){
        val p = Person("Kotlin", 7)
        println("age = ${p.age}")
    }

    fun testInheritance(){
        val coder = Coder("Jeff", 29, 180, "Kotlin")
//        println("testInheritance age = ${coder.age}")
    }

}
