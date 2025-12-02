package mrkinfotech.priyanshu.diplomapaperss.ui.SemsterShow

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import mrkinfotech.priyanshu.diplomapaperss.databinding.ActivitySubjectShowBinding
import mrkinfotech.priyanshu.diplomapaperss.ui.Adapter.SubjectShowAdapter
import mrkinfotech.priyanshu.diplomapaperss.ui.ModelClass.Subject
import mrkinfotech.priyanshu.diplomapaperss.ui.ModelClass.SubjectModel
import mrkinfotech.priyanshu.diplomapaperss.ui.Semester.PaperSelect

class SubjectShow : AppCompatActivity() {

    private lateinit var binding: ActivitySubjectShowBinding
    private lateinit var subjectList: ArrayList<SubjectModel>
    private lateinit var adapter: SubjectShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubjectShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var departmentName = intent.getStringExtra("DEPARTMENT_NAME")
        var semesterName = intent.getStringExtra("SEMESTER_NAME")

        binding.txtTitle.text = "$departmentName - $semesterName"

        subjectList = getSubjects(departmentName, semesterName)

        adapter = SubjectShowAdapter(this, subjectList) { subject ->
            val intent = Intent(this, PaperSelect::class.java)
            intent.putExtra("SUBJECT_NAME", subject.subjectName)
            startActivity(intent)
        }
        binding.rvSubjects.adapter = adapter


        binding.rvSubjects.layoutManager = LinearLayoutManager(this)
        binding.rvSubjects.adapter = adapter
    }

    private fun getSubjects(dept: String?, sem: String?): ArrayList<SubjectModel> {
        val list = ArrayList<SubjectModel>()

        when (dept) {

            "IT Department" -> {
                when (sem) {

                    "semester1" -> list.addAll(
                        listOf(
                            SubjectModel("Mathematics I"),
                            SubjectModel("Python Programming"),
                            SubjectModel("Engineering Chemistry"),
                            SubjectModel("Communication Skills in English"),
                            SubjectModel("IT System")
                        )
                    )

                    "semester2" -> list.addAll(
                        listOf(
                            SubjectModel("Physics"),
                            SubjectModel("Applied Mathematics"),
                            SubjectModel("Environmental Sustainability"),
                            SubjectModel("Advanced Python Programming")
                        )
                    )

                    "semester3" -> list.addAll(
                        listOf(
                            SubjectModel("Java Programming"),
                            SubjectModel("Data Structure"),
                            SubjectModel("DBMS"),
                            SubjectModel("Digital Marketing"),
                            SubjectModel("Operating System")
                        )
                    )

                    "semester4" -> list.addAll(
                        listOf(
                            SubjectModel("Java Programming"),
                            SubjectModel("Digital Marketing"),
                            SubjectModel("Machine Learning"),
                            SubjectModel("Integrated Personality Development Course")
                        )
                    )

                    "semester5" -> list.addAll(
                        listOf(
                            SubjectModel("AJAVA"),
                            SubjectModel("AI and Machine Learning"),
                            SubjectModel("Mobile Computing and Networks"),
                            SubjectModel("Entrepreneurship and Start-Ups")
                        )
                    )

                    "semester6" -> list.addAll(
                        listOf(
                            SubjectModel("Blockchain"),
                            SubjectModel("Cyber Security")
                        )
                    )
                }
            }

            "Civil Department" -> when (sem) {
                // not complete 456
                "semester1" -> list.addAll(
                    listOf(
                        SubjectModel("Communication Skills in English"),
                        SubjectModel("Engineering Chemistry"),
                        SubjectModel("Physics"),
                        SubjectModel("Mathematics I"),
                        SubjectModel("Basic Engineering Drawing And Graphics")
                    )
                )

                "semester2" -> list.addAll(
                    listOf(
                        SubjectModel("Applied Mathematics"),
                        SubjectModel("Engineering Drawing"),
                        SubjectModel("Engineering Mechanics"),
                        SubjectModel("Environmental Sustainability")
                    )
                )

                "semester3" -> list.addAll(
                    listOf(
                        SubjectModel("Construction Technology"),
                        SubjectModel("Building Materials "),
                        SubjectModel("Hydraulics"),
                        SubjectModel("Architectural Drafting and Design")
                    )
                )

                "semester4" -> list.addAll(
                    listOf(
                        SubjectModel("Concrete Technology"),
                        SubjectModel("Structure Theory"),
                        SubjectModel("Irrigation Engineering"),
                        SubjectModel("Minor Project")
                    )
                )

                "semester5" -> list.addAll(
                    listOf(
                        SubjectModel("Surveying III"),
                        SubjectModel("RCC Structure Design I"),
                        SubjectModel("Soil Mechanics and Foundation"),
                        SubjectModel("Industrial Training")
                    )
                )

                "semester6" -> list.addAll(
                    listOf(
                        SubjectModel("Estimation and Costing"),
                        SubjectModel("RCC Structure Design II"),
                        SubjectModel("Transportation Engineering"),
                        SubjectModel("Environmental Engineering"),
                        SubjectModel("Major Project")
                    )
                )
            }

            "Chemical Department" -> when (sem) {
                "semester1" -> list.addAll(
                    listOf(
                        SubjectModel("Mathematics I"),
                        SubjectModel("Communication Skills in English"),
                        SubjectModel("Engineering Graphics"),
                        SubjectModel("Plant Utilities"),
                        SubjectModel("Engineering Chemistry"),
                        SubjectModel("Material Science and Technology")
                    )
                )

                "semester2" -> list.addAll(
                    listOf(
                        SubjectModel("Applied Physics"),
                        SubjectModel("Applied Mathematics II"),
                        SubjectModel("Environmental Sustainability"),
                        SubjectModel("Basic Chemical Engineering Calculations"),
                        SubjectModel("Mechanical Operations")
                    )
                )

                "semester3" -> list.addAll(
                    listOf(
                        SubjectModel("Basics of Process Instrumentation"),
                        SubjectModel("Fluid Flow Operation"),
                        SubjectModel("Process Heat Transfer"),
                        SubjectModel("Chemical Process Technology I"),
                        SubjectModel("Safety and Hazard Management"),
                        SubjectModel("Process Calculation")
                    )
                )

                "semester4" -> list.addAll(
                    listOf(
                        SubjectModel("Process Heat Transfer II"),
                        SubjectModel("Mass Transfer I"),
                        SubjectModel("Chemical Engineering Thermodynamics"),
                        SubjectModel("Safety and Pollution Control"),
                        SubjectModel("Personality Development")
                    )
                )

                "semester5" -> list.addAll(
                    listOf(
                        SubjectModel("Entrepreneurship and Startups"),
                        SubjectModel("Mass Transfer II"),
                        SubjectModel("Chemical Engineering Project I"),
                        SubjectModel("Summer Internship"),
                        SubjectModel("Polymer Technology")
                    )
                )

                "semester6" -> list.addAll(
                    listOf(
                        SubjectModel("Chemical Reaction Engineering"),
                        SubjectModel("Petroleum Refining"),
                        SubjectModel("Project Engineering"),
                        SubjectModel("Instrumentation and Process Control"),
                        SubjectModel("Process Equipment Design")
                    )
                )
            }

            "Mechanical Department" -> {
                when (sem) {

                    "semester1" -> list.addAll(
                        listOf(
                            SubjectModel("Mathematics I"),
                            SubjectModel("Communication Skills in English"),
                            SubjectModel("Engineering Drawing"),
                            SubjectModel("Physics"),
                            SubjectModel("Engineering Chemistry"),
                        )
                    )

                    "semester2" -> list.addAll(
                        listOf(
                            SubjectModel("Engineering Mechanics"),
                            SubjectModel("Engineering Graphics"),
                            SubjectModel("Physics"),
                            SubjectModel("Environmental Sustainability"),
                            SubjectModel("Applied Mathematics"),
                        )
                    )

                    "semester3" -> list.addAll(
                        listOf(
                            SubjectModel("Manufacturing Technology"),
                            SubjectModel("Human Resources"),
                            SubjectModel("Strength of Materials"),
                            SubjectModel("Fluid Mechanics and Machinery"),
                            SubjectModel("Thermodynamics")
                        )
                    )

                    "semester4" -> list.addAll(
                        listOf(
                            SubjectModel("Manufacturing Engineering"),
                            SubjectModel("Metrology and Quality Control"),
                            SubjectModel("Plant Maintenance and Safety"),
                            SubjectModel("Thermal Engineering"),
                            SubjectModel("Theory of Machines")
                        )
                    )

                    "semester5" -> list.addAll(
                        listOf(
                            SubjectModel("Self Employment and Entrepreneurship Development"),
                            SubjectModel("Thermal Engineering II"),
                            SubjectModel("Design of Machine Elements"),
                            SubjectModel("Estimating Costing and Engineering Contracting"),
                            SubjectModel("Industrial Engineering"),
                            SubjectModel("Manufacturing Engineering III")
                        )
                    )

                    "semester6" -> list.addAll(
                        listOf(
                            SubjectModel("Industrial Management"),
                            SubjectModel("Fabrication Technology"),
                            SubjectModel("Computer Aided Manufacturing"),
                            SubjectModel("Manufacturing Systems"),
                            SubjectModel("Power Plant Engineering"),
                            SubjectModel("Thermal Systems And Energy Efficiency"),
                        )
                    )
                }
            }




        }

        return list
    }
}
