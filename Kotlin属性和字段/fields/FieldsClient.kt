package com.sugarya.example.extend

import com.sugarya.example.others.CODE_SOLID
import com.sugarya.example.others.wait

object FieldsClient {

    @JvmStatic
    fun main(args: Array<String>) {
//        testNestedExntendClass()
//        testExtendMethod()
        testLateinitField()
    }


    fun testNestedExntendClass(){
     val innerFather = Child.InnerFather()

    }

    fun testLateinitField(){
        val child = Child()
        child.test?.length

    }

    fun testConstField(){
        Child.Temp.SOLID2
        CODE_SOLID
    }


}



