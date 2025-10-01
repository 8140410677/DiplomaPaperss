import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mrkinfotech.priyanshu.diplomapaperss.databinding.DepartmentItemBinding
import mrkinfotech.priyanshu.diplomapaperss.databinding.ItemDepartmentBinding
import mrkinfotech.priyanshu.diplomapaperss.ui.Home.HomeFragment
import mrkinfotech.priyanshu.diplomapaperss.ui.ModelClass.HomeData

class HomeAdapter(
    private val context: Context,
    private val userlist: List<HomeData>
) : RecyclerView.Adapter<HomeAdapter.UserHomeAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHomeAdapterViewHolder {
        val itembinding = DepartmentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserHomeAdapterViewHolder(itembinding)
    }

    override fun onBindViewHolder(holder: UserHomeAdapterViewHolder, position: Int) {
        val user = userlist[position]
        holder.binding.departmentName.text = user.name

        holder.binding.departmentIcon.setImageResource(user.icon)

        holder.binding.rootLayout.setBackgroundResource(user.bgcolor)

    }

    override fun getItemCount(): Int = userlist.size

    inner class UserHomeAdapterViewHolder(val binding: DepartmentItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}
