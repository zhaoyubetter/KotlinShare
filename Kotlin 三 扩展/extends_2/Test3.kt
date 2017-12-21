package com.better.extends_2

/**
 * Created by zhaoyu1 on 2017/12/21.
 */
class World {
    fun say() {
        println("world say")
    }
}
fun World.say() {
    println(" other say")
}

fun main(args: Array<String>) {
    val w = World()
    w.say()
}