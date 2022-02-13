package coroutines.dispatcher

import kotlinx.coroutines.*
import java.util.concurrent.Executors

var i = 0
suspend fun main(): Unit = coroutineScope {
    val dispatcher = Executors.newSingleThreadExecutor()
        .asCoroutineDispatcher()

    repeat(10_000) {
        launch(dispatcher) {
            i++
        }
    }
    delay(1000)
    println(i)
    dispatcher.close()
}
