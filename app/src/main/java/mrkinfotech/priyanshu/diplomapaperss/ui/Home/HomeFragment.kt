package mrkinfotech.priyanshu.diplomapaperss.ui.Home

import HomeAdapter
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import mrkinfotech.priyanshu.diplomapaperss.R
import mrkinfotech.priyanshu.diplomapaperss.databinding.FragmentFirstBinding
import mrkinfotech.priyanshu.diplomapaperss.ui.ModelClass.HomeData
import mrkinfotech.priyanshu.diplomapaperss.ui.Semester.SemesterActivity
import mrkinfotech.priyanshu.diplomapaperss.ui.SemsterShow.SemesterAstivity

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var adapter: HomeAdapter
    private lateinit var userlist: ArrayList<HomeData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        binding = FragmentFirstBinding.inflate(inflater, container, false)

        MobileAds.initialize(requireContext())

        val adRequest = AdRequest.Builder().build()
        binding.adViewBanner.loadAd(adRequest)

        userlist = ArrayList()
        userlist.add(HomeData("IT Department", R.drawable.itlogo, R.drawable.bg_card_blue))
        userlist.add(HomeData("Chemical Department", R.drawable.chemical, R.drawable.bg_card_green))
        userlist.add(HomeData("Civil Department", R.drawable.ic_civil, R.drawable.bg_card_orange))
        userlist.add(
            HomeData(
                "Mechanical Department", R.drawable.mechenicaleng, R.drawable.bg_card_gray
            )
        )

        adapter = HomeAdapter(requireContext(), userlist){ item ->
            val intent = Intent(requireContext(), SemesterAstivity::class.java)
            intent.putExtra("DEPARTMENT_NAME", item.name)
            startActivity(intent)
        }

        binding.rvDepartments.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvDepartments.adapter = adapter




        return binding.root
    }
}
