package com.better.dsl


data class Issue(
    val id: String, val project: String, val type: String,
    val priority: String, val description: String
)

// FunctionN
class ImportantIssuesPredicate(val project: String) : (Issue) -> Boolean {
    // 拆分多个方法
    override fun invoke(issue: Issue): Boolean {
        return issue.project == project && issue.isImportant()
    }
    private fun Issue.isImportant(): Boolean {
        return type == "Bug" && (priority == "Major" || priority == "Critical")
    }
}

fun main(args: Array<String>) {
    val i1 = Issue("Android-1234", "Android", "Bug",  "Major", "Login fail")
    val i2 = Issue("iOS-1234", "iOS", "Bug",  "Major", "Login fail")
    val p = ImportantIssuesPredicate("Android")

    for(i in listOf(i1,i2).filter{p.invoke(it)}) {  // p invoke p
        println(i.id)
    }

    for(i in listOf(i1,i2).filter(p)) {  // p invoke p
        println(i.id)
    }

//    for(i in listOf(i1,i2).filter {
//        it.project == "Android" &&
//                it.type == "Bug" && (it.priority == "Major" || it.priority == "Critical")
//    }) {
//        println(i.id)
//    }
}