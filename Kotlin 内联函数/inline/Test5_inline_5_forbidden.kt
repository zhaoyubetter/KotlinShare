package com.better.inline

// 禁用內聯
inline fun method(repeat: ()->Unit, noinline foo: () -> Unit) {
    var l = foo     // 当做普通字段用
    repeat()
    l.invoke()
}

fun main(args: Array<String>) {
    method( { println("Hello repeat") }, {println("Hello Inline")})
}