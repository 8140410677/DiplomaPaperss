package mrkinfotech.priyanshu.diplomapaperss.ui.bottomnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import mrkinfotech.priyanshu.diplomapaperss.R
import mrkinfotech.priyanshu.diplomapaperss.databinding.FragmentDepartBinding
import mrkinfotech.priyanshu.diplomapaperss.ui.Adapter.DepartmentAdapter
import mrkinfotech.priyanshu.diplomapaperss.ui.ModelClass.Department

class DepartFragment : Fragment() {
    private lateinit var binding: FragmentDepartBinding
    private lateinit var adapter: DepartmentAdapter
    private lateinit var userlist: ArrayList<Department>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDepartBinding.inflate(layoutInflater)


        userlist = arrayListOf(
            Department("Computer Engineering", R.drawable.computereng),
            Department("Mechanical Engineering", R.drawable.mechenical),
            Department("Civil Engineering", R.drawable.civil),
            Department("Electrical Engineering", R.drawable.ic_electrical),
            Department("Automobile Engineering", R.drawable.ic_automoblie),
            Department("Chemical Engineering", R.drawable.ic_chemical),
            Department("Computer Science & Engineering", R.drawable.ic_chemical)
        )

        adapter = DepartmentAdapter(requireContext(), userlist)
        binding.rvDepartments.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvDepartments.adapter = adapter

        return binding.root
    }
}
