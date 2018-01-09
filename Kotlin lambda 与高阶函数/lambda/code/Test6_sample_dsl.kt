package com.better.lambda.code

fun html(init: HTML.() -> Unit) {
    val html = HTML()
    html.init()
}
class HTML {
    fun body(init: Body.()->Unit){
        val b = Body()
        b.init()
    }
}
class Body {
    fun content() {
        println("Body content() called")
    }
}

fun main(args: Array<String>) {
    html {
        body {
            content()
        }
    }
}