package mrkinfotech.priyanshu.diplomapaperss.ui.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mrkinfotech.priyanshu.diplomapaperss.R
import mrkinfotech.priyanshu.diplomapaperss.databinding.FragmentFirstBinding
import mrkinfotech.priyanshu.diplomapaperss.ui.Adapter.DepartmentAdapter
import mrkinfotech.priyanshu.diplomapaperss.ui.Adapter.HomeAdapter
import mrkinfotech.priyanshu.diplomapaperss.ui.ModelClass.Department

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private lateinit var adapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
         return binding.root


        binding.rvDepartments.layoutManager = GridLayoutManager(requireContext(), 2)

        val departmentList = listOf(
            Department("IT", R.drawable.itlogo),
            Department("Chemical", R.drawable.chemicallogo),
            Department("Mechanical", R.drawable.mechenical),
            Department("Civil", R.drawable.civil)
        )
        adapter = HomeAdapter(departmentList)
        binding.rvDepartments.adapter = adapter
    }
}
