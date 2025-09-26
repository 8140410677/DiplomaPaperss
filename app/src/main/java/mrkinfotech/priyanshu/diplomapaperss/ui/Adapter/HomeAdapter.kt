import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mrkinfotech.priyanshu.diplomapaperss.databinding.ItemDepartmentBinding
import mrkinfotech.priyanshu.diplomapaperss.ui.Home.HomeFragment
import mrkinfotech.priyanshu.diplomapaperss.ui.ModelClass.HomeData

class HomeAdapter(
    private val context: Context,
    private val userlist: List<HomeData>
) : RecyclerView.Adapter<HomeAdapter.UserHomeAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHomeAdapterViewHolder {
        val itembinding = ItemDepartmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserHomeAdapterViewHolder(itembinding)
    }

    override fun onBindViewHolder(holder: UserHomeAdapterViewHolder, position: Int) {
        val user = userlist[position]
        holder.binding.tvDeptName.text = user.name

        holder.binding.imgDept.setImageResource(user.icon)

        holder.binding.rootLayout.setBackgroundResource(user.bgcolor)

    }

    override fun getItemCount(): Int = userlist.size

    inner class UserHomeAdapterViewHolder(val binding: ItemDepartmentBinding) :
        RecyclerView.ViewHolder(binding.root)
}
