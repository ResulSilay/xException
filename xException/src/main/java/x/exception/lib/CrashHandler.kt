package x.exception.lib

class CrashHandler {

    companion object {

        fun init(onException: (timeMillis: Long, thread: Thread, throwable: Throwable) -> Unit) {
            Thread.setDefaultUncaughtExceptionHandler(ExceptionHandler(exception = { timeMills: Long, thread: Thread, throwable: Throwable ->
                onException(timeMills, thread, throwable)
            }))
        }

        class ExceptionHandler(val exception: (timeMillis: Long, thread: Thread, e: Throwable) -> Unit) : Thread.UncaughtExceptionHandler {
            override fun uncaughtException(t: Thread, e: Throwable) {
                exception(System.currentTimeMillis(), t, e)
            }
        }
    }
}