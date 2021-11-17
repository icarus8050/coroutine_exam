import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import java.util.concurrent.atomic.AtomicInteger

var counter = AtomicInteger()

fun asyncIncrement(by: Int) = GlobalScope.async {
    for (i in 0 until by) {
        counter.incrementAndGet()
    }
}

fun main() {
    runBlocking {
        val workerA = asyncIncrement(2000)
        val workerB = asyncIncrement(100)

        workerA.await()
        workerB.await()
        println("counter [$counter]")
    }
}