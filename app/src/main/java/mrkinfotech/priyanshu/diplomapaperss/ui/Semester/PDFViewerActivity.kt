package mrkinfotech.priyanshu.diplomapaperss.ui.Semester

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.barteksc.pdfviewer.PDFView
import mrkinfotech.priyanshu.diplomapaperss.R
import java.io.IOException

class PDFViewerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdfviewer)

        val pdfView = findViewById<PDFView>(R.id.pdfView)
        val pdfPath = intent.getStringExtra("PDF_PATH")

        if (pdfPath != null) {
            // Always load from inside assets folder
            val correctPath = if (pdfPath.startsWith("paper/")) pdfPath else "paper/$pdfPath"

            try {
                pdfView.fromAsset(correctPath)
                    .enableSwipe(true)
                    .swipeHorizontal(false)
                    .enableDoubletap(true)
                    .load()
            } catch (e: IOException) {
                e.printStackTrace()
                Toast.makeText(this, "Error loading PDF: $correctPath", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "PDF path missing!", Toast.LENGTH_SHORT).show()
        }
    }
}
