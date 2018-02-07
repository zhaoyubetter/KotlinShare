package com.better.dsl


/**
 * Created by zhaoyu on 2018/1/30.
 */

interface Matcher<T> {
    fun test(value: T)
}

class startWith(val prefix: String) : Matcher<String> {
    override fun test(value: String) {
        if(!value.startsWith(prefix)) {
            throw AssertionError("Stirng $value does not start with $prefix")
        }
    }
}

infix fun <T> T.should(matcher: Matcher<T>) = matcher.test(this)

fun main(args: Array<String>) {
    "kotlin" should startWith("ko")
}