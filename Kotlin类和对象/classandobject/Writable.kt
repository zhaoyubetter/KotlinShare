package com.sugarya.example.classandobject

interface Writable{

    val book: String


    fun work()

    fun drink(){
        println("Writable 喝水")
        book.length

    }

    fun getB(): String{
        return "Effective Java"
    }
}