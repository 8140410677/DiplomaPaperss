package mrkinfotech.priyanshu.diplomapaperss.ui.base

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import mrkinfotech.priyanshu.diplomapaperss.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, OnBodyingActivity::class.java)
            startActivity(intent)
            finish()
        }, 2500)



    }
}