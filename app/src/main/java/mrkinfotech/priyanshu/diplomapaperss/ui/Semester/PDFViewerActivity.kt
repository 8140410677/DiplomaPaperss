package mrkinfotech.priyanshu.diplomapaperss.ui.Semester

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import mrkinfotech.priyanshu.diplomapaperss.R
import java.io.File
import com.github.barteksc.pdfviewer.PDFView



class PDFViewerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdfviewer)
        val pdfView = findViewById<PDFView>(R.id.pdfView)

        val pdfPath = intent.getStringExtra("PDF_PATH")

        pdfPath?.let {
            pdfView.fromAsset(it)
                .enableSwipe(true)
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .load()
        }
    }
}
