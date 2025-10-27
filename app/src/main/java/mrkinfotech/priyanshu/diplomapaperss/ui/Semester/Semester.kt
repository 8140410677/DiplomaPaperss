package mrkinfotech.priyanshu.diplomapaperss.ui.Semester

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import mrkinfotech.priyanshu.diplomapaperss.databinding.ActivitySemesterBinding
import kotlin.jvm.java

class Semester : AppCompatActivity() {

    private lateinit var binding: ActivitySemesterBinding
    private var departmentName: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivitySemesterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        departmentName = intent.getStringExtra("DEPARTMENT_NAME")
        binding.firstsemester.setOnClickListener {
            openPaper("Semester 1")
        }

        binding.secondSemester.setOnClickListener {
            openPaper("Semester 2")
        }

        binding.thirdSemester.setOnClickListener {
            openPaper("Semester 3")
        }

        binding.fourthsemester.setOnClickListener {
            openPaper("Semester 4")
        }

        binding.fifthSemester.setOnClickListener {
            openPaper("Semester 5")
        }

        binding.sixSemester.setOnClickListener {
            openPaper("Semester 6")
        }
    }


    private fun openPaper(semesterName: String) {
        val intent = Intent(this, SubjectActivity::class.java)
        intent.putExtra("DEPARTMENT_NAME", departmentName)
        intent.putExtra("SEMESTER_NAME", semesterName)
        startActivity(intent)
    }
}