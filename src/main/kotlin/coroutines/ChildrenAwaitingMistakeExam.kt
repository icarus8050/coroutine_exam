package coroutines

import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main(): Unit = coroutineScope {
    val job = Job()
    launch(job) {
        delay(1000L)
        println("Text 1")
    }
    launch(job) {
        delay(2000L)
        println("Text 2")
    }
    job.join()
}
