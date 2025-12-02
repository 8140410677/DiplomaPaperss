package mrkinfotech.priyanshu.diplomapaperss.ui.bottomnavigation

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import mrkinfotech.priyanshu.diplomapaperss.R
import mrkinfotech.priyanshu.diplomapaperss.databinding.ActivityEditProflieBinding
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

class EditProflie : AppCompatActivity() {

    private lateinit var binding: ActivityEditProflieBinding
    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProflieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ProflieprogressBar.visibility = View.GONE

        val sharedPrefs = getSharedPreferences("ProfileData", Context.MODE_PRIVATE)
        val name = sharedPrefs.getString("name", "")
        val photoPath = sharedPrefs.getString("photoPath", null)

        binding.Proflieeditname.setText(name)
        if (!photoPath.isNullOrEmpty()) {
            val file = File(photoPath)
            if (file.exists()) {
                Glide.with(this).load(file).into(binding.ProflieeditPhoto)
            } else {
                binding.ProflieeditPhoto.setImageResource(R.drawable.ic_person)
            }
        }

        binding.ProfliechangePhoto.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 100)
        }

        binding.editSave.setOnClickListener {
            val newName = binding.Proflieeditname.text.toString().trim()

            if (newName.isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            binding.ProflieprogressBar.visibility = View.VISIBLE
            binding.editSave.isEnabled = false

            var savedImagePath: String? = null
            imageUri?.let { uri ->
                savedImagePath = saveImageToInternalStorage(uri)
            }

            val editor = sharedPrefs.edit()
            editor.putString("name", newName)
            savedImagePath?.let { editor.putString("photoPath", it) }
            editor.apply()

            Toast.makeText(this, "Profile updated successfully", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun saveImageToInternalStorage(uri: Uri): String {
        val inputStream: InputStream? = contentResolver.openInputStream(uri)
        val file = File(filesDir, "profile_image_${System.currentTimeMillis()}.jpg")
        val outputStream = FileOutputStream(file)
        inputStream?.copyTo(outputStream)
        inputStream?.close()
        outputStream.close()
        return file.absolutePath
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == Activity.RESULT_OK) {
            imageUri = data?.data
            binding.ProflieeditPhoto.setImageURI(imageUri)
        }
    }
}
