package com.better.dsl.code

fun mybuildString(action: (StringBuilder) -> Unit):String {
    val sb = StringBuilder()
    action(sb)
    return sb.toString()
}

fun mybuildString2(action: StringBuilder.() -> Unit):String {
    val sb = StringBuilder()
    sb.action()
    return sb.toString()
}


fun main(args: Array<String>) {
    mybuildString {
         it.append("Hello")
         it.append("World")
         it.append("!")
    }

    mybuildString2 {
        append("Hello")
        append("World")
        append("!")
    }
}