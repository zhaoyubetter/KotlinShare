package com.sugarya.example.classandobject

open class Person(var name: String = "YaoMine", var age: Int = 38){

    open var height: Int = 0

    init {
        println("init constructor name = ${name}, age=${name}")
    }

    constructor(name: String, age: Int, height: Int): this(name, age){
        println("constructor name = ${name}, age=${name}, height = ${height}")
        this.height = height
    }

    open fun drink(){
        println("${name} 喝水")
    }
}