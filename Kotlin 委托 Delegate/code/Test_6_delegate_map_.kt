package com.better.delegate.code

data class UserBean(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map

    fun method() {
        val tmp : String by lazy {      // lazy
            "abc"
        }

        println("Hello")
        println(tmp)
    }

}

fun main(args: Array<String>) {
    // "{}"
    // gson - > map
    val map = mapOf("name" to "better", "age" to 30)
    val user = UserBean(map)
    println(user.name + " -> " + user.age)
}