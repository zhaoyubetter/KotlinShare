package com.better.dsl

open class MyTag(val name: String) {
    private val children = mutableListOf<MyTag>()

    protected fun <T : MyTag> doInit(child: T, init: T.() -> Unit) {
        child.init()    // 初始化自己
        children.add(child)
    }

    override fun toString() = "<$name>${children.joinToString("")}</$name>"
}

class MyTd : MyTag("td")

class MyTr : MyTag("tr") {
    fun td(init: MyTd.() -> Unit) = doInit(MyTd(), init)
}

class MyTable : MyTag("table") {
    fun tr(init: MyTr.() -> Unit) = doInit(MyTr(), init)
}

fun myTable(init: MyTable.() -> Unit) = MyTable().apply { init(this) }

// apply { init }  // 只是编译一下

fun main(args: Array<String>) {
    val table = myTable {
        tr {
            td { }
            td { }
        }
    }
    println(table)
}
