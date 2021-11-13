import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {
        val measureTimeMillis = measureTimeMillis {
            val name = async { getName() }
            val lastName = async { getLastName() }
            println("Hello, ${name.await()} ${lastName.await()}")
        }
        println(measureTimeMillis)
    }
    println("Hello World!")
}

suspend fun getName(): String {
    delay(1000)
    return "Chul"
}

suspend fun getLastName(): String {
    delay(1000)
    return "Yun"
}