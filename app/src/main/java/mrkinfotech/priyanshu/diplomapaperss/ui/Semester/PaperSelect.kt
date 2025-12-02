package mrkinfotech.priyanshu.diplomapaperss.ui.Semester

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import mrkinfotech.priyanshu.diplomapaperss.databinding.ActivityPaperSelectBinding

class PaperSelect : AppCompatActivity() {

    private lateinit var binding: ActivityPaperSelectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPaperSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val semesterName = intent.getStringExtra("SEMESTER_NAME")
        binding.tvSemester.text = semesterName

        binding.winter.setOnClickListener {
            val subjectName = intent.getStringExtra("SUBJECT_NAME")
            val semesterName = intent.getStringExtra("SEMESTER_NAME")

            val winter = Intent(this, PaperListActivity::class.java)
            winter.putExtra("SEMESTER_NAME", semesterName)
            winter.putExtra("PAPER_TYPE", "Winter")
            winter.putExtra("SUBJECT_NAME", subjectName)
            startActivity(winter)
        }

        binding.cardSummer.setOnClickListener {
            val subjectName = intent.getStringExtra("SUBJECT_NAME")
            val semesterName = intent.getStringExtra("SEMESTER_NAME")

            val summer = Intent(this, PaperListActivity::class.java)
            summer.putExtra("SEMESTER_NAME", semesterName)
            summer.putExtra("PAPER_TYPE", "Summer")
            summer.putExtra("SUBJECT_NAME", subjectName)
            startActivity(summer)
        }

    }
}
