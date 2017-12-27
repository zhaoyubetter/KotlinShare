package me.chen.sealed

sealed class Anim
class Dog(val color: String) : Anim() {
}

class Cat(val color: String) : Anim() {
}

class Fish(val color: String) : Anim()

fun main(array: Array<String>) {
    val anim = Dog("black")
    when (anim) {
        is Dog -> print("dog")
    }
}

fun eval(anim: Anim) {
    when (anim) {
        is Dog -> TODO()
        is Cat -> TODO()
        is Fish -> TODO()
    }
}