import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val task = GlobalScope.launch {
            printCurrentThread()
        }
    }
    println("Running in thread [${Thread.currentThread().name}]")
    println("completed")
    Thread.sleep(5000)
}

suspend fun printCurrentThread() {
    delay(2000)
    println("Running in thread [${Thread.currentThread().name}]")
}