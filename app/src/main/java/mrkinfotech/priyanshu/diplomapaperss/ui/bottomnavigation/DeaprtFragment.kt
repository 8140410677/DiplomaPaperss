package mrkinfotech.priyanshu.diplomapaperss.ui.bottomnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import mrkinfotech.priyanshu.diplomapaperss.R
import mrkinfotech.priyanshu.diplomapaperss.databinding.FragmentDeaprtBinding
import mrkinfotech.priyanshu.diplomapaperss.ui.Adapter.DepartmentAdapter
import mrkinfotech.priyanshu.diplomapaperss.ui.ModelClass.Department

class DepartFragment : Fragment() {
    private lateinit var binding: FragmentDeaprtBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDeaprtBinding.inflate(inflater, container, false)

        val departments = listOf(
            Department("Computer Engineering", R.drawable.computereng),
            Department("Mechanical Engineering", R.drawable.mechenicaleng),
            Department("Civil Engineering", R.drawable.ic_civil),
            Department("Electrical Engineering", R.drawable.ic_electrical),
            Department("Automobile Engineering", R.drawable.ic_automoblie),
            Department("Chemical Engineering", R.drawable.ic_chemical)
        )

        val adapter = DepartmentAdapter(departments)
        binding.rvDepartments.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvDepartments.adapter = adapter

        return binding.root
    }
}
