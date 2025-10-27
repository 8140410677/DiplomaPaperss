package mrkinfotech.priyanshu.diplomapaperss.ui.utils

import android.content.Context
import android.widget.Toast

object CustomDiloag {


    fun customMessage(context: Context, message: String) {
        val me = Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }


}