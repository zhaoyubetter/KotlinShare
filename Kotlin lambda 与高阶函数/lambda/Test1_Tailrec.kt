package com.better.lambda

/**
 * 尾递归，没有尾递归
 * Created by zhaoyu on 2018/1/1.
 */
tailrec fun jiecheng(n: Int): Int {
    if (n == 0) {
        return 1
    } else {
        return n * jiecheng(n - 1)
    }
}

fun main(args: Array<String>) {
    println(jiecheng(4))
    //println(fi2(1000000))
}
