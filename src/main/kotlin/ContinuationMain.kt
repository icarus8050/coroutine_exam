import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class ContinuationMain

suspend fun main() {
    println("Before")
    val user = requestUser()
    println(user)
    println("After")
}

suspend fun requestUser(): User {
    return suspendCoroutine { cont ->
        requestUser { user ->
            cont.resume(user)
        }
    }
}

fun requestUser(operator: (User) -> Unit) {
    return operator.invoke(User("Foo"))
}

data class User(
    val name: String,
)
