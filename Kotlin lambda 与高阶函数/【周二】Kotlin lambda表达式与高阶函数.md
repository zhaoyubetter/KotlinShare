###参考：
https://zhuanlan.zhihu.com/LearningKotlin

###outlook
0. 函数；
1. lambda表达式；
2. 高级函数；
3. 闭包
4. 带接收者的函数字面值；（dsl）

### 1. lambda 表达式

#### 1.1 复习一下函数

函数就是用 `fun` 定义的，包括名称、参数列表，返回值类型，和函数体；

a. 名称（一次性的）？
b. 参数列表
c. 返回值类型
d. 函数体（abstract）？

Koltin可使用类似Lambda表达式形式表示一个函数；

> (参数列表类型) -> 返回值类型,如：
> val sum : (Int,Int) -> Int

上面我们只是定义一个名称为 `sum`，参数是2个`Int`类型，返回值的Int类型的函数；我们没有实现它，需要给其赋值一个函数体的值，这时候就需要用到`匿名函数`了；

#### 1.2 Koltin 匿名函数
没有名字的函数；**Lambda 表达式可以视为立即执行的匿名函数；**
匿名函数只是描述了此函数能够干什么，名字不知道，这样，就可以把其
赋值给没有定义函数体的函数对象，形成完整的函数了；

**定位格式为：**
`fun(参数列表)：返回值类型 {// body}`

把上面的`sum`函数结合起来(将匿名函数赋值给`sum`变量)：

	```
	// 1. 原始形式
	val sum1: (Int,Int) -> Int = fun(x:Int, y:Int) : Int {
    return x + y
	}
	// 2. 简写一下
	val sum2 : (Int,Int) -> Int = fun(x:Int, y:Int) = x + y

	// 3. 再简写(匿名函数已经定义好参数列表和返回值类型了，省略 sum 的类型声明)
	val sum3  = fun(x:Int, y:Int) = x + y

	// 4. 再次精简，Lambda 表达式就是一个匿名函数，把这个匿名函数改写为 Lambda 表达式
	val sum4 = {x:Int, y:Int -> x + y}
	```

**是函数，那就要调用，如何调用，跟Groovy 闭包调用方法类似**

	```
	println(sum1(1,2))
	println(sum4.invoke(1,2))
	```
**反编译看一下代码**

### 1.2 kotlin.jvm.functions.Function 接口

请注意一下泛型，上次分享都讲过啦；





----


#### 1.3 什么是lambda？
 Lambda 表达式可以视为立即执行的匿名函数
 > 类似于Groovy中的闭包，其有3个特性：
 > 
 1. lambda 表达式总是被大括号包围着 `{}`;
 2. 其参数（if has）在 `->`之前声明，参数类型可省略（**注意**是应用时，可省略，编译器自动推断）；
 3. 函数体（if has）在`->`后面；

**Lambda完整语法格式为：**

> val sum = {x:Int, y:Int -> x + y}


简单的lambda例子：

	```
	val list = listOf(1,2,3,4,5,6,7,8)
	list.map { x:Int -> x * 2 }
	list.map {x -> x * 2}	// 应用时，类型自动推断
	```

回顾下，我们Groovy分享闭包的一些知识,同样适用在这里；
如果要在写在外面就只能用 `lambda` 类；

**例子**

- forEach；
- filter;

### 2.高阶函数

#### 2.1 什么是高阶函数？
其实上面我们已经接触过了，就是将函数用作`参数或返回值`的函数；

**例子 map 方法（RxJava）**

	```
 	val list = listOf(1,2,3,4,5,6,7,8)
    // 1.匿名函数
    list.map {
        fun(it:Int):String {
            return "number" + it
        }
    }
    // 2.匿名函数简写形式
    ~list.map {fun(it:Int) = "number"+ it}~
    list.map(fun(it:Int) = it * 2)
    // 3.lambda
    list.map { it -> "number: " + it}
    // 4.省略默认it
    list.map { "number: " + it }
    // 5.使用外界函数也是可以的：反射的时候，我们再过一下
	```

**例子：创建一个高级函数，找出list最大数**

	```
	fun <T> max(col: Collection<T>, less: (T, T) -> Boolean) : T?{
	    var max:T? = null
	    for(it in col) {
	        if(max == null || less(it, max)) {
	            max = it
	        }
	    }
	    return max
	}
```

### 3.闭包（Closure）

**闭包指 Lambda 表达式和匿名函数外部定义的局部变量，Kotlin 支持 Lambda 表达式和匿名函数访问和修改闭包。（2部分）**

> 1. 如果一个函数不修改外部数据，这是`纯函数`； 比如：+-*/
> 2. 影响外部数据的函数，如：集合的`add()`方法，这不是`纯函数`；

Kotlin支持Lambda表达式和匿名函数访问和修改闭包(Java不允许)；

	```
	val list = listOf(1,2,3,4,5,6,7,8)
	var oddNum = 0
	list.forEach { if(it % 2== 0) {oddNum++} }
	println("$oddNum")
	```


### 4.带接收者的函数字面值 (扩展匿名函数)；

#### 4.1 概念的解释

`带接收者的函数字面值`，这翻译也是神来之笔；这里参考了上述参考资料，理解起来就容易多了；


**解释下:**

1. “带接收者的函数”就是扩展函数
2. “函数字面值”就是`函数对象`,如 `val sum`；

结合起来就是**扩展函数对象**, **在定义函数对象时，在参数列表类型前加上被扩展的类型形式 Type.(Input) -> Output**

> val sum2: (Int, Int) -> Int = fun(a: Int, b: Int) = a + b
> 
> val sum1: Int.(Int) -> Int = fun Int.(other: Int) = this + other

有何用？**用来在扩展函数体内访问扩展类型的成员**，这就牛逼了；






