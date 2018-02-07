package com.better.dsl

open class Tag

class TABLE : Tag() {

    fun tr(init:  TR.() -> Unit) {
        TR().init()
    }
}

class TR : Tag() {
    fun td(init: TD.() -> Unit) {

    }
}

class TD:Tag()

fun table(init: TABLE.() -> Unit) = TABLE().init()

fun main(args: Array<String>) {
    table {
        tr {
        }
        tr {

        }
    }
}