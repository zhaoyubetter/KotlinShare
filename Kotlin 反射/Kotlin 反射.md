### 参考：
1. Kotlin in action
2. Kotlin 官方文档

###Kotlin反射
###outlook
1. Kotlin相关反射API类；  KClass, KCallable, KFunction, KProprety
2. 函数组合的例子；
3. 绑定的函数与属性引用；
4. 实战例子（结合注解与反射实现json解析`长期`）
5. 如何通过字符串创建类（Kotlin），类似Java 中 Class.forName()

	Class.forName("java.lang.String").kotlin


#### 1.1 什么是反射？
`在运行时`，`动态`访问对象属性和方法的方式（自省）；

#### 1.2 为什么需要反射？
一般下，访问对象的方法或属性时，程序源码用的是具体的声明，编译器静态解析；某些时候，我们需要能够使用任何对象的代码，或者在运行时，才能确定具体要访问的对象；比如：json解析；

在kotlin中，有2种不同的反射API（Java与Kotlin）

> 在Android 中,反射API被打包成单独的jar；
`kotlin-reflect.jar`

####1.3 Kotlin 反射API相关的类

**a. KClass 类引用**
	
主要入口，表示一个类，对应`java.lang.Class`,
可罗列和访问类中包含的所有声明（超类中的声明）；

`String::class`返回一个KClass的实例，如需要java，则使用`.java`属性；


> println(String::class)    // 获取KClass  
println(String.javaClass)   // 获取java.lang.Class  
println(String.javaClass.kotlin) // 从Java切换到Kotlin的反射API  
	
**简单例子 memberProperties 获取属性**

	```
	open class Anim(val typeName:String)
	
	class Person(val name:String, val age:Int):Anim("huminbeans")
	
	fun main(args: Array<String>) {
	    val person = Person("better", 30)
	    val kClass = person.javaClass.kotlin
	
	    // 反射訪問所有非擴展屬性(包括父)
	    kClass.memberProperties.forEach {
	        println(it.name)        // KProperty
	    }
	}
	```



**b.KCallable**

通过`memberProperties`获取的是 `KProperty`集合，
`KProperty`继承于`KCallable`;  
`KCallable`是函数和属性的超接口，通过`call`方法，允许你调用对应的函数或者对应属性的`getter`;
	
	```
	import kotlin.reflect.KFunction2
	
	fun foo(x:Int, y:Int) = x+y
	
	fun main(args: Array<String>) {
	    // 返回KFunction的实例
	    val kFun:KFunction2<in Int,in Int,out Int> = ::foo    // 函数的引用
	    println(kFun::class)
	    println(kFun.call(1,2))  // KFunction.call()
	    println(kFun.invoke(3,5)) // 必须用2个参数,否则报错
	}
	```

`KFunction2`2表示接收2个形参，通过`invoke`方法，必须传2个参数；`call`为通用方法；

>在`kotlin.reflect`包中，找不到`KFunction2`这个类，这些类型叫做**合成的编译器生成类型**，好处就是减小`kotlin-reflect`jar包大小，并且避免了对函数参数类型的限制；

**c.KFunction 函数引用**

上面提到了一些，补充一个`无参`构造方法的引用；

// 有限也是支持的,但必须明确返回类型 `KFunction2`
`val person:KFunction2<String, Int, Person> = ::Person`


**d.KProperty 属性引用**

	```
	var myNum = 10
	
	fun main(args: Array<String>) {
	    val kProperty = ::myNum
	    println(kProperty.get())
	    kProperty.set(100)
	    // kProperty.setter.call(21)
	    println(kProperty.get())
		println(kProperty.call())
	}
	```

**注意：**
> 顶层属性表示为`KProperty0`的实例；  
> 成员属性由`KProperty1`的实例表示；调用时，需要指定接收者（对象实例）；

	```
 	val person = Person("better", 30)
    val name = Person::name     // 获取name引用
    println(name.invoke(person))
    println(name.get(person))
	```

**扩展属性引用**

	```
	val String.lastChar : Char
	    get() = this[length - 1]
	```


### 2. 函数组合
	
	```
	fun isOdd(x:Int) = x % 2 != 0
	fun length(s:String) = s.length
	
	fun <A,B,C> compose(f: (B)->C, g:(A)->B) : (A)-> C {
	    return {x->f(g(x))}
	}
	
	fun main(args: Array<String>) {
	    // <String,Int,Boolean>
	    val oddLength = compose(::isOdd, ::length)
	    val strings = listOf("a","ab","abc", "abcde")
	    println(strings.filter(oddLength))
	}
	
	```

### 3. 对比java

		```
	class A(p:Int) {
	    val p = p
	        get() = field * 2
	}
	
	fun main(args: Array<String>) {
	    val a = A(2)
	
	    // java
	    val javaGetter: Method? = A::p.javaGetter
	    val javaField : Field? = A::p.javaField
	    val clazz:Class<A> = A::class.java
	    println(javaGetter?.invoke(a))  // 4
	    javaField?.isAccessible = true
	    println(javaField?.get(a))      // 2
	
	    // kotlin
	    val kClass : KClass<A> = A::class.java.kotlin
	    println(A::p.javaGetter)
	    println(A::p.javaField)
	}
		```

### 4. 绑定的函数与属性引用

**引用特定对象的实例方法**

	```
	// 引用特定对象的实例方法
	val numberRegex = "\\d+".toRegex()
	println(numberRegex.matches("30"))
	// 返回改对象上的函数引用
	val isNumber = numberRegex::matches
	println(isNumber("abc"))
	```

**属性引用绑定**

	```
	val prop = "abcde"::length
	println(prop.get())
	```

#### 5. json 序列化与反序列化