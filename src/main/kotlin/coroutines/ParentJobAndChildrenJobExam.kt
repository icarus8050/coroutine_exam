package coroutines

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        val job: Job = launch() {
            delay(1000L)
        }
        val parentJob: Job = coroutineContext.job
        println(job == parentJob)
        val parentChildren: Sequence<Job> = parentJob.children
        println(parentChildren.first() == job)
    }
}
