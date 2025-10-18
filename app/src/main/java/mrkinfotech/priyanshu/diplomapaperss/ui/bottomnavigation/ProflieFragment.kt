package mrkinfotech.priyanshu.diplomapaperss.ui.bottomnavigation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import mrkinfotech.priyanshu.diplomapaperss.R
import mrkinfotech.priyanshu.diplomapaperss.databinding.FragmentProflieBinding
import mrkinfotech.priyanshu.diplomapaperss.ui.login.LoginActivity

class ProflieFragment : Fragment() {
    private lateinit var auth : FirebaseAuth
    private lateinit var binding : FragmentProflieBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProflieBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnEditProfile.setOnClickListener {
           val intent = Intent(requireContext(), EditProflie::class.java)
            startActivity(intent)
        }

        auth = FirebaseAuth.getInstance()

        loadUserData()

        binding.btnLogoutProfile.setOnClickListener {
            auth.signOut()
            startActivity(Intent(requireContext(), LoginActivity::class.java))
            requireActivity().finish()
        }
    }

    override fun onResume() {
        super.onResume()
        loadUserData()
    }

    private fun loadUserData() {
        val user = auth.currentUser
        if (user != null) {
            binding.ProflieName.text = user.displayName ?: "User"
            binding.ProflieEmail.text = user.email

            Glide.with(this)
                .load(user.photoUrl)
                .placeholder(R.drawable.ic_person)
                .into(binding.profileImage)
        }
    }
}