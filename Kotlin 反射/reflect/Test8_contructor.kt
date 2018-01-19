package com.better.reflect
// 构造方法的引用

class B
fun function(factory: ()->B) {
    val p = factory()
    println(p)
}
fun main(args: Array<String>) {
    function(::B)
}