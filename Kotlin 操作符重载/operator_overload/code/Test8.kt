package com.better.operator_overload.code

class Person(val firstName: String, val lastName: String)
    : Comparable<Person> {
    override operator fun compareTo(other: Person): Int {
        // 先姓，再名
        return compareValuesBy(this, other, Person::lastName,
                Person::firstName)
    }
}

fun main(args: Array<String>) {
    val p = Person("alice", "bb")
    val p1 = Person("joy", "jd")
    println(p > p1)
}