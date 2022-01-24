package coroutines

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        val job1 = launch {
            delay(2000L)
            println("Test1")
        }

        val job2 = launch {
            delay(1000L)
            println("Test2")
        }

        coroutineContext[Job]
            ?.children
            ?.forEach { it.join() }
        println("All tests are done")
    }
}
