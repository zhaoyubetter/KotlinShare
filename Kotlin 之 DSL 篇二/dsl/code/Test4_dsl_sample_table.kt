package com.better.dsl.code

open abstract class MyTag(val name:String) {
    protected val children = mutableListOf<MyTag>()
    override fun toString(): String {
        return "<$name>${children.joinToString("")}</$name>"        // <td></td>
    }
}
class MyTd:MyTag("td")
class MyTr:MyTag("tr") {
    fun td(init: MyTd.() -> Unit) {
        val td = MyTd()
        td.init()
        children.add(td)
    }
}
class MyTable:MyTag("table") {
    fun tr(init: MyTr.() -> Unit) {
        val tr = MyTr()
        tr.init()
        children.add(tr)
    }
}

fun table(init: MyTable.() -> Unit) : MyTable {
    val table = MyTable()
    table.init()
    return table
}

fun main(args: Array<String>) {
    val ta = table {
        tr {
            td {  }
            td {  }
        }
    }
    println(ta)
}