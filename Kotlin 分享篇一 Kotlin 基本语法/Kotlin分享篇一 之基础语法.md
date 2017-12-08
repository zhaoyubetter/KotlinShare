## 参考与学习资料
1. [!http://www.runoob.com/kotlin/kotlin-tutorial.html](http://www.runoob.com/kotlin/kotlin-tutorial.html)
2. [!http://www.yiibai.com/kotlin/basic-syntax.html](http://www.yiibai.com/kotlin/basic-syntax.html)
3. [!https://github.com/wangjiegulu/kotlin-for-android-developers-zh ](https://github.com/wangjiegulu/kotlin-for-android-developers-zh )

Kotlin 是一种在 Java 虚拟机上运行的静态类型编程语言，被称之为 Android 世界的Swift，由 JetBrains 设计开发并开源。
Kotlin 可以编译成Java字节码，也可以编译成 JavaScript，方便在没有 JVM 的设备上运行。
在Google I/O 2017中，Google 宣布 Kotlin 成为 Android 官方开发语言

## 为何使用kotlin？

- 简洁: 大大减少样板代码的数量。
- 安全: 避免空指针异常等整个类的错误。
- 互操作性: 充分利用 JVM、Android 和浏览器的现有库。
- 工具友好: 可用任何 Java IDE 或者使用命令行构建。

## Kotlin 基础语法

kotlin 文件，以kt为后缀；

### 1. 包声明

类似于java，kotlin的文件，开头一般也是包名；

	package com.better
	
	fun test1() {
		println("Hello Kotlin")
	}
	class FirstClass {
	}


如上：`test1()`方法全名称为：com.better.test1();
类:`Runoob`全名称为：com.better.FirstClass;

### 2.默认导入

一个kotlin建立时，默认会导入一些包，

	kotlin.*
	kotlin.annotation.*
	kotlin.collections.*
	kotlin.comparisons.*
	kotlin.io.*
	kotlin.ranges.*
	kotlin.sequences.*
	kotlin.text.*

### 3.函数定义

跟 Java，Groovy 不同，kotlin使用 `fun` 关键字定义函数，参数格式为：`参数:类型`，
返回类型，写在参数所在右括号后，如下：`:Int`

	fun add(num1: Int, num2: Int): Int {
    	return num1.plus(num2)
	}	

我们可以将方法体作为表达式返回，让其自动推测返回类型 （去掉了 {}, 加上了 = 号）：
	
	fun add2(num1:Int, num2:Int) = num1 + num2

如果无返回值,就用 `Unit`，同于Java的void，当然 `:Unit`也可以不写；
	
	fun add3(num1: Int, num2: Int): Unit {
    	num1 + num2
	}	

#### 3.1 可变长参数

在kotlin中，函数的变长参数可以用 vararg 关键字进行标识，类似于 Java中的 `...`

	fun sum(vararg v: Int): Int {
    	var sum = 0
    	for (a in v) {
        	sum += a
    	}
    	return sum
	}

#### 3.2 lambda(匿名函数)
我们之前，讲过一些groovy，感觉挺像Groovy的闭包，
但参数的类型不能省略,如下：

	val sayHello = { name: String, msg: String ->
    	println("$name say $msg to you")
	}	
		
	
	
	// 调用
	sayHello("better", "Hello")  // sayHello.invoke()
	
	// 简便写法
	val sayHello2: (String, String) -> String = { name, msg ->  "$name say $msg to you" }
    println(sayHello2("chen", "good"))


### 4 定义变量与常量
- val 表示不可更改的,类似java中的final；
- var 可更新的；
> 格式为： var <标识符> : <类型> = <初始化值>
		
	val a:Int = 55	 // final
	var b:Int = 100	

也可以在声明时不指定类型，由编译器自动判断；
	
	var c = 1


### 5. 空的操作
#### 5.1 允许为null的定义(Any?)
	
	val a:String? = null   // String? 表示a可以为null
    println(a.toString())  // 输出null，不会报nullPointer
	println(a?.toString())      // 输出null，不做处理
    // 抛出异常
    println(a!!.toString())     // 加入 !!

演示一下方法的定义，如果允许返回 null

	fun getName():String? {		// 如果方法可能返回 null，返回值为 Any?
    	return null
	}
	

#### 5.2 if not null 缩写(?.)

	var str: String? = null  // ?表示允许为null
    println(str?.length) 	 // null

#### 5.3 if null (?:)缩写

	val data = mapOf("a" to 1, "b" to 2)
    val c = data["c"] ?: throw IllegalAccessException("c is missing!")

#### 5.4 if not null and else 缩写(?. ?:)

	var str: String? = null     		// ?表示允许为null
	println(str?.length ?: "empty")     // 为null打印empty



### 6 类型的自动转换
使用 `is` 运算符检测一个表达式是否某类型的一个实例(类似于Java中的`instanceof`关键字)

	fun getStringLength(obj: Any): Int {
    	if (obj is String) {
    	    return obj.length   // 省略强制转换了
    	}
    	return 0
	}
	
甚至还可以这样

	//  `&&` 运算符的右侧, `obj` 的类型会被自动转换为 `String`
	if (obj is String && obj.length > 0) {
        return obj.length  
    }




### 7 定义集合
集合用的是java中的集合，定义方式如下：

- list：listOf()
- set: setOf()
- map: mapOf()

>
	val items = listOf("apple", "android", "windows")
    for (i in items) {
       	println(i)
   	}
   	// 根据索引来
   	for (index in items.indices) {
       	println("item at ${index} is ${items[index]}")
   	}
	// map,不同于Groovy，他们的value里面，不允许其他类型
	val map = mapOf("a" to 1, "b" to 2, "c" to 3)       // 创建map
    println(map["a"])

### 8 区间操作(range)
	for (x in 0..5) {        // [0,5]
        println(x)
    }

    for (x in 1..20 step 2) {	// 步进2
        println(x)
    }

    for (x in 9 downTo 0 step 3) {
        println(x)
    }
	
	// 实用util操作
	for (i in 1 until 10) {   // i in [1, 10) 排除了 10
        println(i)
    }

### 9 Kotlin基本`数值`类型
Kotlin 的基本`数值`类型包括 Byte、Short、Int、Long、Float、Double 等。字符不属于数值类型，是一个独立的数据类型。 

#### 9.1 比较2个数字
Kotlin 中没有`基础数据类型，只有封装的数字类型，你每定义的一个变量，其实 Kotlin 帮你封装了一个对象，这样可以保证不会出现空指针。数字类型也一样，所有在比较两个数字的时候，就有比较数据大小和比较两个对象是否相同的区别了。
在 Kotlin 中，三个等号 === 表示比较对象地址，两个 == 表示比较两个值大小。

#### 9.2 类型转换
类型自带`toXXX`方法

	val intA: Int = 12
    println(intA.toShort())	// 转 Short

#### 9.3 数组
不同于Java，kotlin的数组，使用类Array实现，有个size属性与get、set方法，由于使用 [] 重载了 get 和 set 方法，所以我们可以通过下标很方便的获取或者设置数组对应位置的值；还记得Groovy讲过的`运算符重载`么

数组的创建两种方式：一种是使用函数arrayOf()；另外一种是使用工厂函数

	 // 第一种
    val array1 = arrayOf(1, 2, 3, 4, 5)
    // 第二种
    val array2 = Array<Int>(5, { it -> it + 1 }) //  Array<Int>(5) { it -> it + 1 }
    array2.forEach { println(it) }
	
	// 运算符重载 [] 运算符代表调用成员函数 get() 和 set()。
	println(array3[3])


除了类Array，还有ByteArray, ShortArray, IntArray，用来表示各个类型的数组，省去了装箱操作，因此效率更高，其用法同Array一样：

	intArrayOf(1, 2, 3, 4, 5)
	
**二维数组**

Kotlin中，有点小坑的2维数组定义方式：
	
	val arr = Array(5) { IntArray(5) }  // 5*5
    arr.forEach { it ->
        it.forEach { i ->
            print("$i ")
        }
        println()
    }	

还好还好，我们可以通过 `[][]` 访问二维数组内容；

### 10 字符串
类似于Java，字符串是不可变的，我们可用[] 方法字符串的字符

	val str: String = "bca"
    println(str[0])		// 不像Groovy能用 -1，kotlin语法严格

三引号 `"""` 原样输出字符串,说一下 `trimMargin() `方法；


### 11 when操作
when类似switch，但比switch更为强大

	fun describe(obj: Any): String =
        when (obj) {
            1 -> "one"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"		// 类似 default
        }

	fun main(args:Array<String>) {
    	println(describe(1))
    	println(describe("Hello"))
    	println(describe(10000L))
	}

	//-------------------------------------------------
	// 现场调试
	when (x) {
    	in 1..10 -> print("x is in the range")
    	in validNumbers -> print("x is valid")
    	!in 10..20 -> print("x is outside the range")
    	else -> print("none of the above")
	}

	fun hasPrefix(x: Any) = when(x) {
    	is String -> x.startsWith("prefix")
    	else -> false
	}


### 13 标记控制

在kotlin中使用过标识符跟@符号来定义一个标签, 如：`abc@、fooBar@`，使用@符号后面跟标识符来引用一个标签;

在kotlin中，每一个函数都与一个或多个地址对应，而每个`标签`也是与一个或多个地址对应，即函数本身也是个标签，匿名函数没有函数名，可以直接自定义一个标签来指向该地址；

#### 13.1 类似于Goto语句，跳出外层循环：

	loop@ for (i in 1..10) {
        for (j in 1..10) {
            if (i * j == 50) break@loop
            print("($i,$j)")
        }
        println()
    }


#### 13.2 标签处返回
	
	val items = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)
    // 传统方案
    items.forEach {
        if (it % 4 == 0) {
            return
        }
    }
    
	// 可这样写
    items.forEach lit@ {
        if (it % 4 == 0) return@lit
    }
    
	// 隐式标签 接受 lambda 表达式的函数同名，所以可以这样写
    items.forEach { if (it % 4 == 0) return@forEach }

	// 函数初返回
	fun test(items: IntArray) {
    	items.forEach {
    	    if (it % 4 == 0) return@test
    	}
	}
	
### 13 具体示例
	
来几个排序；

