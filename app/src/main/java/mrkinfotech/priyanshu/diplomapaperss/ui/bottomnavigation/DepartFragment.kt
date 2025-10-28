package mrkinfotech.priyanshu.diplomapaperss.ui.bottomnavigation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import mrkinfotech.priyanshu.diplomapaperss.R
import mrkinfotech.priyanshu.diplomapaperss.databinding.FragmentDepartBinding
import mrkinfotech.priyanshu.diplomapaperss.ui.Adapter.DepartmentAdapter
import mrkinfotech.priyanshu.diplomapaperss.ui.ModelClass.Department
import mrkinfotech.priyanshu.diplomapaperss.ui.Semester.Semester

class DepartFragment : Fragment() {
    private lateinit var binding: FragmentDepartBinding
    private lateinit var adapter: DepartmentAdapter
    private lateinit var userlist: ArrayList<Department>
    private lateinit var filteredList: ArrayList<Department>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDepartBinding.inflate(layoutInflater)

        userlist = arrayListOf(
            Department("Computer Engineering", R.drawable.computereng),
            Department("Information Technology", R.drawable.itlogo),
            Department("Mechanical Engineering", R.drawable.mechenical),
            Department("Civil Engineering", R.drawable.civil),
            Department("Electrical Engineering", R.drawable.electrical),
            Department("Electronics and Communication Engineering", R.drawable.ec),
            Department("Automobile Engineering", R.drawable.automoblie),
            Department("Chemical Engineering", R.drawable.chemical),
            Department("Mechatronics Engineering", R.drawable.mechatronics),
            Department("Instrumentation and Control Engineering", R.drawable.instrumentation),
            Department("Plastic Engineering", R.drawable.plastic),
            Department("Textile Manufacturing Technology", R.drawable.textile),
            Department("Biomedical Engineering", R.drawable.biomedical),
            Department("Environmental Engineering", R.drawable.environmental),
            Department("Mining Engineering", R.drawable.mining),
            Department("Metallurgical Engineering", R.drawable.metallurgy),
            Department("Power Electronics Engineering", R.drawable.powerelectronics),
            Department("Architecture Assistantship", R.drawable.architecture),
            Department("Printing Technology", R.drawable.printing),
            Department("Petroleum Engineering", R.drawable.petroleum)
        )

        filteredList = ArrayList(userlist)

        adapter = DepartmentAdapter(requireContext(), filteredList) { department ->
            val intent = Intent(requireContext(), Semester::class.java)
            intent.putExtra("DEPARTMENT_NAME", department.name)
            startActivity(intent)
        }

        binding.rvDepartments.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvDepartments.adapter = adapter

        setupSearchView()

        return binding.root
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterList(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })
    }

    private fun filterList(query: String?) {
        filteredList.clear()
        if (query.isNullOrEmpty()) {
            filteredList.addAll(userlist)
        } else {
            val searchText = query.lowercase()
            for (dept in userlist) {
                if (dept.name.lowercase().contains(searchText)) {
                    filteredList.add(dept)
                }
            }
        }
        adapter.notifyDataSetChanged()
    }
}
