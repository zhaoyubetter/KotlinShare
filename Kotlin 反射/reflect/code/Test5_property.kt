package com.better.reflect.code

import kotlin.reflect.KMutableProperty0
import kotlin.reflect.KProperty1


var name:String = "better"


fun main(args: Array<String>) {
    val kProp: KMutableProperty0<String> = ::name      // ::
    kProp.get()
    kProp.set("abbcc")

    val person = Person("better", 30)
    val kPropName:KProperty1<Person, String> = Person::name
    kPropName.get(person)
}