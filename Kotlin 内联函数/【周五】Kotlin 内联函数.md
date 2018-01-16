### 参考：
https://zhuanlan.zhihu.com/p/27269110

### outline
0. 高阶函数补充知识；
1. 内联函数与禁用内联，crossInline；
2. reified 修饰符（具体化参数类型）；

###1. 内联函数
####1.1 什么是内联函数？

建议编译器将指定的函数体插入并取代每一处调用该函数的地方（上下文），从而节省了每次调用函数带来的额外时间开支；（from WiKi）

有一些高阶函数函数就是`内联的`，比如：map、foreach 等；

**示例**

	```
	inline fun repeat(times:Int, action: (time:Int)->Unit) {
	    for(index in (0 until times)) {
	        action(index)
	    }
	}
	```

**Kotlin不建议非高阶函数（或大函数）改为内联**

	```
	inline fun foo(it:String) =  println(it)
	```

内联最好与有 Lambda 表达式参数的函数配合使用；

####1.2 禁用内联

使用关键字 `noinline`

	```
	inline fun method(repeat: ()->Unit, noinline foo: () -> Unit ) {
	    var l = foo     // 当做普通字段用
	    repeat()
	    l.invoke()
	}
	
	fun main(args: Array<String>) {
	    method( { println("Hello repeat") }, {println("Hello Inline")})
	}
	```

####1.3 非局部返回

在Groovy，我们提供 闭包的返回，不能代替整个函数的返回；  
在Koltin中，这个提示做的更好；

	```
	fun <T> Iterable<T>.myForEach(action: (T)->Unit) {
	    for (element in this) {
	        action(element)
	    }
	}
	
	fun testMethod1() : Boolean {
	    val list = listOf(1,2,3,4,5,6)
	    list.myForEach {
	        if(it % 2 == 0) return true		// not allow
	    }
	    return false
	}
	```

将 `myForEach`方法改成内联的就行了，为什么呢？

####1.4 crossinline 

用来控制函数参数调用时，只允许`局部返回（表达式内返回）`；

	```
	// 理解 crossinline
	inline fun <T> Iterable<T>.m2ForEach(
	        crossinline action: (T)->Unit,
	         action2:(T,T) -> Boolean) {
	    for (element in this) {
	        action(element)
	        action2(element,element)
	    }
	}
	
	fun main(args: Array<String>) {
	    val list = listOf(1,2,3,4,5,6,6)
	    list.m2ForEach({ if(it % 2 == 0) {
	        return@m2ForEach        // 
	    }}, { a, b->
	       return
	    })
	    println("aaaa")
	}
	```


### 2. reified 具体类型

`reified` 表示`具体的`意思，在`Kotlin`中这个关键字只用来修饰  
**泛型内联函数的类型参数，要求这个内联函数在展开到调用时，必须用一个具体的类型来替换类型参数**
主要用来替代不必要的Class<T> 传参，简化代码，提高效率；

注意：`reified` 需要与 `inline` 一起使用；

	```
	// 获取T类型的所有方法
	inline fun <reified T> listMethodsOf() = T::class.java.methods.toList()
	```

通过 inline - reified 组合使用，我们可以避免传递没有必要的 Class 参数，使用更加简单易懂的泛型参数来调用函数。



**注意的点**
>reified 关键字要求调用时必须使用具体的类型，不能使用泛型；
>
>使用了 reified 关键字修饰的内联函数，不能在 Java 中调用;

#### 2.1 实化类型参数 例子1

	```
	// 不允许，泛型被擦除
	//fun <T> isA(value:Any?) = value is T
	
	// 使用内联结合reified，类型参数可以实化
	inline fun <reified T> isA(value:Any) = value is T
	```

#### 2.2 实化类型参数 例子2
	
	```
	inline fun <reified T> Iterator<*>.filterIsInstance(): List<T> {
	     val dest = mutableListOf<T>()
	     for(item in this) {
	         if(item is T) {
	             dest.add(item)
	         }
	     }
	     return dest
	}
	```

**为什么可以这样操作**

调用带实化类型参数的函数时，编译器知道了这次特定调用用作`类型实参`的确切类型;
因为你传给他了；

