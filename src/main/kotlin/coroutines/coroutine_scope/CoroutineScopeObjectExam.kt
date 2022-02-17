package coroutines.coroutine_scope

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

public fun CoroutineScope(
    context: CoroutineContext
): CoroutineScope =
    ContextScope(
        if (context[Job] != null) context
        else context + Job()
    )

internal class ContextScope(
    context: CoroutineContext
) : CoroutineScope {
    override val coroutineContext: CoroutineContext = context
    override fun toString(): String = "CoroutineScope(coroutineContext=$coroutineContext)"
}
