package com.better.lambda

/**
 * Created by zhaoyu1 on 2018/1/3.
 */
// 接收者可通过上下判断出来，可通过lambda表达式来接收函数字面值
class HTML {
    fun body() {
        println("html - body")
    }
}

fun html(init: HTML.()->Unit):HTML {
    val html = HTML()       // 创建接收者
    html.init()         // 接收者传递给lambda，调用函数字面值
    return html
}

fun main(args: Array<String>) {
    html {
        body()
    }
}
