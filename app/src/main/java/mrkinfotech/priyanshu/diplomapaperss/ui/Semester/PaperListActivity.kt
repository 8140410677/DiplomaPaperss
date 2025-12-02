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
                            "Winter 2022",
                            "paper/computer_engnier/semester1/Basic Mathematices Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester1/Basic Mathematices Winter 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester1/Basic Mathematices Winter 2025.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester1/Basic Mathematices Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester1/Basic Mathematices Summer 2025.pdf"
                        )
                    )
                }
            }


            "Engineering Chemistry" -> {
                if (paperType == "Winter") {

                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester1/4300006.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester1/Chemistry Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester1/Chemistry Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester1/Chemistry Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester1/Chemistry Summer 2025.pdf"
                        )
                    )
                }
            }

            "Computer Programming Fundamentals" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester1/basic Com Programing Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester1/basic Com Programing Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester1/basic Com Programing Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester1/basic Com Programing Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester1/basic Com Programing Summer 2025.pdf"
                        )
                    )
                }
            }


            "Communication Skills in English" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester1/English Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester1/English Winter 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester1/English Winter 2025.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester1/English Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester1/English Summer 2025.pdf"
                        )
                    )
                }
            }

            "Environmental Sustainability" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester1/E & S Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester1/E & S Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester1/E & S Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester1/E & S Summer 2025.pdf"
                        )
                    )
                }
            }

            "Applied Mathematics" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester2/Applyied Mathematices Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester2/Applyied Mathematices Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester2/Applyied Mathematices Winter 2025.pdf"
                        )
                    )

                } else {
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/computer_engnier/semester2/Applyied Mathematices Summer 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester2/Applyied Mathematices Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester2/Applyied Mathematices Summer 2025.pdf"
                        )
                    )
                }
            }

            "C Language" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester2/C winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester2/C winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester2/C winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester2/C Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester2/C Summer 2025.pdf"
                        )
                    )
                }
            }

            "Digital Electonices" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester2/Digital Electonics Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester2/Digital Electonics Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/computer_engnier/semester2/Digital Electonics Summer 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester2/Digital Electonics Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester2/Digital Electonics Summer 2025.pdf"
                        )
                    )
                }
            }

            "Mechanical Drafting" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester2/Mechanical Drafting Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester2/Mechanical Drafting Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester2/Mechanical Drafting Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester2/Mechanical Drafting Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester2/Mechanical Drafting Summer 2025.pdf"
                        )
                    )
                }
            }

            "Physics" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester2/Physisc Winter  2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester2/Physisc Winter  2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester2/Physisc Winter  2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester2/Physisc Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester2/Physisc Summer 2025.pdf"
                        )
                    )
                }
            }

            "Data Structure" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester3/4331601.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester3/4331601 (1).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester3/4331601 (2).pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester3/4331601 (3).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester3/4331601 (4).pdf"
                        )
                    )
                }
            }

            "Digital Electronics And Digital Instruments" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester3/Digital Electronics And Digital Instruments Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester3/Digital Electronics And Digital Instruments Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester3/Digital Electronics And Digital Instruments Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester3/Digital Electronics And Digital Instruments Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester3/Digital Electronics And Digital Instruments Summer 2025.pdf"
                        )
                    )
                }
            }

            "Polyphase Transformers And Rotating Ac Machines" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester3/Polyphase Transformers And Rotating Ac Machines Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester3/Polyphase Transformers And Rotating Ac Machines Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester3/Polyphase Transformers And Rotating Ac Machines Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester3/Polyphase Transformers And Rotating Ac Machines Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester3/Polyphase Transformers And Rotating Ac Machines Summer 2025.pdf"
                        )
                    )
                }
            }

            "Transmission And Distribution Of Electrical Power" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester3/Transmission And Distribution Of Electrical Power Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester3/Transmission And Distribution Of Electrical Power Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester3/Transmission And Distribution Of Electrical Power Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester3/Transmission And Distribution Of Electrical Power Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester3/Transmission And Distribution Of Electrical Power Summer 2025.pdf"
                        )
                    )
                }
            }

            "Utilization Of Electrical Energy" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester3/Utilization Of Electrical Energy Winter 2023.pdf"
                        )
                    )

                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester3/Utilization Of Electrical Energy Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester3/Utilization Of Electrical Energy Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester3/Utilization Of Electrical Energy Summer 2025.pdf"
                        )
                    )
                }
            }

            "DC Machines And Transformer" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester3/D C Machines And Transformer Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester3/D C Machines And Transformer Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester3/D C Machines And Transformer Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester3/D C Machines And Transformer Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester3/D C Machines And Transformer Summer 2025.pdf"
                        )
                    )
                }
            }

            "Electrical Power Generation" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester3/Electrical Power Generation Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester3/Electrical Power Generation Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester3/Electrical Power Generation Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester3/Electrical Power Generation Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester3/Electrical Power Generation Summer 2025.pdf"
                        )
                    )
                }
            }

            "Electronics Components And Circuits" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester3/Electronics Components And Circuits Winter 2023.pdf"
                        )
                    )

                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester3/Electronics Components And Circuits Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester3/Electronics Components And Circuits Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester3/Electronics Components And Circuits Summer 2025.pdf"
                        )
                    )
                }
            }

            "DBMS" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester3/4331603 (1).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester3/4331603.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester3/4331603 (2).pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester3/4331603 (3).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester3/4331603 (4).pdf"
                        )
                    )
                }
            }

            "Engineering Drawing" -> {
                if (paperType == "Winter") {

                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester6/4300007 (3).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester6/4300007 (1).pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester6/4300007 (2).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester6/4300007.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester6/4300007 (4).pdf"
                        )
                    )
                }
            }

            "Microprocessor" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester3/Microprocessor Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester3/Microprocessor Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester3/Microprocessor Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester3/Microprocessor Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester3/Microprocessor Summer 2025.pdf"
                        )
                    )
                }
            }

            "Operating System" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester3/4331602.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester3/4331602 (1).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester3/4331602 (2).pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester3/4331602 (3).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester3/4331602 (4).pdf"
                        )
                    )
                }
            }

            "A.C. Circuits" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester3/4320901 (3).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester3/4320901 (1).pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester3/4320901 (2).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester3/4320901.pdf"
                        )
                    )
                }
            }

            "Basic Engineering Drawing And Graphics" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester3/4300013 (4).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester3/4300013 (1).pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester3/4300013 (3).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/computer_engnier/semester3/4300013 (5).pdf"
                        )
                    )
                }
            }

            "Advanced Database Management System" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester4/ADBMS Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester4/ADBMS Winter' 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester4/ADBMS Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester4/ADBMS Summer 2025.pdf"
                        )
                    )
                }
            }

            "Computer Networks" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester4/Computer Networks Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester4/Computer Networks Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester4/Computer Networks Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester4/Computer Networks Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester4/Computer Networks Summer 2025.pdf"
                        )
                    )
                }
            }

            "Computer Organization And Architecture" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester4/Computer Organization And Architecture Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester4/Computer Organization And Architecture Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester4/Computer Organization And Architecture Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester4/Computer Organization And Architecture Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester4/Computer Organization And Architecture Summer 2025.pdf"
                        )
                    )
                }
            }

            ".NET" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester4/net winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester4/net winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester4/net winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester4/net Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester4/net Summer 2025.pdf"
                        )
                    )
                }
            }

            "Computer And Network Security" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester5/Computer And Network Security Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester5/Computer And Network Security Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester5/Computer And Network Security Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/computer_engnier/semester5/Computer And Network Security Summer 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester5/Computer And Network Security Summer 2025.pdf"
                        )
                    )
                }
            }

            "Computer Maintenance And Trouble Shooting" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester5/Computer Maintenance And Trouble Shooting Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester5/Computer Maintenance And Trouble Shooting Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester5/Computer Maintenance And Trouble Shooting Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester5/Computer Maintenance And Trouble Shooting Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester5/Computer Maintenance And Trouble Shooting Summer 2025.pdf"
                        )
                    )
                }
            }

            "Java Programming" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester5/Java Programming Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester5/Java Programming Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester5/Java Programming Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester5/Java Programming Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester5/Java Programming Summer 2025.pdf"
                        )
                    )
                }
            }

            "Advanced Web Technology" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester6/Advanced Web Technology Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester6/Advanced Web Technology Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester6/Advanced Web Technology Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester6/Advanced Web Technology Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester6/Advanced Web Technology Summer 2025.pdf"
                        )
                    )
                }
            }

            "AJAVA" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester6/4351603 (3).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester6/4351603.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester6/4351603 (2).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025d",
                            "paper/computer_engnier/semester6/4351603 (4).pdf"
                        )
                    )
                }
            }

            "Digital Marketing" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester5/Winter 2023 Dm.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester5/Winter 2024 Dm.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/computer_engnier/semester5/Summer 2023 Dm.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester5/Summer 2024 Dm.pdf"
                        )
                    )
                }
            }

            "Machine Learning" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester5/Winter 2023 Ml.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester5/Winter 2024 Ml.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester5/Summer 2024 Ml.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester5/Summer 2023 Ml.pdf"
                        )
                    )
                }
            }

            "Entrepreneurship and Start-Ups" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester5/E AND S.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester5/E AND S (2).pdf"
                        )
                    )
                }
            }

            "Mobile Computing and Networks" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester5/MCN.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester5/MCN2.pdf"
                        )
                    )
                }
            }

            "AI and Machine Learning" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester5/ML P-1.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester5/ML P-2.pdf"
                        )
                    )
                }
            }

            "Mobile Computing And Application Development" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester6/Mobile Computing And Application Development Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester6/Mobile Computing And Application Development Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester6/Mobile Computing And Application Development Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester6/Mobile Computing And Application Development Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester6/Mobile Computing And Application Development Summer 2025.pdf"
                        )
                    )
                }
            }

            "Networking Management And Administration" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester6/Networking Management & Administration Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester6/Networking Management & Administration Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester6/Networking Management & Administration Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester6/Networking Management & Administration Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester6/Networking Management & Administration Summer 2025.pdf"
                        )
                    )
                }
            }

            "Python Programming" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester2/Pythone Winter2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester2/Pythone Winter2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester2/Pythone Winter2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester2/Pythone Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester2/Pythone Summer 2025.pdf"
                        )
                    )
                }
            }

            "Advanced Python Programming" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester2/APythone Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester2/APythone Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester2/APythone Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester2/APythone Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester2/APythone Summer 2025.pdf"
                        )
                    )
                }
            }

            "IT System" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2022",
                            "paper/computer_engnier/semester2/IT System Winter 2022.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester2/IT System Winter 2023.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester2/IT System Winter 2024.pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester2/IT System Summer 2024.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester2/IT System Summer 2025.pdf"
                        )
                    )
                }
            }

            "Thermodynamics" -> {
                if (paperType == "Winter") {

                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester6/3331902 (3).pdf"
                        )
                    )

                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester6/3331902 (1).pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester6/3331902 (2).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester6/3331902.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/computer_engnier/semester6/3331902 (4).pdf"
                        )
                    )
                }
            }

            "manufacturing engineering" -> {
                if (paperType == "Winter") {

                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester6/3341901 (3).pdf"
                        )
                    )

                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester6/3341901 (1).pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester6/3341901 (2).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester6/3341901.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/computer_engnier/semester6/3341901 (4).pdf"
                        )
                    )
                }
            }

            "Metrology and Quality Control" -> {
                if (paperType == "Winter") {

                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester6/3341905 (3).pdf"
                        )
                    )

                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester6/3341905 (1).pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester6/3341905 (2).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester6/3341905.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/computer_engnier/semester6/3341905 (4).pdf"
                        )
                    )
                }
            }

            "plant maintenance and safety" -> {
                if (paperType == "Winter") {

                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester6/3341906 (3).pdf"
                        )
                    )

                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester6/3341906 (1).pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester6/3341906 (2).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester6/3341906.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/computer_engnier/semester6/3341906 (4).pdf"
                        )
                    )
                }
            }

            "thermal engineering" -> {
                if (paperType == "Winter") {

                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester6/3341906 (3).pdf"
                        )
                    )

                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester6/3341906 (1).pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester6/3341906 (2).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester6/3341906.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/computer_engnier/semester6/3341906 (4).pdf"
                        )
                    )
                }
            }

            "Theory of Machines" -> {
                if (paperType == "Winter") {

                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester6/3341902 (3).pdf"
                        )
                    )

                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester6/3341902 (1).pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester6/3341902 (2).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester6/3341902.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/computer_engnier/semester6/3341902 (4).pdf"
                        )
                    )
                }
            }

            "self employment and enterpreneurship devlopment" -> {
                if (paperType == "Winter") {

                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester5/3351906 (3).pdf"
                        )
                    )

                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester5/3351906 (1).pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester5/3351906 (2).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester5/3351906.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/computer_engnier/semester5/3351906 (4).pdf"
                        )
                    )
                }
            }

            "thermal engineering II" -> {
                if (paperType == "Winter") {

                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester5/3351901 (3).pdf"
                        )
                    )

                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester5/3351901 (1).pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester5/3351901 (2).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester5/3351901.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/computer_engnier/semester5/3351901 (4).pdf"
                        )
                    )
                }
            }

            "design of machine elements" -> {
                if (paperType == "Winter") {

                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester5/3351902 (3).pdf"
                        )
                    )

                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester5/3351902 (1).pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester5/3351902 (2).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester5/3351902.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/computer_engnier/semester5/3351902 (4).pdf"
                        )
                    )
                }
            }

            "estimating costing and endineering contracting" -> {
                if (paperType == "Winter") {

                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester5/3351905 (3).pdf"
                        )
                    )

                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester5/3351905 (1).pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester5/3351905 (2).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester5/3351905.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/computer_engnier/semester5/3351905 (4).pdf"
                        )
                    )
                }
            }

            "MANUFACTURING ENGINEERING-III" -> {
                if (paperType == "Winter") {

                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester5/3351903 (3).pdf"
                        )
                    )

                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester5/3351903 (1).pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester5/3351903 (2).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester5/3351903.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/computer_engnier/semester5/3351903 (4).pdf"
                        )
                    )
                }
            }

            "Computer Aided Manufacturing" -> {
                if (paperType == "Winter") {

                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester5/3361901 (3).pdf"
                        )
                    )

                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester5/3361901 (1).pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester5/3361901 (2).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester5/3361901.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/computer_engnier/semester5/3361901 (4).pdf"
                        )
                    )
                }
            }

            "Fabrication Technology" -> {
                if (paperType == "Winter") {

                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester5/3361905 (3).pdf"
                        )
                    )

                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester5/3361905 (1).pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester5/3361905 (2).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester5/3361905.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/computer_engnier/semester5/3361905 (4).pdf"
                        )
                    )
                }
            }

            "Industrial Managemen" -> {
                if (paperType == "Winter") {

                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester5/3361903 (3).pdf"
                        )
                    )

                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester5/3361903 (1).pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester5/3361903 (2).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester5/3361903.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/computer_engnier/semester5/3361903 (4).pdf"
                        )
                    )
                }
            }

            "Manufacturing Systems" -> {
                if (paperType == "Winter") {

                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester5/3361904 (3).pdf"
                        )
                    )

                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester5/3361904 (1).pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester5/3361904 (2).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester5/3361904.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/computer_engnier/semester5/3361904 (4).pdf"
                        )
                    )
                }
            }

            "Strength of Materials" -> {
                if (paperType == "Winter") {

                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester6/3331904 (3).pdf"
                        )
                    )

                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester6/3331904 (1).pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester6/3331904 (2).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester6/3331904.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/computer_engnier/semester6/3331904 (4).pdf"
                        )
                    )
                }
            }

            "Manufacturing Technology" -> {
                if (paperType == "Winter") {

                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester6/3331901 (3).pdf"
                        )
                    )

                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester6/3331901 (1).pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester6/3331901 (2).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester6/3331901.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/computer_engnier/semester6/3331901 (4).pdf"
                        )
                    )
                }
            }

            "Human Resources" -> {
                if (paperType == "Winter") {

                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester6/3330001 (3).pdf"
                        )
                    )

                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester6/3330001 (1).pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester6/3330001 (2).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester6/3330001.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/computer_engnier/semester6/3330001 (4).pdf"
                        )
                    )
                }
            }

            "Fluid Mechanics and Machinery" -> {
                if (paperType == "Winter") {

                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester6/3331903 (3).pdf"
                        )
                    )

                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester6/3331903 (1).pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester6/3331903 (2).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester6/3331903.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/computer_engnier/semester6/3331903 (4).pdf"
                        )
                    )
                }
            }

            "D.C. Circuits" -> {
                if (paperType == "Winter") {

                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester6/4310901 (3).pdf"
                        )
                    )

                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester6/4310901 (1).pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester6/4310901 (2).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester6/4310901.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/computer_engnier/semester6/4310901 (4).pdf"
                        )
                    )
                }
            }

            "Electrical Instrumentation" -> {
                if (paperType == "Winter") {

                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester3/3330903 (3).pdf"
                        )
                    )

                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester3/3330903 (1).pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester3/3330903 (2).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester3/3330903.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/computer_engnier/semester3/3330903 (4).pdf"
                        )
                    )
                }
            }

            "Plant Utilities" -> {
                if (paperType == "Winter") {

                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester3/3330903 (3).pdf"
                        )
                    )

                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester3/3330903 (1).pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester3/3330903 (2).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester3/3330903.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/computer_engnier/semester3/3330903 (4).pdf"
                        )
                    )
                }
            }

            "Hydraulics" -> {
                if (paperType == "Winter") {

                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester3/3330603 (3).pdf"
                        )
                    )

                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester3/3330603 (1).pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester3/3330603 (2).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester3/3330603.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/computer_engnier/semester3/3330603 (4).pdf"
                        )
                    )
                }
            }

            "Construction Technology" -> {
                if (paperType == "Winter") {

                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester3/3330602 (3).pdf"
                        )
                    )

                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester3/3330602 (1).pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester3/3330602 (2).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester3/3330602.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/computer_engnier/semester3/3330602 (4).pdf"
                        )
                    )
                }
            }

            "Building Materials" -> {
                if (paperType == "Winter") {
                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester3/3330601 (1).pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester3/3330601 (2).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester3/3330601.pdf"
                        )
                    )
                }
            }

            "Power Plant Engineering" -> {
                if (paperType == "Winter") {

                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester5/3361906 (3).pdf"
                        )
                    )

                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester5/3361906 (1).pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester5/3361906 (2).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester5/3361906.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/computer_engnier/semester5/3361906    (4).pdf"
                        )
                    )
                }
            }

            "Thermal Systems And Energy Efficiency" -> {
                if (paperType == "Winter") {

                    list.add(
                        Paper(
                            "Winter 2023",
                            "paper/computer_engnier/semester5/3361907 (3).pdf"
                        )
                    )

                    list.add(
                        Paper(
                            "Winter 2024",
                            "paper/computer_engnier/semester5/3361907 (1).pdf"
                        )
                    )
                } else {
                    list.add(
                        Paper(
                            "Summer 2024",
                            "paper/computer_engnier/semester5/3361907 (2).pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2025",
                            "paper/computer_engnier/semester5/3361907.pdf"
                        )
                    )
                    list.add(
                        Paper(
                            "Summer 2023",
                            "paper/computer_engnier/semester5/3361907 (4).pdf"
                        )
                    )
                }
            }


        }
        return list
    }
}
