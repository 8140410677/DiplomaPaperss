package mrkinfotech.priyanshu.diplomapaperss.ui.Semester

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import mrkinfotech.priyanshu.diplomapaperss.databinding.ActivitySemesterBinding

class SemesterActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySemesterBinding
    private var departmentName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySemesterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        departmentName = intent.getStringExtra("DEPARTMENT_NAME")

        binding.firstsemester.setOnClickListener { openSubjectActivity("semester1") }
        binding.secondSemester.setOnClickListener { openSubjectActivity("semester2") }
        binding.thirdSemester.setOnClickListener { openSubjectActivity("semester3") }
        binding.fourthsemester.setOnClickListener { openSubjectActivity("semester4") }
        binding.fifthSemester.setOnClickListener { openSubjectActivity("semester5") }
        binding.sixSemester.setOnClickListener { openSubjectActivity("semester6") }
    }

    private fun openSubjectActivity(semesterName: String) {
        val intent = Intent(this, SubjectActivity::class.java)
        intent.putExtra("DEPARTMENT_NAME", departmentName)
        intent.putExtra("SEMESTER_NAME", semesterName)
        startActivity(intent)
    }
}
