package com.better.reflect


// 组合函数

fun isOdd(x:Int) = x % 2 != 0
fun length(s:String) = s.length

fun <A,B,C> compose(f: (B)->C, g:(A)->B) : (A)-> C {
    return {x->f(g(x))}
}


fun main(args: Array<String>) {
    // <String,Int,Boolean>
    val oddLength = compose(::isOdd, ::length)      // :: Kotlin
    val strings = listOf("a","ab","abc", "abcde")
    println(strings.filter(oddLength))
}

