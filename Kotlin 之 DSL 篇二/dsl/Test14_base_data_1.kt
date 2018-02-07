package com.better.dsl

import java.time.LocalDate
import java.time.Period

/**
 * Created by zhaoyu on 2018/1/30.
 */

// val yesterday = 1.days.ago

val Int.days : Period
    get() = Period.ofDays(this)         // this 表示数字字面值

val Period.ago: LocalDate
    get() = LocalDate.now() - this      // 运算符重载 LocalDate.minus

val Period.fromNow: LocalDate
    get() = LocalDate.now() + this      // 运算符重载 LocalDate.plus

fun main(args: Array<String>) {
    println(1.days.ago)
    println(1.days.fromNow)
}