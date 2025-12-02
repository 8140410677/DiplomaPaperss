package mrkinfotech.priyanshu.diplomapaperss.ui.utils

import android.content.Context
import android.widget.Toast

object CustomDiloag {


    fun customMessage(context: Context, message: String) {
        val me = Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun confirom(
        context: Context,
        title: String,
        message: String,
        onYes: () -> Unit
    ) {
        val dialog = android.app.AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("Yes") { _, _ -> onYes() }
            .setNegativeButton("No", null)
            .create()
        dialog.show()
    }





}