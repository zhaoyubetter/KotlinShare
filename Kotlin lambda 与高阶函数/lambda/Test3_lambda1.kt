package com.better.lambda

/**
 * Created by zhaoyu on 2018/1/1.
 */
fun <T> max(collection: Collection<T>, less: (T, T) -> Boolean): T? {
    var max: T? = null
    for (it in collection) {
        if (max == null || less(max, it)) {
            max = it
        }
    }
    return max
}



fun main(args: Array<String>) {
    val list = listOf<Int>(1, 5, 9, 0, 8, -1)
    val max = max(list) { a, b -> a < b }
    println(max)
}