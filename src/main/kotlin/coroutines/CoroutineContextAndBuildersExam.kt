package coroutines

import kotlinx.coroutines.*

fun CoroutineScope.log(msg: String) {
    val name = coroutineContext[CoroutineName]?.name
    println("[$name] $msg")
}
/*
fun main() {
    runBlocking(CoroutineName("main")) {
        log("Started")  // [main] Started
        val v1 = async {
            delay(3000L)
            log("Running async")    // [main] Running async
            45
        }

        launch {
            delay(5000L)
            log("Running launch")   // [main] Running launch
        }

        log("The answer is ${v1.await()}")
        // [main] The answer is 45
    }
}
*/

fun main() {
    runBlocking(CoroutineName("main")) {
        log("Started")  // [main] Started
        val v1 = async(CoroutineName("c1")) {
            delay(3000L)
            log("Running async")    // [c1] Running async
            45
        }

        launch(CoroutineName("c2")) {
            delay(5000L)
            log("Running launch")   // [c2] Running launch
        }

        log("The answer is ${v1.await()}")
        // [main] The answer is 45
    }
}
