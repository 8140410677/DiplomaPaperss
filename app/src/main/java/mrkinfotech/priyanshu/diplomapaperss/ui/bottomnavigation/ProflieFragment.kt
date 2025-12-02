package mrkinfotech.priyanshu.diplomapaperss.ui.bottomnavigation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import mrkinfotech.priyanshu.diplomapaperss.R
import mrkinfotech.priyanshu.diplomapaperss.databinding.FragmentProflieBinding
import mrkinfotech.priyanshu.diplomapaperss.ui.login.LoginActivity
import mrkinfotech.priyanshu.diplomapaperss.ui.navigationDrawer.FeedbackActivity
import mrkinfotech.priyanshu.diplomapaperss.ui.navigationDrawer.SettingsActivity
import mrkinfotech.priyanshu.diplomapaperss.ui.utils.CustomDiloag
import java.io.File

class ProflieFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: FragmentProflieBinding
    private lateinit var toggle: ActionBarDrawerToggle

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
        setupDrawer()
    }

    private fun setupDrawer() {
        toggle = ActionBarDrawerToggle(
            requireActivity(),
            binding.drawerLayout,
            R.string.open,
            R.string.close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.toolbar.setNavigationOnClickListener {
            if (binding.drawerLayout.isDrawerOpen(binding.navigationView)) {
                binding.drawerLayout.closeDrawer(binding.navigationView)
            } else {
                binding.drawerLayout.openDrawer(binding.navigationView)
            }
        }

        val headerView = binding.navigationView.getHeaderView(0)
        val headerName = headerView.findViewById<TextView>(R.id.headerUserName)
        val headerEmail = headerView.findViewById<TextView>(R.id.headerUserEmail)
        val headerImage = headerView.findViewById<ImageView>(R.id.headerProfileImage)

        val user = auth.currentUser
        if (user != null) {
            headerName.text = user.displayName ?: "User"
            headerEmail.text = user.email ?: "user@example.com"
            Glide.with(this)
                .load(user.photoUrl)
                .placeholder(R.drawable.ic_person)
                .error(R.drawable.ic_person)
                .into(headerImage)
        }

        binding.btnLogout.setOnClickListener {
            logoutUser()
        }

        binding.btnEditProfile.setOnClickListener {
            val intent = Intent(requireContext(), EditProflie::class.java)
            startActivity(intent)
        }

        binding.navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_edit_profile -> {
                    startActivity(Intent(requireContext(), EditProflie::class.java))
                }

                R.id.nav_feedback -> {
                    startActivity(Intent(requireContext(), FeedbackActivity::class.java))
                }

                R.id.nav_settings -> {
                    startActivity(Intent(requireContext(), SettingsActivity::class.java))
                }

                R.id.nav_logout -> {
                    CustomDiloag.confirom(
                        requireContext(),
                        "Logout",
                        "Are you sure you want to log out?"
                    ) {
                        logoutUser()
                    }
                }
            }
            binding.drawerLayout.closeDrawers()
            true
        }
    }

    private fun logoutUser() {
        auth.signOut()

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).build()
        val googleSignInClient = GoogleSignIn.getClient(requireContext(), gso)

        googleSignInClient.signOut().addOnCompleteListener {
            val intent = Intent(requireContext(), LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            requireActivity().finish()
        }
    }

    private fun loadUserData() {
        val sharedPrefs = requireContext().getSharedPreferences("ProfileData", Context.MODE_PRIVATE)
        val localName = sharedPrefs.getString("name", null)
        val localPhotoPath = sharedPrefs.getString("photoPath", null)

        if (!localName.isNullOrEmpty()) {
            binding.ProflieName.text = localName
        }

        if (!localPhotoPath.isNullOrEmpty()) {
            val file = File(localPhotoPath)
            if (file.exists()) {
                Glide.with(requireContext())
                    .load(file)
                    .centerCrop()
                    .into(binding.profileImage)
            }
        }

        val user = FirebaseAuth.getInstance().currentUser

        if (localName.isNullOrEmpty()) {
            binding.ProflieName.text = user?.displayName ?: "User"
        }

        if (localPhotoPath.isNullOrEmpty()) {
            Glide.with(requireContext())
                .load(user?.photoUrl)
                .placeholder(R.drawable.ic_person)
                .error(R.drawable.ic_person)
                .centerCrop()
                .into(binding.profileImage)
        }

        binding.ProflieEmail.text = user?.email ?: "user@example.com"
    }
}
