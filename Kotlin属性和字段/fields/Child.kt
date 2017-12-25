package com.sugarya.example.extend

const val SOLID = "123"
class Child {

    object Temp{
        const val SOLID2 = "12334"
    }

    fun cry() {
        println("child is crying")
        val father = InnerFather()
        father.work()
        _test = "1"
    }

    private var _test = ""
    lateinit var test : String


    class InnerFather {
        fun work() {

            println("father works")
        }

        fun extends() {
            work()
        }
    }
}

class Father {

    fun work() {
        println("father works")
    }

    fun Child.extends() {
        work()
        cry()
    }

    fun invoke(child: Child) {
        child.extends()
    }
}

fun main(args: Array<String>) {
    val child = Child()
    val father = Father()


}