package x.exception.lib.util

import android.content.Context
import java.io.File
import java.io.FileOutputStream

class LogHelper {

    companion object {

        fun write(context: Context, fileName: String, log: String) {
            val file = File(context.filesDir, "${fileName}.log")
            file.createNewFile()
            FileOutputStream(file, true).bufferedWriter().use { writer ->
                writer.appendln(log)
            }
        }
    }
}
