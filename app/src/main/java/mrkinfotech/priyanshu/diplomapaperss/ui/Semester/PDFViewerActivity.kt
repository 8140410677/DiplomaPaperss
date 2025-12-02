package mrkinfotech.priyanshu.diplomapaperss.ui.Semester

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.barteksc.pdfviewer.PDFView
import mrkinfotech.priyanshu.diplomapaperss.R

class PDFViewerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdfviewer)

        val pdfView = findViewById<PDFView>(R.id.pdfView)

        val pdfFile = intent.getStringExtra("PDF_PATH")

        if (pdfFile.isNullOrEmpty()) {
            Toast.makeText(this, "PDF path missing!", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            pdfView.fromAsset(pdfFile)
                .enableSwipe(true)
                .enableDoubletap(true)
                .load()

        } catch (e: Exception) {
            Toast.makeText(this, "Error: PDF not found in Assets!", Toast.LENGTH_LONG).show()
        }
    }
}
