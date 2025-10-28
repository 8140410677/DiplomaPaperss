package mrkinfotech.priyanshu.diplomapaperss.ui.ModelClass

import android.content.Context
import android.content.Intent
import com.google.gson.Gson

object DownloadStore {
    private const val PREF = "downloads_pref"
    private const val KEY_LIST = "downloads_list"
    const val ACTION_DOWNLOADS_UPDATED = "mrkinfotech.ACTION_DOWNLOADS_UPDATED"

    private fun prefs(context: Context) =
        context.getSharedPreferences(PREF, Context.MODE_PRIVATE)

    fun addDownload(context: Context, item: DownloadedPaper) {
        val list = getAll(context).toMutableList()
        list.add(0, item)
        val json = Gson().toJson(list)
        prefs(context).edit().putString(KEY_LIST, json).apply()
        context.sendBroadcast(Intent(ACTION_DOWNLOADS_UPDATED))
    }

    fun getAll(context: Context): List<DownloadedPaper> {
        val json = prefs(context).getString(KEY_LIST, "[]")
        val arr = Gson().fromJson(json, Array<DownloadedPaper>::class.java)
        return arr?.toList() ?: emptyList()
    }

    fun clearAll(context: Context) {
        prefs(context).edit().remove(KEY_LIST).apply()
        context.sendBroadcast(Intent(ACTION_DOWNLOADS_UPDATED))
    }
}