package mrkinfotech.priyanshu.diplomapaperss.ui.bottomnavigation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import mrkinfotech.priyanshu.diplomapaperss.R
import mrkinfotech.priyanshu.diplomapaperss.databinding.FragmentProflieBinding
import mrkinfotech.priyanshu.diplomapaperss.ui.login.LoginActivity

class ProflieFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: FragmentProflieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProflieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()
        loadUserData()

        binding.btnOpenDrawer.setOnClickListener {
            binding.drawerLayout.openDrawer(binding.navigationView)
        }

        binding.navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_edit_profile -> {
                    startActivity(Intent(requireContext(), EditProflie::class.java))
                }

                R.id.nav_feedback -> {
                    sendFeedback()
                }

                R.id.nav_logout -> {
                    auth.signOut()
                    startActivity(Intent(requireContext(), LoginActivity::class.java))
                    requireActivity().finish()
                }
            }
            binding.drawerLayout.closeDrawers()
            true
        }
    }

    private fun sendFeedback() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "message/rfc822"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("support@yourapp.com"))
        intent.putExtra(Intent.EXTRA_SUBJECT, "App Feedback")
        intent.putExtra(Intent.EXTRA_TEXT, "Hi, I would like to share my feedback:")
        startActivity(Intent.createChooser(intent, "Send Feedback"))
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
