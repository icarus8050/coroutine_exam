package coroutines.coroutine_scope

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

data class Details(val name: String ,val fllowers: Int)
data class Tweet(val text: String)
class ApiException(
    val code: Int,
    message: String,
) : Throwable(message)

fun getFollowersNumber(): Int = throw ApiException(500, "Service unavailable")

suspend fun getUserName(): String {
    delay(2000)
    return "icarus"
}

suspend fun getTweets(): List<Tweet> {
    return listOf(Tweet("Hello, world"))
}

suspend fun getUserDetails(): Details = coroutineScope {
    val userName = async { getUserName() }
    val followersNumber = async { getFollowersNumber() }
    Details(userName.await(), followersNumber.await())
}

fun main() = runBlocking {
    val details = try {
        getUserDetails()
    } catch (e: ApiException) {
        null
    }
    val tweets = async { getTweets() }
    println("User: $details")
    println("Tweets: ${tweets.await()}")
    // User: null
    // Tweets: [Tweet(text=Hello, world)]
}
