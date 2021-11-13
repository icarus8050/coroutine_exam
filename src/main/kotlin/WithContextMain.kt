import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() {
    runBlocking {
        val dispatcher = newSingleThreadContext("myThread")
        val name = withContext(dispatcher) {
            "Susan Calvin"
        }

        println("User: $name")
    }
}