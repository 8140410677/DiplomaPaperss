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

            if (PreferenceHelper.getonBoardshow(this)) {

                if(PreferenceHelper.isUserLoggedIn(this)){
                    startActivity(Intent(this, HomeMainActivity::class.java))
                } else {
                    startActivity(Intent(this, LoginActivity::class.java))
                }
            } else {
                startActivity(Intent(this, OnBodyingActivity::class.java))
            }
        }, 2500)



    }
}