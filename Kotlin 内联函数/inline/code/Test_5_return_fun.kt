package com.better.inline.code

enum class Delivery {
    Shunfeng, JD, Yunda
}
class Order(val weight:Int)
fun getCost(delivery: Delivery): (o:Order) -> Int {
    when(delivery) {
        Delivery.Shunfeng -> return {
            o-> 20 + 10 * o.weight
        }
        Delivery.JD -> return {
            o -> 15 + 8 * o.weight
        }
        else -> return {
            o -> 8 + 5 * o.weight
        }
    }
}

fun main(args: Array<String>) {
    val test = getCost(delivery = Delivery.Shunfeng)
    println(test(Order(5)))
}