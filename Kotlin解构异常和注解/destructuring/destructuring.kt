package com.pei.app.destructuring


fun main(args: Array<String>) {
    //test1()
    //test2()
    //test3()
    testList()
}


data class Person(var name: String,var age: Int)

fun test1(){
    val (name,age) = Person("zhangsan",15)
    println("name: $name")
    println("age: $age")
}

open class Student(var stuNo: String, var gender: Int){

    operator fun component1():String{
        return this.stuNo
    }
    operator fun component2(): Int{
        return this.gender
    }
}

fun test2(){
    var (stuNo, gender) = Student("001",1)
    println("stuNo: $stuNo")
    println("age: $gender")
}

//函数返回值
data class Response(val msg: String,val code: Int, val data: String)

fun request(): Response{
    //发送请求
    val response = Response("ok",200,"jsonData")
    return response
}

fun test3(){
    val response = request()
    println("msg: ${response.msg} code: ${response.code} data: ${response.data}")

    val (msg,code,data) = request()
    println("msg: $msg code: $code data: $data")

    val (_,_,result) = request()
    println("result: $result")
}

//for in
fun testForIn(){
    val map = mapOf("001" to "zhangsan")
    for(entry in map) {
        println("key: ${entry.key}, value: ${entry.value}")
    }
    for((no,name) in map) {
        println("key: $no, value: $name")
    }
}

//lambda
fun testLambda(){
    val map = mapOf("001" to "zhangsan")
    map.forEach{ entry ->
        println("key: ${entry.key} value: ${entry.value}")
    }
    map.forEach{(key,value) ->
        println("key: $key value: $value")
    }

    map.forEach(fun(entry){
        println("key: ${entry.key} value: ${entry.value}")
    })
    /*
    map.forEach(fun ((key,value)){

    })
    */
}

//list
fun testList(){
    val list = listOf(1,2,3,4,5,6)
    val (a,b,c,d,e) = list
    println("a:$a,b:$b,c:$c,d:$d,e:$e")
}

//set
fun testSet(){
    val set = setOf(1,2,3)
    //val (a,b,c) = set
    //set.component1()
}
