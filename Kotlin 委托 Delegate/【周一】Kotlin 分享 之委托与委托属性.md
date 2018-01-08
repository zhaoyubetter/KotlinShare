### 参考：
http://www.runoob.com/kotlin/kotlin-delegated.html

### 本节，分享内容如下：
1. 委托的定义；
2. 类委托；
3. 委托属性；
4. 局部委托属性；
5. 委托属性的要求；
6. 提供委托；



---

### 什么是委托
- Java中的代理（Proxy）
	在代理模式中，自己不干活，将或全部抛给另一方；
- 在委托或代理中，有2个对象参与处理同一个请求；
- kotlin直接支持委托通过关键字`by`实现委托

### 类委托
一个类中定义的方法实际上调用另一个类的对象的方法来实现的；

**实现步骤：**
	
- 演示代码；
- 反编译代码；
- 委托类也可添加自己的方法；

### 委托属性

属性委托指的是一个类的某个属性值不是在类中直接进行定义，
而是将其托付给一个代理类，从而实现对该类的属性统一管理

语法格式：
	
	val/var <属性名>: <类型> by <表达式>

`by` 关键字之后的表达式就是委托，属性的get、set将委托给该对象的
`getValue()` 与 `setValue()`
属性委托不必实现任何接口, 但必须提供 getValue() 函数(对于 var属性,还需要 setValue() 函数)。

#### 实现属性委托的例子

1. 首先，我们定义一个被委托的类，如下：

	class Baby {
    	var name:String by Delegate()
	}

2. 定义属性委托类 （setValue 与 getValue 格式固定）：

	`class Delegate {
    	operator fun getValue(thisRef : Any?, property: 	KProperty<*> ):String {
    	    return ("$thisRef delegating $property.name")
    	}
    	operator fun setValue(thisRef: Any?, property: 	KProperty<*>, value:String) {
    	    println("$value has been assigned to ${property.name} in ${thisRef}")
    	}
	}`

### 委托属性的常见的3种

- 1. 延迟属性（lazy）:首次访问时计算；
- 2. 可观察属性（observable）；
- 3. 多个属性存在一个map中，而非单独字段；

针对这些，kotlin提供有用的工厂方法；

#### 1. 延迟属性（lazy）
接收一个`lambda`并返回一个Lazy<T>实例的函数，该实例作为延迟属性的委托；

```
class LazyClass {

    // 延迟属性委托（val）
    val lazyValue: String by lazy {
        println("get value")
        "Hello"
    }

    // 延迟加载 （var）
    lateinit var lateValue: String

    fun printLateValue(): String {
        lateValue = "abc"
        return lateValue
    }
}```

复习一下延迟加载，为什么是`val`与`var`


#### 2. 可观察属性(Observable)
也就是让属性实现观察者模式；

Delegates.observable() 函数接受两个参数;我们来写代码

	```
	// 可观察的属性
	class Test4_Property_Observable {
	    var name: String by Delegates.observable("zhaoyu") { prop, old, new ->
	        println("${prop.name} $old ==>$new")
	    }
	}
	```
我们升级一下程序，使用 `vetoable`

	```
	class Test5_Property_Observable_2 {
	    var name: String by Delegates.vetoable("zhaoyu") { prop, old, new ->
	        if (new == "ergouzi") {
	            println("fuck!!! the name is not appropriate")
	            return@vetoable false   // 局部返回，我们后面会说的，先别着急
	        }
	        return@vetoable true
	    }
	}
	```
#### 3. 多个属性存在一个map中(Observable)

常见的用例是在一个映射（map）里存储属性的值;
经常出现在像解析 JSON 或者做其他"动态"事情的应用中。 可以使用映射实例自身作为委托来实现委托属性。
json的演示就不做了。相信大家会的；

	```
	data class Test6_Property_map(val map:Map<String, Any?>) {
	    val name:String by map
	    val pwd:String by map
	}
	
	fun main(args: Array<String>) {
	    val map = mapOf("name" to "better", "pwd" to "123")
	    val test = Test6_Property_map(map)
	    println("${test.name} ===> ${test.pwd}")
	}
	```

### 局部委托属性

可以将局部变量声明为委托属性。 可以使一个局部变量惰性初始化：
没有合适例子；

### 委托属性的要求

1. 对于只读（val）属性，委托必须提供一个名为`getValue`函数，其参数如下：
 - thisRef - 须与属性所有者类型类型相同或其超类型；
 - property - 必须是类型 `KProperty<*>`或其super；
2. 对于可变（var）属性，需提供一个额外的`setValue`函数,具体看上面例子吧；


### 提供委托
通过定义`provideDelegate`操作符，可扩展创建属性实现所委托对象的逻辑；如`by`右侧所使用的对象将`provideDelegate`定义为成员或扩展函数，那么会调用该函数来创建属性委托实例；

跳过；
看不明白；



