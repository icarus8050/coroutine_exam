import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class ContinuationMain {
}

suspend fun main() {
    println("Before")

    suspendCoroutine<Unit> {
        invokeAfterSecond(2) {
            it.resume(Unit)
        }
    }

    println("After")
}

fun invokeAfterSecond(sleepTime: Int, operation: () -> Unit) {
    thread {
        println("Thread sleep : $sleepTime seconds..")
        Thread.sleep((sleepTime * 1000).toLong())
        operation.invoke()
    }
}