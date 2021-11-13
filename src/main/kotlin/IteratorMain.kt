fun main() {
    val foo = Foo(4)
    val iterator = iteratorBuilder(foo)
    while (iterator.hasNext()) {
        println(iterator.next())
    }
    println(foo)
}

fun iteratorBuilder(foo: Foo): Iterator<Int> {
    return iterator {
        while (foo.value < 10) {
            Thread.sleep(1000L)
            yield(foo.value++)
        }
    }
}

data class Foo(
    var value: Int
)
