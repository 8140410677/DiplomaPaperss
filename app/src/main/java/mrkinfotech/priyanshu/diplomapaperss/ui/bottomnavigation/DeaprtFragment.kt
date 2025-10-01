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
import mrkinfotech.priyanshu.diplomapaperss.ui.ModelClass.HomeData

class DepartFragment : Fragment() {
    private lateinit var binding: FragmentDeaprtBinding
    private lateinit var adapter : DepartmentAdapter
    lateinit var userlist : ArrayList<Department>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDeaprtBinding.inflate(inflater, container, false)

            userlist = ArrayList()
            userlist.add(Department("Computer Engineering" , R.drawable.computereng))
            userlist.add(Department("Mechanical Engineering" , R.drawable.mechenical))
            userlist.add(Department("Civil Engineering",R.drawable.civil))
            userlist.add(Department("Electrical Engineering" , R.drawable.ic_electrical))
            userlist.add(Department("Automobile Engineering", R.drawable.ic_automoblie))
            userlist.add(Department("Chemical Engineering" , R.drawable.ic_chemical))
            userlist.add(Department("Computer Science & Engineering " , R.drawable.ic_chemical))
            userlist.add(Department("Chemical Engineering" , R.drawable.ic_chemical))
            userlist.add(Department("Chemical Engineering" , R.drawable.ic_chemical))
            userlist.add(Department("Chemical Engineering" , R.drawable.ic_chemical))
            userlist.add(Department("Chemical Engineering" , R.drawable.ic_chemical))



            val adapter = DepartmentAdapter(requireContext(), userlist)
        binding.rvDepartments?.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvDepartments?.adapter = adapter

        return binding.root
    }
}
