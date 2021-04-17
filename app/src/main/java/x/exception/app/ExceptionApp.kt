package x.exception.app

import android.app.Application
import android.util.Log.getStackTraceString
import x.exception.lib.CrashHandler
import x.exception.lib.util.LogHelper.Companion.write

class ExceptionApp : Application() {

    override fun onCreate() {
        super.onCreate()

        CrashHandler.init { timeMillis: Long, thread: Thread, throwable: Throwable ->
            write(applicationContext, "logger", "$timeMillis --> ${thread.name}: ${getStackTraceString(throwable)}")
        }

    }

}