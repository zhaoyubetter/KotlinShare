package com.better.extends_

/**
 * Created by zhaoyu1 on 2017/12/8.
 */

open class C

class D : C()

// 添加扩展方法
fun C.foo() = "c"

fun D.foo(): String {
    if (this == null) {
        return "is null"
    }
    return "abcdefg"
}

fun D?.foo2():String {
    if(this == null) {
        return "this foo2 is null"
    }
    return "foo2 called"
}

fun main(args: Array<String>) {
    val c: D = D()
    println(c.foo())
    printFoo(D())

    // 为NULL时的处理
    val d: D? = null
    println(d.foo2())
}

fun printFoo(c: C) {
    println(c.foo())
}