import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val dispatcher = newSingleThreadContext(name = "ServiceCall")
        val task = GlobalScope.launch(dispatcher) {
            printCurrentThread()
        }
        task.join()
        println("completed")
    }
}

fun printCurrentThread() {
    println("Running in thread [${Thread.currentThread().name}]")
}