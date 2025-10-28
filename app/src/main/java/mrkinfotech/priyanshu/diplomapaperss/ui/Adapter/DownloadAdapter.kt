package mrkinfotech.priyanshu.diplomapaperss.ui.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mrkinfotech.priyanshu.diplomapaperss.R
import mrkinfotech.priyanshu.diplomapaperss.ui.ModelClass.DownloadedPaper
import java.text.SimpleDateFormat
import java.util.*

class DownloadAdapter(
    private var data: MutableList<DownloadedPaper>,
    private val onItemClick: (String) -> Unit
) : RecyclerView.Adapter<DownloadAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvDate: TextView = view.findViewById(R.id.tvDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_download, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.tvName.text = item.name
        holder.tvDate.text = SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.getDefault()).format(Date(item.downloadedAt))
        holder.itemView.setOnClickListener {
            onItemClick(item.filePath)
        }
    }

    override fun getItemCount(): Int = data.size

    fun updateList(newList: List<DownloadedPaper>) {
        data.clear()
        data.addAll(newList)
        notifyDataSetChanged()
    }
}
