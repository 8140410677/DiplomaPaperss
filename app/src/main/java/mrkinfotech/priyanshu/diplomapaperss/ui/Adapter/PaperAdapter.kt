package mrkinfotech.priyanshu.diplomapaperss.ui.Adapter

import android.content.Context
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import mrkinfotech.priyanshu.diplomapaperss.R
import mrkinfotech.priyanshu.diplomapaperss.ui.ModelClass.DownloadedPaper
import mrkinfotech.priyanshu.diplomapaperss.ui.ModelClass.Paper
import mrkinfotech.priyanshu.diplomapaperss.ui.ModelClass.DownloadStore

import java.io.File
import java.io.FileOutputStream

class PaperAdapter(
    private val papers: List<Paper>,
    private val onItemClick: (Paper) -> Unit
) : RecyclerView.Adapter<PaperAdapter.PaperViewHolder>() {

    inner class PaperViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvPaper: TextView = itemView.findViewById(R.id.tvPaper)
        val btnDownload: Button = itemView.findViewById(R.id.btnDownload)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaperViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_paper, parent, false)
        return PaperViewHolder(view)
    }

    override fun onBindViewHolder(holder: PaperViewHolder, position: Int) {
        val paper = papers[position]
        holder.tvPaper.text = paper.name

        holder.itemView.setOnClickListener { onItemClick(paper) }

        holder.btnDownload.setOnClickListener {
            val context = holder.itemView.context
            downloadFromAssets(context, paper.filePath, paper.name)
        }
    }

    override fun getItemCount(): Int = papers.size

    private fun downloadFromAssets(context: Context, assetPath: String, fileName: String) {
        try {
            val cleanPath = assetPath.replace("assets/", "")
            val inputStream = context.assets.open(cleanPath)
            val downloadsDir =
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            val outFile = File(downloadsDir, "$fileName.pdf")

            val outputStream = FileOutputStream(outFile)
            inputStream.copyTo(outputStream)
            inputStream.close()
            outputStream.close()

            DownloadStore.addDownload(
                context,
                DownloadedPaper(fileName, outFile.absolutePath)
            )

            Toast.makeText(context, "Downloaded & saved to Downloads tab!", Toast.LENGTH_SHORT).show()

        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(context, "Error: File not found in Assets", Toast.LENGTH_SHORT).show()
        }
    }


}
