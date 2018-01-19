package com.better.reflect


fun main(args: Array<String>) {
    // 引用特定对象的实例方法
    val numberRegex = "\\d+".toRegex()
    println(numberRegex.matches("30"))

    // 返回改对象上的函数引用
    val isNumber:(CharSequence) -> Boolean = numberRegex::matches

    val matches:(Regex, CharSequence) ->Boolean =  Regex::matches

    println(isNumber("abc"))

    val strings = listOf("abc", "124", "ddd")
    println(strings.filter(numberRegex::matches))
    println(matches(numberRegex, "aa"))
}