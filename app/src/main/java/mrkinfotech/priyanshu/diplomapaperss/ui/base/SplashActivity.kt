package mrkinfotech.priyanshu.diplomapaperss.ui.base

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import mrkinfotech.priyanshu.diplomapaperss.R
import mrkinfotech.priyanshu.diplomapaperss.ui.Home.HomeMainActivity
import mrkinfotech.priyanshu.diplomapaperss.ui.login.LoginActivity
import mrkinfotech.priyanshu.diplomapaperss.ui.utils.PreferenceHelper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = when {
                !PreferenceHelper.getUserOnboading(this) -> {
                    Intent(this, OnBodyingActivity::class.java)
                }
                PreferenceHelper.isUserLoggedIn(this) -> {
                    Intent(this, HomeMainActivity::class.java)
                }
                else -> {
                    Intent(this, LoginActivity::class.java)
                }
            }
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(intent)
            finish()
        }, 2500)
    }
}
