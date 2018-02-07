package com.better.dsl


/**
 * Created by zhaoyu on 2018/1/30.
 */
// 一个单利，用来过渡方法调用而已，没其他作用
object start
// 定义with中缀函数
class StartWrapper(val value: String) {
    infix fun with(prefix: String) {
        if (!value.startsWith(prefix)) {
            throw AssertionError("String $value does not start with $prefix")
        }
    }
}


infix fun String.should(x: start): StartWrapper = StartWrapper(this)

fun main(args: Array<String>) {
    "kotlin" should start with "ko"
}