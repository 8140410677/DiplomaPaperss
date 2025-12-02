package mrkinfotech.priyanshu.diplomapaperss.ui.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class PreferenceHelper {
    companion object {
        private const val PREFS_NAME = "DiplomaPaperss"
        private const val USER_EMAIL = "UserEmail"
        private const val VERSION_NAME = "1"
        private const val User_Login = "true"

        fun getSharedPrefs(context: Context): SharedPreferences {
            return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        }

        fun getUserEmail(context: Context): String? {
            return getSharedPrefs(context).getString(USER_EMAIL, VERSION_NAME)
        }

        fun setUserEmail(context: Context, email: String?) {
            getSharedPrefs(context).edit { putString(USER_EMAIL, email) }
        }

        fun isUserLoggedIn(context: Context): Boolean {
            val userEmail = getUserEmail(context)
            return userEmail != null && userEmail != VERSION_NAME
        }

        fun setUserOnboading(context: Context, recoad: Boolean) {
            getSharedPrefs(context).edit { putBoolean(User_Login, recoad) }
        }

        fun getUserOnboading(context: Context): Boolean {
            return getSharedPrefs(context).getBoolean(User_Login, false)
        }


    }}