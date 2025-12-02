package mrkinfotech.priyanshu.diplomapaperss.ui.navigationDrawer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.firebase.auth.FirebaseAuth
import mrkinfotech.priyanshu.diplomapaperss.databinding.ActivitySettingsBinding
import android.widget.Toast

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.tvAppInfo.setOnClickListener {
            Toast.makeText(this, "Diploma Papers", Toast.LENGTH_LONG).show()
        }
    }
}
