package com.better.inline
/**
 * Created by zhaoyu1 on 2018/1/4.
 */
//这个方法的意思是，具体化一个 T 的类型参数，追加一个 membersOf 的方法，
// 方法返回结果是 T 这个类中的 members
inline fun <reified T> membersOf() = T::class.members
fun main(args: Array<String>) {
    println(membersOf<StringBuffer>().joinToString("\n"))
}
