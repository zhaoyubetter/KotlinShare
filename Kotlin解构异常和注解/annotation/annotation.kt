
package com.pei.app.annotation

import com.pei.app.annotation.new.function
import java.lang.annotation.Inherited
import kotlin.reflect.full.functions

fun main(args: Array<String>) {
    //var test = Test()
    //var result = function()
    SubSchool::class.annotations.forEach {
        println(it)
    }

}

@Target(AnnotationTarget.CLASS,
        AnnotationTarget.FUNCTION,
        AnnotationTarget.PROPERTY,
        AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Repeatable
annotation class Table(val name: String)

open class School{
    @Deprecated("msg", ReplaceWith("nothing"))
    var stuNum = 0
}

@Table("subSchool")
//@Table("subSchool2")
class SubSchool: School()


//deprecationLevel
class Test{
    @Deprecated("this function is deprecated",
            ReplaceWith("function()","com.pei.app.annotation.new.function"),
            DeprecationLevel.WARNING
    )
    fun method(): String{
        return "method function"
    }

    fun method2():Int{
        return 2
    }
}

//lambda

annotation class Suspendable

fun testAnnotationLambda(){
    val f = @Suspendable{
        println("lambda called")
    }
    f.invoke()
}

annotation class Anno

@JavaAnno(intValue = 1,stringValue = "st")
class Apple(@field:Anno var color: String, var size: Int){

    @[JavaAnno(intValue = 0,stringValue = "") Worker]
    fun test(){

    }
}