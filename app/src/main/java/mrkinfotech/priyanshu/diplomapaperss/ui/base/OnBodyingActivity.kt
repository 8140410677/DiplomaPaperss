package mrkinfotech.priyanshu.diplomapaperss.ui.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import mrkinfotech.priyanshu.diplomapaperss.ui.Home.HomeMainActivity
import mrkinfotech.priyanshu.diplomapaperss.databinding.ActivityOnBodyingBinding
import mrkinfotech.priyanshu.diplomapaperss.ui.login.LoginActivity

class OnBodyingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnBodyingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding = ActivityOnBodyingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.getStartedButton.setOnClickListener{
           val intent = Intent(this , LoginActivity :: class.java)
            startActivity(intent)
            finish()
        }

    }
}