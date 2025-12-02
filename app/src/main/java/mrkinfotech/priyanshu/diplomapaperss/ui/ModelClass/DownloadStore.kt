package mrkinfotech.priyanshu.diplomapaperss.ui.ModelClass

import android.content.Context
import android.content.Intent
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object DownloadStore {

    private const val PREF = "downloads_pref"
    private const val KEY_LIST = "downloads_list"
    const val ACTION_DOWNLOADS_UPDATED = "mrkinfotech.ACTION_DOWNLOADS_UPDATED"

    private fun prefs(context: Context) =
        context.getSharedPreferences(PREF, Context.MODE_PRIVATE)

    fun addDownload(context: Context, item: DownloadedPaper) {
        val list = getAll(context).toMutableList()
        list.add(0, item)   // Add latest at top

        saveList(context, list)
        notifyChange(context)
    }

    fun getAll(context: Context): List<DownloadedPaper> {
        val json = prefs(context).getString(KEY_LIST, null) ?: return emptyList()

        return try {
            val type = object : TypeToken<List<DownloadedPaper>>() {}.type
            Gson().fromJson(json, type) ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }

    fun clearAll(context: Context) {
        prefs(context).edit().remove(KEY_LIST).apply()
        notifyChange(context)
    }

    private fun saveList(context: Context, list: List<DownloadedPaper>) {
        val json = Gson().toJson(list)
        prefs(context).edit().putString(KEY_LIST, json).apply()
    }

    private fun notifyChange(context: Context) {
        context.sendBroadcast(Intent(ACTION_DOWNLOADS_UPDATED))
    }
}
