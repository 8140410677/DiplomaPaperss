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
import mrkinfotech.priyanshu.diplomapaperss.ui.ModelClass.Paper
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
            val assetPath = paper.filePath // e.g. "papers/sem1/maths1_winter2022.pdf"
            val fileName = assetPath.substringAfterLast("/")
            copyAssetToDownloads(context, assetPath, fileName)
        }
    }

    override fun getItemCount(): Int = papers.size
}

private fun copyAssetToDownloads(context: Context, assetPath: String, fileName: String) {
    try {
        val inputStream = context.assets.open(assetPath)
        val downloadsDir =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        val outFile = File(downloadsDir, fileName)

        val outputStream = FileOutputStream(outFile)
        inputStream.copyTo(outputStream)
        inputStream.close()
        outputStream.close()

        Toast.makeText(context, "Downloaded: $fileName", Toast.LENGTH_SHORT).show()
    } catch (e: Exception) {
        e.printStackTrace()
        Toast.makeText(context, "Error downloading file", Toast.LENGTH_SHORT).show()
    }
}
