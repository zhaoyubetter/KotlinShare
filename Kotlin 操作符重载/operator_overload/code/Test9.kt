package com.better.operator_overload.code

operator fun Pointer.get(index:Int) : Int{
    return when(index) {
        0 -> x
        1 -> y
        else -> {
            throw IllegalArgumentException("錯了")
        }
    }
}

data class MultablePointer(var x:Int, var y:Int) {
    operator fun plus(p:Pointer) :Pointer {
        return Pointer(this.x + p.x, this.y + p.y)
    }
}

operator fun MultablePointer.set(index:Int, value:Int){
    return when(index) {
        0 -> x = value
        1 -> y = value
        else -> {
            throw IllegalArgumentException("錯了")
        }
    }
}

fun main(args: Array<String>) {
    val p =  Pointer(5,8)
    println(p[0])

    val p2 = MultablePointer(5, 9)
}