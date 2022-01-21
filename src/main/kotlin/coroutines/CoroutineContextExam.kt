package coroutines

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

fun main() {
    val ctx1: CoroutineContext = CoroutineName("Name1")
    println(ctx1[CoroutineName]?.name)
    println(ctx1[Job]?.isActive)
    println("---------------------")

    val ctx2: CoroutineContext = Job()
    println(ctx2[CoroutineName]?.name)
    println(ctx2[Job]?.isActive)
    println("---------------------")

    val ctx3 = ctx1 + ctx2
    println(ctx3[CoroutineName]?.name)
    println(ctx3[Job]?.isActive)
    println("---------------------")

    val ctx4 = MyCoroutineContext("hello") + ctx3
    println(ctx4[CoroutineName]?.name)
    println(ctx4[Job]?.isActive)
    println(ctx4[MyCoroutineContext]?.name)
}

data class MyCoroutineContext(
    val name: String,
) : AbstractCoroutineContextElement(MyCoroutineContext) {
    companion object Key : CoroutineContext.Key<MyCoroutineContext>
}
