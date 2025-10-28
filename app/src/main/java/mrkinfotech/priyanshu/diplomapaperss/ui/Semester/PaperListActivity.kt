package mrkinfotech.priyanshu.diplomapaperss.ui.Semester

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import mrkinfotech.priyanshu.diplomapaperss.databinding.ActivityPaperListBinding
import mrkinfotech.priyanshu.diplomapaperss.ui.Adapter.PaperAdapter
import mrkinfotech.priyanshu.diplomapaperss.ui.ModelClass.Paper

class PaperListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPaperListBinding
    private lateinit var paperAdapter: PaperAdapter
    private lateinit var paperList: ArrayList<Paper>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaperListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val subjectName = intent.getStringExtra("SUBJECT_NAME")
        val paperType = intent.getStringExtra("PAPER_TYPE")

        binding.tvTitle.text = "$subjectName - $paperType Papers"

        paperList = getPapers(subjectName, paperType)

        paperAdapter = PaperAdapter(paperList) { paper ->
            val intent = Intent(this, PDFViewerActivity::class.java)
            intent.putExtra("PDF_PATH", paper.filePath)
            intent.putExtra("TITLE", paper.name)
            startActivity(intent)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = paperAdapter
    }

    private fun getPapers(subjectName: String?, paperType: String?): ArrayList<Paper> {
        val list = ArrayList<Paper>()

        when (subjectName) {

            "Mathematics I" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/ComputerEngnier/Semester 1/Basic Mathematices Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/ComputerEngnier/Semester 1/Basic Mathematices Winter 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2025",
                            "paper/ComputerEngnier/Semester 1/Basic Mathematices Winter 2025.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/ComputerEngnier/Semester 1/Basic Mathematices Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/ComputerEngnier/Semester 1/Basic Mathematices Summer 2025.pdf"
                        )
                    )
                }
            }

            "Computer Programming Fundamentals" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/ComputerEngnier/Semester 1/basic Com Programing Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/ComputerEngnier/Semester 1/basic Com Programing Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/ComputerEngnier/Semester 1/basic Com Programing Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/ComputerEngnier/Semester 1/basic Com Programing Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/ComputerEngnier/Semester 1/basic Com Programing Summer 2025.pdf"
                        )
                    )
                }
            }


            "Communication Skills in English" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/ComputerEngnier/Semester 1/English Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/ComputerEngnier/Semester 1/English Winter 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2025",
                            "paper/ComputerEngnier/Semester 1/English Winter 2025.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/ComputerEngnier/Semester 1/English Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/ComputerEngnier/Semester 1/English Summer 2025.pdf"
                        )
                    )
                }
            }

            "Environmental Sustainability" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/ComputerEngnier/Semester 1/E & S Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/ComputerEngnier/Semester 1/E & S Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/ComputerEngnier/Semester 1/E & S Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/ComputerEngnier/Semester 1/E & S Summer 2025.pdf"
                        )
                    )
                }
            }

            "Applied Mathematics" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/ComputerEngnier/Semester 2/Applyied Mathematices Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/ComputerEngnier/Semester 2/Applyied Mathematices Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/ComputerEngnier/Semester 2/Applyied Mathematices Winter 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2025",
                            "paper/ComputerEngnier/Semester 2/Applyied Mathematices Winter 2025.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/ComputerEngnier/Semester 2/Applyied Mathematices Summer 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/ComputerEngnier/Semester 2/Applyied Mathematices Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/ComputerEngnier/Semester 2/Applyied Mathematices Summer 2025.pdf"
                        )
                    )
                }
            }

            "C Language" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/ComputerEngnier/Semester 2/C winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/ComputerEngnier/Semester 2/C winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/ComputerEngnier/Semester 2/C winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/ComputerEngnier/Semester 2/C Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/ComputerEngnier/Semester 2/C Summer 2025.pdf"
                        )
                    )
                }
            }

            "Digital Electonices" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/ComputerEngnier/Semester 2/Digital Electonics Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/ComputerEngnier/Semester 2/Digital Electonics Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/ComputerEngnier/Semester 2/Digital Electonics Summer 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/ComputerEngnier/Semester 2/Digital Electonics Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/ComputerEngnier/Semester 2/Digital Electonics Summer 2025.pdf"
                        )
                    )
                }
            }

            "Physics" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/ComputerEngnier/Semester 2/Physisc Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/ComputerEngnier/Semester 2/Physisc Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/ComputerEngnier/Semester 2/Physisc Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/ComputerEngnier/Semester 2/Physisc Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/ComputerEngnier/Semester 2/Physisc Summer 2025.pdf"
                        )
                    )
                }
            }

            "Data Structure" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/ComputerEngnier/Semester 3/Data Stchrure Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/ComputerEngnier/Semester 3/Data Stchrure Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/ComputerEngnier/Semester 3/Data Stchrure Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/ComputerEngnier/Semester 3/Data Stchrure Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/ComputerEngnier/Semester 3/Data Stchrure Summer 2025.pdf"
                        )
                    )
                }
            }

            "DBMS" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/ComputerEngnier/Semester 3/DBMS Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/ComputerEngnier/Semester 3/DBMS Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/ComputerEngnier/Semester 3/DBMS Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/ComputerEngnier/Semester 3/DBMS Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/ComputerEngnier/Semester 3/DBMS Summer 2025.pdf"
                        )
                    )
                }
            }

            "Microprocessor" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/ComputerEngnier/Semester 3/Microprocessor Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/ComputerEngnier/Semester 3/Microprocessor Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/ComputerEngnier/Semester 3/Microprocessor Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/ComputerEngnier/Semester 3/Microprocessor Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/ComputerEngnier/Semester 3/Microprocessor Summer 2025.pdf"
                        )
                    )
                }
            }

            "Operating System" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/ComputerEngnier/Semester 3/OS Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/ComputerEngnier/Semester 3/OS Winter 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2025",
                            "paper/ComputerEngnier/Semester 3/OS Winter 2025.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/ComputerEngnier/Semester 3/OS Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/ComputerEngnier/Semester 3/OS Summer 2025.pdf"
                        )
                    )
                }
            }

            "Advanced Database Management System" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/ComputerEngnier/Semester 4/ADBMS Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/ComputerEngnier/Semester 4/ADBMS Winter' 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/ComputerEngnier/Semester 4/ADBMS Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/ComputerEngnier/Semester 4/ADBMS Summer 2025.pdf"
                        )
                    )
                }
            }

            "Computer Networks" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/ComputerEngnier/Semester 4/Computer Networks Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/ComputerEngnier/Semester 4/Computer Networks Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/ComputerEngnier/Semester 4/Computer Networks Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/ComputerEngnier/Semester 4/Computer Networks Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/ComputerEngnier/Semester 4/Computer Networks Summer 2025.pdf"
                        )
                    )
                }
            }

            "Computer Organization And Architecture" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/ComputerEngnier/Semester 4/Computer Organization And Architecture Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/ComputerEngnier/Semester 4/Computer Organization And Architecture Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/ComputerEngnier/Semester 4/Computer Organization And Architecture Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/ComputerEngnier/Semester 4/Computer Organization And Architecture Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/ComputerEngnier/Semester 4/Computer Organization And Architecture Summer 2025.pdf"
                        )
                    )
                }
            }

            ".NET" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/ComputerEngnier/Semester 4/net winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/ComputerEngnier/Semester 4/net winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/ComputerEngnier/Semester 4/net winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/ComputerEngnier/Semester 4/net Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/ComputerEngnier/Semester 4/net Summer 2025.pdf"
                        )
                    )
                }
            }

            "Computer And Network Security" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/ComputerEngnier/Semester 5/Computer And Network Security Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/ComputerEngnier/Semester 5/Computer And Network Security Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/ComputerEngnier/Semester 5/Computer And Network Security Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/ComputerEngnier/Semester 5/Computer And Network Security Summer 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/ComputerEngnier/Semester 5/Computer And Network Security Summer 2025.pdf"
                        )
                    )
                }
            }

            "Computer Maintenance And Trouble Shooting" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/ComputerEngnier/Semester 5/Computer Maintenance And Trouble Shooting Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/ComputerEngnier/Semester 5/Computer Maintenance And Trouble Shooting Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/ComputerEngnier/Semester 5/Computer Maintenance And Trouble Shooting Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/ComputerEngnier/Semester 5/Computer Maintenance And Trouble Shooting Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/ComputerEngnier/Semester 5/Computer Maintenance And Trouble Shooting Summer 2025.pdf"
                        )
                    )
                }
            }

            "Java Programming" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/ComputerEngnier/Semester 5/Java Programming Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/ComputerEngnier/Semester 5/Java Programming Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/ComputerEngnier/Semester 5/Java Programming Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/ComputerEngnier/Semester 5/Java Programming Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/ComputerEngnier/Semester 5/Java Programming Summer 2025.pdf"
                        )
                    )
                }
            }

            "Advanced Web Technology" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/ComputerEngnier/Semester 6/Advanced Web Technology Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/ComputerEngnier/Semester 6/Advanced Web Technology Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/ComputerEngnier/Semester 6/Advanced Web Technology Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/ComputerEngnier/Semester 6/Advanced Web Technology Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/ComputerEngnier/Semester 6/Advanced Web Technology Summer 2025.pdf"
                        )
                    )
                }
            }

            "AJAVA" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/ComputerEngnier/Semester 6/AJAVA Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/ComputerEngnier/Semester 6/AJAVA Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/ComputerEngnier/Semester 6/AJAVA Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/ComputerEngnier/Semester 6/AJAVA Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/ComputerEngnier/Semester 6/AJAVA Summer 2025.pdf"
                        )
                    )
                }
            }

            "Mobile Computing And Application Development" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/ComputerEngnier/Semester 6/Mobile Computing And Application Development Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/ComputerEngnier/Semester 6/Mobile Computing And Application Development Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/ComputerEngnier/Semester 6/Mobile Computing And Application Development Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/ComputerEngnier/Semester 6/Mobile Computing And Application Development Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/ComputerEngnier/Semester 6/Mobile Computing And Application Development Summer 2025.pdf"
                        )
                    )
                }
            }

            "Networking Management And Administration" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/ComputerEngnier/Semester 6/Networking Management & Administration Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/ComputerEngnier/Semester 6/Networking Management & Administration Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/ComputerEngnier/Semester 6/Networking Management & Administration Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/ComputerEngnier/Semester 6/Networking Management & Administration Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/ComputerEngnier/Semester 6/Networking Management & Administration Summer 2025.pdf"
                        )
                    )
                }
            }

            "Python Programming" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/ComputerEngnier/Semester 2/Pythone Winter2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/ComputerEngnier/Semester 2/Pythone Winter2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/ComputerEngnier/Semester 2/Pythone Winter2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/ComputerEngnier/Semester 2/Pythone Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/ComputerEngnier/Semester 2/Pythone Summer 2025.pdf"
                        )
                    )
                }
            }

            "Advanced Python Programming" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/ComputerEngnier/Semester 2/APythone Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/ComputerEngnier/Semester 2/APythone Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/ComputerEngnier/Semester 2/APythone Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/ComputerEngnier/Semester 2/APythone Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/ComputerEngnier/Semester 2/APythone Summer 2025.pdf"
                        )
                    )
                }
            }

            "IT System" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/ComputerEngnier/Semester 2/IT System Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/ComputerEngnier/Semester 2/IT System Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/ComputerEngnier/Semester 2/IT System Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/ComputerEngnier/Semester 2/IT System Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/ComputerEngnier/Semester 2/IT System Summer 2025.pdf"
                        )
                    )
                }
            }





        }
        return list
    }
}
