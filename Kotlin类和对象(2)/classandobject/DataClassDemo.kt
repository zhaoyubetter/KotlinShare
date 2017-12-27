data class Book(var name: String, val date: String)


fun main(args: Array<String>) {
    var book = Book("kotlin", "2017");
    book.component1();
    book.component2();
    var pair = Pair(Book("c", "2017"), Book("b", "2016"));
    pair.first
    pair.second
    var triple = Triple(Book("c", "2017"), Book("b", "2016"), Book("c", "2017"));
    triple.first
}