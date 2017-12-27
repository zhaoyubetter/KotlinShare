enum class Color {
    YELLOW, RED, GREED
}

enum class STATE(var state: Int) {
    STATE_OPEN(1) {
        override fun toggle() {
            this.state = STATE_CLOSE.state;
        }

    },
    STATE_CLOSE(2) {
        override fun toggle() {
            this.state = STATE_OPEN.state;
        }
    };

    abstract fun toggle()
}

fun main(array: Array<String>) {
    val color = Color.valueOf("RED")
    println("$color")
    println(enumValueOf<Color>("RED"))

    val colors = enumValues<Color>();
    for (temp in colors) {
        println(temp.name);
    }
}