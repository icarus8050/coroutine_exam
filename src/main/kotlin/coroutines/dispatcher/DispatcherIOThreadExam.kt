package coroutines.dispatcher

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

suspend fun main() = coroutineScope {
    repeat(1000) {
        launch(Dispatchers.IO) {
            Thread.sleep(200)
            val threadName = Thread.currentThread().name
            println("Running on thread: $threadName")
        }
    }
}

// Running on thread: DefaultDispatcher-worker-1
// ...
// Running on thread: DefaultDispatcher-worker-53
// Running on thread: DefaultDispatcher-worker-14
