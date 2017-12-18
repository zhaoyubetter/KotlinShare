package com.sugarya.example.classandobject

open class Coder : Person{


    var language: String get() = "Java"
    set(value) {}

    override var height = 0

    init {
        println("Coder name = ${name} age = ${age}, height = ${height}, language = ${language}")
    }


    constructor(name: String, age: Int, height: Int, language: String) : super(name, age, height){
        this.language = language
        this.height = height
    }

    constructor(name: String): super(name){

    }

    override fun drink() {
        println("coder ${name}喝咖啡")
    }
}