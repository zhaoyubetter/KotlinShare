package com.better.extends_

/**
 * 扩展声明为成员
 * Created by zhaoyu1 on 2017/12/14.
 */
class A {
    fun bar() {
        println("A bar() called...")
    }
}

class B {
    fun baz() {
        println("B baz() called...")
    }
    // 在类的内部，为另一个类申明扩展
    fun A.foo() {
        bar()           // 扩展接收者
        this@B.baz()    // 分发接收者
    }

    fun caller(a:A) {
        a.foo()     // 调用扩展函数
    }
}

fun main(args: Array<String>) {
    val a = A()
    val b = B()
    b.caller(a)
}
