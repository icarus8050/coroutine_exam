package coroutines

import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

class CounterContext(
    private val name: String,
) : CoroutineContext.Element {
    override val key: CoroutineContext.Key<*> = Key
    private var nextNumber = 0

    companion object Key: CoroutineContext.Key<CounterContext>

    fun printNext() {
        println("$name: $nextNumber")
        nextNumber++
    }
}

suspend fun printNext() {
    coroutineContext[CounterContext]?.printNext()
}

suspend fun main() {
    withContext(CounterContext("Outer")) {
        printNext() // Outer: 0

        launch {
            printNext() // Outer: 1
            launch {
                printNext() // Outer: 2
            }
            launch(CounterContext("Inner")) {
                printNext() // Inner: 0
                printNext() // Inner: 1
                launch {
                    printNext() // Inner: 2
                }
            }
        }
        printNext() // Outer: 3
    }
}
