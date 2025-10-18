package mrkinfotech.priyanshu.diplomapaperss.ui.bottomnavigation

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import mrkinfotech.priyanshu.diplomapaperss.R
import mrkinfotech.priyanshu.diplomapaperss.databinding.ActivityEditProflieBinding
import mrkinfotech.priyanshu.diplomapaperss.databinding.ActivityMainBinding

class EditProflie : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityEditProflieBinding
    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditProflieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.ProflieprogressBar.visibility = View.GONE

        //  current user info Load karse Aa Function App ni Ander
        val user = auth.currentUser
        user?.let {
            binding.Proflieeditname.setText(it.displayName)
            binding.Proflieeditemail.setText(it.email)
            Glide.with(this)
                .load(it.photoUrl)
                .placeholder(R.drawable.ic_person)
                .into(binding.ProflieeditPhoto)
        }

        // jayare Aapde Photo Change Karva Mate Karshu Tyare Call Thase
        binding.ProfliechangePhoto.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 100)
        }

        // User Save  button click karse Tyare Call Thase
        binding.editSave.setOnClickListener {
            val newName = binding.Proflieeditname.text.toString().trim()

            if (newName.isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }



            binding.ProflieprogressBar.visibility = View.VISIBLE
            binding.editSave.isEnabled = false

            val builder = UserProfileChangeRequest.Builder()
                .setDisplayName(newName)

            if (imageUri != null) {
                builder.setPhotoUri(imageUri)
            }

            val profileUpdates = builder.build()
            user?.updateProfile(profileUpdates)
                ?.addOnCompleteListener { task ->
                    // Hide loading
                    binding.ProflieprogressBar.visibility = View.GONE
                    binding.editSave.isEnabled = true

                    if (task.isSuccessful) {
                        Toast.makeText(this, "Profile Updated", Toast.LENGTH_SHORT).show()
                        finish()
                    } else {
                        Toast.makeText(this, "Failed to update profile", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

    // jayare User Galaly mathi Photo Select karse Tyare Aa Run Thase
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == Activity.RESULT_OK) {
            imageUri = data?.data
            binding.ProflieeditPhoto.setImageURI(imageUri)
        }
    }
}

