package mrkinfotech.priyanshu.diplomapaperss.ui.Home

import HomeAdapter
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import mrkinfotech.priyanshu.diplomapaperss.R
import mrkinfotech.priyanshu.diplomapaperss.databinding.FragmentFirstBinding
import mrkinfotech.priyanshu.diplomapaperss.ui.ModelClass.HomeData
import mrkinfotech.priyanshu.diplomapaperss.ui.Semester.Semester

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private lateinit var adapter: HomeAdapter
    lateinit var userlist: ArrayList<HomeData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)

        userlist = ArrayList()


        userlist.add(HomeData("IT Department", R.drawable.itlogo, R.drawable.bg_card_blue))
        userlist.add(HomeData("Chemical Department", R.drawable.chemical, R.drawable.bg_card_green))
        userlist.add(HomeData("Civil Department", R.drawable.ic_civil, R.drawable.bg_card_orange))
        userlist.add(
            HomeData(
                "Mechenical Department",
                R.drawable.mechenicaleng,
                R.drawable.bg_card_gray
            )
        )
        adapter = HomeAdapter(requireContext(), userlist) { selectedItem ->
            val intent = Intent(requireContext(), Semester::class.java)
            startActivity(intent)
        }
        binding.rvDepartments.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvDepartments.adapter = adapter
        binding.rvDepartments.setHasFixedSize(true)

        return binding.root


    }
}
