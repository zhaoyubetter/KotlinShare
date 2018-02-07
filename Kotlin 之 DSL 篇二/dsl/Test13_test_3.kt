package com.better.dsl

/**
 * Created by zhaoyu on 2018/1/30.
 */

// "kotlin" should end with "in"

object end

class EndWrapper(val value:String) {
    infix fun with(subfix:String) {
        if(!value.endsWith(subfix)) {
            throw AssertionError("String '$value' must be end with '$subfix'")
        }
    }
}

infix fun String.should(x:end) = EndWrapper(this)

fun main(args: Array<String>) {
    "kotlin" should end with "la"
}