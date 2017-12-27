interface Callback {
    fun onSuccess(result: String)
}

open class Adapter : Callback {
    override fun onSuccess(result: String) {
        print("adapter")
    }
}

class Network(var callback: Callback) {
    fun get() {
        callback.onSuccess("get ")
    }
}

fun main(array: Array<String>) {
    val network = Network(object : Callback {
        override fun onSuccess(result: String) {
            print("onSuccess")
        }
    })

    val network1 = Network(object : Adapter() {
        override fun onSuccess(result: String) {
            print("onSuceess")
        }
    })
    network.get()
    network1.get()
}