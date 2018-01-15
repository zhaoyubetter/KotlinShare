package com.better.inline


// 返回高阶函数的例子
enum class Delivey {
    Shunfeng, JD, yunda
}

class Order(val weight:Int)

fun getDeliveyCost(delivey: Delivey) : (Order) -> Int {
    when(delivey) {
        Delivey.Shunfeng -> return {
            order -> 20 + 10 * order.weight
        }
        Delivey.JD -> return {
            order -> 10 + 10 * order.weight
        }

        else -> return {
            order -> 8 + 10 * order.weight
        }
    }
}

fun main(args: Array<String>) {
    val test = getDeliveyCost(Delivey.Shunfeng)
    println(test(Order(5)))
}