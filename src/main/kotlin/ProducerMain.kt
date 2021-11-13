import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main() {
    val context = newSingleThreadContext("myThread")
    val producer = GlobalScope.produce(context) {
        for (i in 0..9) {
            send(i)
        }
    }

    runBlocking {
        producer.consumeEach {
            println(it)
        }
    }
}