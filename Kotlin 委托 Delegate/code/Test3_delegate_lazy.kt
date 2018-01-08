package com.better.delegate.code

/**
 * 延迟属性
 */
class Test3_delegate_lazy {

    val name: String by lazy {
        println("lazy called()")
        return@lazy "better"
    }

    // 延迟初始化
    lateinit var lateValue: String

    fun lateValue(): String {
        lateValue = "abc"
        return lateValue
    }
}

fun main(args: Array<String>) {
    val test = Test3_delegate_lazy()
    println(test.name)
    println(test.name)
    println(test.name)
    println(test.name)
    println(test.name)
}