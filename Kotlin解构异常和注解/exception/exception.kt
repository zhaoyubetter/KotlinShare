package com.pei.app.exception

import java.lang.Integer.parseInt

fun main(args: Array<String>) {
    //function()
    //tryExpression()
    test()
}

fun function() {
    println("function called")
    throw Exception("error!")
}

fun tryExpression() {
    val a: Int? = try {
        val result = parseInt("1s")
        println("try")
        result
    } catch (e: NumberFormatException) {
        println("catch")
        null
    }finally {
        println("finally")
    }
    println("result is $a")
}

public fun <T> List<T>.each(action: (T) -> Unit){
    for (e in this){
        action(e)
    }
}

fun test(){
    val list = listOf(1,2,3)
    /*
    list.forEach{
        throw Exception("exception")
    }
    */
    try {
        list.each {
            throw Exception("exception")
        }
    }catch (e: Exception){
        println(e.message)
        e.printStackTrace()
    }
}