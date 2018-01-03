//package com.better.extends_2
//
///**
// * 例子：父亲work，孩子哭了；
// * Created by zhaoyu1 on 2017/12/25.
// */
//class Child {
//    fun cry() {
//        println("Child cry")
//    }
//}
//
//class Father {
//    fun cry() {
//        println("Father work()")
//    }
//
//    fun Child.extends() {
//        this@Father.cry()
//        cry()
//    }
//
//    fun invoke(c:Child) {
//        c.extends()
//    }
//}
//
//fun main(args: Array<String>) {
//    val father = Father()
//    val child = Child()
//    father.invoke(child)
//}
