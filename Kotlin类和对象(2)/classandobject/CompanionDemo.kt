class Factory {

    private constructor() {
    }

    companion object {
        fun create(): Factory {
            return Factory()
        }
    }
}

fun main(array: Array<String>) {
    val factory = Factory.create()
    val factory1 = Factory.Companion.create()
}