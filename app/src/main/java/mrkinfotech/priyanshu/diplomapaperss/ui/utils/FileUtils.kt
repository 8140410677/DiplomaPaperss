package mrkinfotech.priyanshu.diplomapaperss.ui.Utils

import android.content.ContentValues
import android.content.Context
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

object FileUtils {

    fun saveStreamToDownloads(
        context: Context,
        inputStream: InputStream,
        fileName: String,
        mime: String = "application/pdf"
    ): String? {
        return try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val values = ContentValues().apply {
                    put(MediaStore.MediaColumns.DISPLAY_NAME, fileName)
                    put(MediaStore.MediaColumns.MIME_TYPE, mime)
                    put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS + "/DiplomaPaperss")
                }
                val resolver = context.contentResolver
                val uri = resolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, values)
                    ?: return null

                resolver.openOutputStream(uri)?.use { out ->
                    inputStream.use { inp -> inp.copyTo(out) }
                }

                uri.toString()
            } else {
                val downloads =
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                val appFolder = File(downloads, "DiplomaPaperss")
                if (!appFolder.exists()) appFolder.mkdirs()
                val outFile = File(appFolder, fileName)

                FileOutputStream(outFile).use { fos ->
                    inputStream.use { inp -> inp.copyTo(fos) }
                }

                outFile.absolutePath
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    fun copyAssetToDownloads(context: Context, assetPath: String, fileName: String): String? {
        return try {
            context.assets.open(assetPath).use { input ->
                saveStreamToDownloads(context, input, fileName)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
