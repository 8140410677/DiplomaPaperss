package mrkinfotech.priyanshu.diplomapaperss.ui.Semester

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mrkinfotech.priyanshu.diplomapaperss.R
import mrkinfotech.priyanshu.diplomapaperss.databinding.ActivityMainBinding
import mrkinfotech.priyanshu.diplomapaperss.databinding.ActivityPaperSelectBinding
import mrkinfotech.priyanshu.diplomapaperss.ui.utils.CustomDiloag

class PaperSelect : AppCompatActivity() {

    private lateinit var binding: ActivityPaperSelectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPaperSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val semesterName = intent.getStringExtra("SEMESTER_NAME")
        binding.tvSemester.text = semesterName

        binding.winter.setOnClickListener {
            val intent = Intent(this, PaperListActivity::class.java)
            intent.putExtra("SEMESTER_NAME", semesterName)
            intent.putExtra("PAPER_TYPE", "Winter")
            intent.putExtra("SUBJECT_NAME", intent.getStringExtra("SUBJECT_NAME"))
            startActivity(intent)
        }


        binding.cardSummer.setOnClickListener {
            val intent = Intent(this, PaperListActivity::class.java)
            intent.putExtra("SEMESTER_NAME", semesterName)
            intent.putExtra("PAPER_TYPE", "Winter")
            intent.putExtra("SUBJECT_NAME", intent.getStringExtra("SUBJECT_NAME"))
            startActivity(intent)
        }

    }
}
