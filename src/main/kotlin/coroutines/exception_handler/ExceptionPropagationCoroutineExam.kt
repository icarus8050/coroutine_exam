package coroutines.exception_handler

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    launch {
        launch {
            delay(1000L)
            throw Error("Some error")
        }

        launch {
            delay(2000L)
            println("Will not be printed")
        }

        launch {
            delay(500L)
            println("Will be printed")
        }
    }

    launch {
        delay(2000L)
        println("Will not be printed")
    }
}
