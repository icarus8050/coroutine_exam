package coroutines.dispatcher

import kotlinx.coroutines.Job
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.util.concurrent.Executors
import kotlin.system.measureTimeMillis

suspend fun main(): Unit = coroutineScope {
    val dispatcher = Executors.newSingleThreadExecutor()
        .asCoroutineDispatcher()

    val job = Job()
    repeat(5) {
        launch(dispatcher + job) {
            Thread.sleep(1000)
        }
    }
    job.complete()
    val time = measureTimeMillis { job.join() }
    println("Took $time")
    dispatcher.close()
}
