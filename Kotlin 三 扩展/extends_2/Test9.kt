package com.better.extends_2
/**
 * 多态在扩展函数中是失效的！
多态不影响子类扩展方法的重写（扩展方法可被重写）！
就近原则：用来区别扩展接收者跟分发接收者；
 * Created by zhaoyu1 on 2017/12/25.
 */
open class Anim
class Dog : Anim()
open class BlackDog:Anim() {
    open fun Anim.run() {
        println("Anim.run at BlackDog")
    }
    open fun Dog.run() {
        println("Dog.run at BlackDog")
    }
    fun invoke(anim:Anim) {
        anim.run()
    }
}

class ChildBlackDog:BlackDog() {
    override fun Anim.run() {
        println("Anim.run at ChildBlackDog")
    }
    override  fun Dog.run() {
        println("Dog.run at ChildBlackDog")
    }
}

fun main(args: Array<String>) {
    val anim = Anim()
    val dog = Dog()

    BlackDog().invoke(anim)
    BlackDog().invoke(dog)

    ChildBlackDog().invoke(anim)
    ChildBlackDog().invoke(dog)
}


