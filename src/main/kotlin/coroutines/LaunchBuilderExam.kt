package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    GlobalScope.launch {
        myFunction()
    }
    println("Done")
    println(Thread.currentThread().name)
    Thread.sleep(3000L)
}

suspend fun myFunction() {
    println("Before")
    println(Thread.currentThread().name)
    delay(2000L)
    println(Thread.currentThread().name)
    println("After")
}
