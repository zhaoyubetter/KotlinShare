package com.better.extends_2

/**
 * Created by zhaoyu1 on 2017/12/21.
 */
open class FF
class GG : FF()
fun FF.say() {
    println("FF.say")
}
fun GG.say() {
    println("GG.say")
}
fun method(param: FF) {
    param.say()
}

fun main(args: Array<String>) {
    val g = GG()
    method(g)
}