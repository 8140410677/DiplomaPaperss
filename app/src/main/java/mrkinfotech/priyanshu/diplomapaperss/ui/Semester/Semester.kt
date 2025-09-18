package mrkinfotech.priyanshu.diplomapaperss.ui.Semester

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mrkinfotech.priyanshu.diplomapaperss.R
import mrkinfotech.priyanshu.diplomapaperss.databinding.ActivitySemesterBinding

class Semester : AppCompatActivity() {

    private lateinit var binding: ActivitySemesterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivitySemesterBinding.inflate(layoutInflater)
        setContentView(binding.root)








    }


}