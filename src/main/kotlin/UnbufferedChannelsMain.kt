import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {
        val time = measureTimeMillis {
            val channel = Channel<Int>()
            val sender = GlobalScope.launch {
                repeat(10) {
                    channel.send(it)
                }
            }
            println("Sent ${channel.receive()}")
            println("Sent ${channel.receive()}")
            println("Sent ${channel.receive()}")
            println("Sent ${channel.receive()}")
            println("Sent ${channel.receive()}")
            println("Sent ${channel.receive()}")
            println("Sent ${channel.receive()}")
            println("Sent ${channel.receive()}")
            println("Sent ${channel.receive()}")
            println("Sent ${channel.receive()}")
        }
        println("Took ${time}ms")
    }
}