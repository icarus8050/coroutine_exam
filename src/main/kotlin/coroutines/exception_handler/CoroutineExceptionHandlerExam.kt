package coroutines.exception_handler

import kotlinx.coroutines.*

fun main(): Unit = runBlocking {
    val handler = CoroutineExceptionHandler { ctx, exception ->
        println("caught $exception")
    }

    val scope = CoroutineScope(SupervisorJob() + handler)
    scope.launch {
        delay(1000)
        throw Error("Some error")
    }

    scope.launch {
        delay(2000)
        println("Will be printed")
    }

    delay(3000)
}
