package mrkinfotech.priyanshu.diplomapaperss.ui.SemsterShow

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import mrkinfotech.priyanshu.diplomapaperss.databinding.ActivitySemesterAstivityBinding

class SemesterAstivity : AppCompatActivity() {

    private lateinit var binding: ActivitySemesterAstivityBinding
    private var departmentName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySemesterAstivityBinding.inflate(layoutInflater)
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
        val intent = Intent(this, SubjectShow::class.java)
        intent.putExtra("DEPARTMENT_NAME", departmentName)
        intent.putExtra("SEMESTER_NAME", semesterName)
        startActivity(intent)
    }
}
