package com.better.operator_overload.code

operator fun Pointer.minus(p:Pointer) : Pointer {
    return Pointer(this.x - p.x, this.y - p.y)
}

operator fun Pointer.times(time:Int) : Pointer {
    return Pointer(this.x * time, this.y * time)
}

operator fun Int.times(p:Pointer): Pointer {
    return Pointer(this - p.x, this - p.y)
}



fun main(args: Array<String>) {
//    val p1 = Pointer(0, 0)
//    val p2 = Pointer(5, 5)
//    println(p1 - p2)

    val p1 = Pointer(5, 5)
    val p2 = Pointer(3, 3)

    println(p1 + p2 * 5)


}