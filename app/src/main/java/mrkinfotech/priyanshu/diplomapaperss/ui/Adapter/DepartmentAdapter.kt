package mrkinfotech.priyanshu.diplomapaperss.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mrkinfotech.priyanshu.diplomapaperss.R
import mrkinfotech.priyanshu.diplomapaperss.ui.ModelClass.Department
import mrkinfotech.priyanshu.diplomapaperss.ui.bottomnavigation.DepartFragment

class DepartmentAdapter(
private val departments: List<Department>
) : RecyclerView.Adapter<DepartmentAdapter.DepartmentViewHolder>() {

    inner class DepartmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgDept: ImageView = itemView.findViewById(R.id.imgDept)
        val tvDeptName: TextView = itemView.findViewById(R.id.tvDeptName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DepartmentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_department, parent, false)
        return DepartmentViewHolder(view)
    }

    override fun onBindViewHolder(holder: DepartmentViewHolder, position: Int) {
        val department = departments[position]
        holder.imgDept.setImageResource(department.icon)
        holder.tvDeptName.text = department.name
    }

    override fun getItemCount(): Int = departments.size
}
