package com.better.dsl

fun mybuildString(action: (StringBuilder) -> Unit) : String {
    val sb = StringBuilder()
    action(sb)
    return sb.toString()
}

// 定义带接收者的lambda的类型参数
fun mybuildString2(action: StringBuilder.() -> Unit) : String {
    val sb = StringBuilder()
    sb.action()
    return sb.toString()
}

fun main(args: Array<String>) {
    val s = mybuildString {
        it.append("Hello")
        it.append("World")
    }
    println(s)

    // =============
    val s2 = mybuildString2 {
        this.append("better")
        append("zhaoyu")        // 省略this
    }
}
