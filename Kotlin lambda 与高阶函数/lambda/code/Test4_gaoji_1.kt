package com.better.lambda.code

fun <T> myMax(col:Collection<T>, less:(T,T)->Boolean) : T? {
    var max:T? = null
    for(item in col) {
        if(max == null || less(max,item)) {
            max = item
        }
    }
    return max
}

fun <T> Iterable<T>.myMax2(less:(T,T)->Boolean) : T? {
    var max:T? = null
    for(item in this) {
        if(max == null || less(max,item)) {
            max = item
        }
    }
    return max
}

fun main(args: Array<String>) {
    val list = listOf(1,2,3,4,5,7,8)
    val max = myMax(list) {x, y -> x < y}
    val max2 = myMax(list) { x, y -> x < y}
    println(max2)

    println(list.myMax2 {x,y -> x < y})
}
