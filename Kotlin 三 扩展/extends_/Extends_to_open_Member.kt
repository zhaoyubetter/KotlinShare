package com.better.extends_

/**
 * Created by zhaoyu1 on 2017/12/14.
 */
open class X {}

class X1:X() {}

open class Y {
    open fun X.foo() {
        println("X.foo in Y")
    }

    open fun X1.foo() {
        println("X1.foo in Y")
    }

    fun caller(x:X) {
        x.foo()
    }
}

class Y1:Y() {
   override open fun X.foo() {
        println("X.foo in Y1")
    }

    override open fun X1.foo() {
        println("X1.foo in Y1")
    }
}

fun main(args: Array<String>) {
    Y().caller(X())
    Y1().caller(X())
    Y().caller(X1())
}