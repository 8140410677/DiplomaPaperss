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
            "Mathematics 1" -> {
                if (paperType == "Winter") {
                    list.add(Paper("Winter 2022", "papers/sem1/maths1_winter2022.pdf"))
                    list.add(Paper("Winter 2021", "papers/sem1/maths1_winter2021.pdf"))
                } else {
                    list.add(Paper("Summer 2022", "papers/sem1/maths1_summer2022.pdf"))
                }
            }

            "Computer Networks" -> {
                if (paperType == "Winter") {
                    list.add(Paper("Winter 2023", "papers/sem2/cn_winter2023.pdf"))
                    list.add(Paper("Winter 2022", "papers/sem2/cn_winter2022.pdf"))
                }
            }
        }

        return list
    }
}
