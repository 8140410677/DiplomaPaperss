package mrkinfotech.priyanshu.diplomapaperss.ui.bottomnavigation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import mrkinfotech.priyanshu.diplomapaperss.databinding.FragmentFaviouritBinding
import mrkinfotech.priyanshu.diplomapaperss.ui.Adapter.DepartmentAdapter
import mrkinfotech.priyanshu.diplomapaperss.ui.ModelClass.Department

class FaviouritFragment : Fragment() {

    private lateinit var binding: FragmentFaviouritBinding
    private lateinit var adapter: DepartmentAdapter
    private lateinit var favoriteList: MutableList<Department>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFaviouritBinding.inflate(inflater, container, false)
        return binding.root
    }
}

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        loadFavorites()
//    }
//
//    private fun loadFavorites() {
//        val prefs = requireContext().getSharedPreferences("favorites_prefs", Context.MODE_PRIVATE)
//        val json = prefs.getString("favorites_list", null)
//
////        if (json != null) {
////            val type = object : TypeToken<MutableList<Department>>() {}.type
////            favoriteList = Gson().fromJson(json, type)
////        } else {
////            favoriteList = mutableListOf()
////        }
////
////        if (favoriteList.isEmpty()) {
////            binding.faviouriteimage.visibility = View.VISIBLE
////            binding.tvfavorite.visibility = View.VISIBLE
////        } else {
////            binding.faviouriteimage.visibility = View.GONE
////            binding.tvfavorite.visibility = View.GONE
////        }
////
////        adapter = DepartmentAdapter(requireContext(), favoriteList) { /* nothing */ }
//       // binding.rvFavorites.layoutManager = GridLayoutManager(requireContext(), 2)
//        //binding.rvFavorites.adapter = adapter
//    }
//}
