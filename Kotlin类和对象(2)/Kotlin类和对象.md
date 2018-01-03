#Kotlin 分享
##数据类

```kotlin
data class Book(var name: String, var date: String)
```

###自动生成

1. equals()/hashCode
2. toString()
3. componentN() 按照顺序对应于所有属性
4. copy() 

###数据类要求

1. 主构造函数至少有个参数
2. 主构造函数需要标记val、var
3. 数据类不能abstract、open sealed、inner

###标准数据类

1. Pair
2. Triple

##密封类

####密封类好处

使用when表达式，不需要else

```kotlin
fun eval(anim: Anim) {
    when (anim) {
        is Dog -> TODO()
        is Cat -> TODO()
        is Fish -> TODO()
    }
}
```

##匿名内部类

使用对象表达式声明object {}

```kotlin
interface Callback {
    fun onSuccess(result: String)
}

class Network(var callback: Callback) {
    fun get() {
        callback.onSuccess("get ")
    }
}


fun main(array: Array<String>) {
    val network = Network(object : Callback {
        override fun onSuccess(result: String) {
            print("onSuccess = " + result)
        }
    })
    network.get()
}
```

##枚举类
1. 初始化
2. 匿名枚举
3. valueOf、values

```kotlin
enum class State {
    STATE_OPEN {
        override fun toggle(): State = STATE_CLOSE
    },

    STATE_CLOSE {
        override fun toggle() = STATE_OPEN
    };

    abstract fun toggle(): State
}
```

###Companion Object
```kotlin
class Factory {

    companion object Create {
        fun create(): Factory {
            return Factory()
        }
    }
}
```