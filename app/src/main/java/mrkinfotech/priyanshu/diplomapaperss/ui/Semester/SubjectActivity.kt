package mrkinfotech.priyanshu.diplomapaperss.ui.Semester

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import mrkinfotech.priyanshu.diplomapaperss.databinding.ActivitySubjectBinding
import mrkinfotech.priyanshu.diplomapaperss.ui.Adapter.SubjectAdapter
import mrkinfotech.priyanshu.diplomapaperss.ui.ModelClass.Subject

class SubjectActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubjectBinding
    private lateinit var subjectAdapter: SubjectAdapter
    private lateinit var subjectList: ArrayList<Subject>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubjectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val departmentName = intent.getStringExtra("DEPARTMENT_NAME")
        val semesterName = intent.getStringExtra("SEMESTER_NAME")

        binding.tvtitle.text = "$departmentName - $semesterName"

        subjectList = getSubjects(departmentName, semesterName)

        subjectAdapter = SubjectAdapter(subjectList) { subject ->
            val intent = Intent(this, PaperSelect::class.java)
            intent.putExtra("SUBJECT_NAME", subject.name)
            startActivity(intent)
        }

        binding.rvSubjects.layoutManager = LinearLayoutManager(this)
        binding.rvSubjects.adapter = subjectAdapter
    }

    private fun getSubjects(departmentName: String?, semesterName: String?): ArrayList<Subject> {
        val list = ArrayList<Subject>()

        when (departmentName) {

            "Computer Engineering" -> when (semesterName) {
                //compleate
                "semester1" -> list.addAll(
                    listOf(
                        Subject("Mathematics I"),
                        Subject("Communication Skills in English"),
                        Subject("Computer Programming Fundamentals"),
                        Subject("Environmental Sustainability"),

                        )
                )

                "semester2" -> list.addAll(
                    listOf(
                        Subject("Applied Mathematics"),
                        Subject("C Language"),
                        Subject("Digital Electonices"),
                        Subject("Physics"),
                    )
                )

                "semester3" -> list.addAll(
                    listOf(
                        Subject("Data Structure"),
                        Subject("DBMS"),
                        Subject("Operating System"),
                        Subject("Microprocessor"),
                    )
                )


                "semester4" -> list.addAll(
                    listOf(
                        Subject("Computer Networks"),
                        Subject("Computer Organization And Architecture"),
                        Subject("Advanced Database Management System"),
                        Subject(".NET")
                    )
                )

                "semester5" -> list.addAll(
                    listOf(
                        Subject("Mobile Application Development"),
                        Subject("Computer Maintenance And Trouble Shooting"),
                        Subject("Java Programming"),

                        )
                )

                "semester6" -> list.addAll(
                    listOf(
                        Subject("Advanced Web Technology"),
                        Subject("AJAVA"),
                        Subject("Mobile Computing And Application Development"),
                        Subject("Networking Management And Administration"),
                    )
                )
            }

            "Information Technology" -> when (semesterName) {
                //compleate IT
                "semester1" -> list.addAll(
                    listOf(
                        Subject("Mathematics I"),
                        Subject("Python Programming"),
                        Subject("Engineering Chemistry"),
                        Subject("Communication Skills in English"),
                        Subject("IT System")
                    )
                )

                "semester2" -> list.addAll(
                    listOf(
                        Subject("Physics"),
                        Subject("Applied Mathematics"),
                        Subject("Environmental Sustainability"),
                        Subject("Advanced Python Programming")
                    )
                )

                "semester3" -> list.addAll(
                    listOf(
                        Subject("Java Programming"),
                        Subject("Data Structure"),
                        Subject("DBMS"),
                        Subject("Digital Marketing"),
                        Subject("Operating System")
                    )
                )
                "semester4" -> list.addAll(
                    listOf(
                        Subject("Java Programming"),
                        Subject("Digital Marketing"),
                        Subject("Machine Learning"),
                        Subject("Integrated Personality Development Course")
                    )
                )

                "semester5" -> list.addAll(
                    listOf(
                        Subject("AJAVA"),
                        Subject("AI and Machine Learning"),
                        Subject("Mobile Computing and Networks"),
                        Subject("Entrepreneurship and Start-Ups")
                    )
                )

                "semester6" -> list.addAll(
                    listOf(
                        Subject("Blockchain"),
                        Subject("Cyber Security"),
                    )
                )
            }

            "Electrical Engineering" -> when (semesterName) {
                "semester1" -> list.addAll(
                    listOf(
                        Subject("Communication Skills in English"),
                        Subject("Engineering Chemistry"),
                        Subject("Mathematics I"),
                        Subject("D.C. Circuits"),
                    )
                )

                "semester2" -> list.addAll(
                    listOf(
                        Subject("Applied Mathematics"),
                        Subject("Physics"),
                        Subject("Environmental Sustainability"),
                        Subject("Basic Engineering Drawing And Graphics"),
                        Subject("A.C. Circuits"),

                        )
                )

                "semester3" -> list.addAll(
                    listOf(
                        Subject("DC Machines And Transformer"),
                        Subject("Electrical Power Generation"),
                        Subject("Electronics Components And Circuits"),
                        Subject("Electrical Instrumentation")
                    )
                )

                "semester4" -> list.addAll(
                    listOf(
                        Subject("Digital Electronics And Digital Instruments"),
                        Subject("Polyphase Transformers And Rotating Ac Machines"),
                        Subject("Transmission And Distribution Of Electrical Power"),
                        Subject("Utilization Of Electrical Energy")
                    )
                )
// Baaki Chhe Sem 5 And 6
                "semester5" -> list.addAll(
                    listOf(
                        Subject("Power System I"),
                        Subject("Engineering Economics"),
                        Subject("Special Electrical Machines"),
                        Subject("Microcontroller"),
                        Subject("Electrical Machine Controller")
                    )
                )

                "semester6" -> list.addAll(
                    listOf(
                        Subject("Power System II"),
                        Subject("Electrical Estimation and Auditing"),
                        Subject("Computer Hardware and Networks")
                    )
                )
            }

            "Mechanical Engineering" -> when (semesterName) {
                //compleate Mechenical
                "semester1" -> list.addAll(
                    listOf(
                        Subject("Mathematics I"),
                        Subject("Communication Skills in English"),
                        Subject("Engineering Drawing"),
                        Subject("Physics"),
                        Subject("Engineering Chemistry"),
                    )
                )

                "semester2" -> list.addAll(
                    listOf(
                        Subject("Engineering Mechanics"),
                        Subject("Engineering Graphics"),
                        Subject("Physics"),
                        Subject("Environmental Sustainability"),
                        Subject("Applied Mathematics"),
                    )
                )

                "semester3" -> list.addAll(
                    listOf(
                        Subject("Manufacturing Technology"),
                        Subject("Human Resources"),
                        Subject("Strength of Materials"),
                        Subject("Fluid Mechanics and Machinery"),
                        Subject("Thermodynamics")
                    )
                )

                "semester4" -> list.addAll(
                    listOf(
                        Subject("manufacturing engineering"),
                        Subject("Metrology and Quality Control"),
                        Subject("plant maintenance and safety"),
                        Subject("thermal engineering"),
                        Subject("Theory of Machines")
                    )
                )

                "semester5" -> list.addAll(
                    listOf(
                        Subject("self employment and enterpreneurship devlopment"),
                        Subject("thermal engineering II"),
                        Subject("design of machine elements"),
                        Subject("estimating costing and endineering contracting"),
                        Subject("industring Engineering"),
                        Subject("MANUFACTURING ENGINEERING-III")
                    )
                )

                "semester6" -> list.addAll(
                    listOf(
                        Subject("Industrial Management"),
                        Subject("Fabrication Technology"),
                        Subject("Computer Aided Manufacturing"),
                        Subject("Manufacturing Systems"),
                        Subject("Power Plant Engineering"),
                        Subject("Thermal Systems And Energy Efficiency"),
                    )
                )
            }

            "Civil Engineering" -> when (semesterName) {
                // not complete 456
                "semester1" -> list.addAll(
                    listOf(
                        Subject("Communication Skills in English"),
                        Subject("Engineering Chemistry"),
                        Subject("Physics"),
                        Subject("Mathematics I"),
                        Subject("Basic Engineering Drawing And Graphics")
                    )
                )

                "semester2" -> list.addAll(
                    listOf(
                        Subject("Applied Mathematics"),
                        Subject("Engineering Drawing"),
                        Subject("Engineering Mechanics"),
                        Subject("Environmental Sustainability")
                    )
                )

                "semester3" -> list.addAll(
                    listOf(
                        Subject("Construction Technology"),
                        Subject("Building Materials "),
                        Subject("Hydraulics"),
                        Subject("Architectural Drafting and Design")
                    )
                )

                "semester4" -> list.addAll(
                    listOf(
                        Subject("Concrete Technology"),
                        Subject("Structure Theory"),
                        Subject("Irrigation Engineering"),
                        Subject("Minor Project")
                    )
                )

                "semester5" -> list.addAll(
                    listOf(
                        Subject("Surveying III"),
                        Subject("RCC Structure Design I"),
                        Subject("Soil Mechanics and Foundation"),
                        Subject("Industrial Training")
                    )
                )

                "semester6" -> list.addAll(
                    listOf(
                        Subject("Estimation and Costing"),
                        Subject("RCC Structure Design II"),
                        Subject("Transportation Engineering"),
                        Subject("Environmental Engineering"),
                        Subject("Major Project")
                    )
                )
            }

            "Chemical Engineering" -> when (semesterName) {
                "semester1" -> list.addAll(
                    listOf(
                        Subject("Mathematics I"),
                        Subject("Communication Skills in English"),
                        Subject("Engineering Graphics"),
                        Subject("Plant Utilities"),
                        Subject("Engineering Chemistry"),
                        Subject("Material Science and Technology")
                    )
                )

                "semester2" -> list.addAll(
                    listOf(
                        Subject("Applied Physics"),
                        Subject("Applied Mathematics II"),
                        Subject("Environmental Sustainability"),
                        Subject("Basic Chemical Engineering Calculations"),
                        Subject("Mechanical Operations")
                    )
                )

                "semester3" -> list.addAll(
                    listOf(
                        Subject("Basics of Process Instrumentation"),
                        Subject("Fluid Flow Operation"),
                        Subject("Process Heat Transfer"),
                        Subject("Chemical Process Technology I"),
                        Subject("Safety and Hazard Management"),
                        Subject("Process Calculation")
                    )
                )

                "semester4" -> list.addAll(
                    listOf(
                        Subject("Process Heat Transfer II"),
                        Subject("Mass Transfer I"),
                        Subject("Chemical Engineering Thermodynamics"),
                        Subject("Safety and Pollution Control"),
                        Subject("Personality Development")
                    )
                )

                "semester5" -> list.addAll(
                    listOf(
                        Subject("Entrepreneurship and Startups"),
                        Subject("Mass Transfer II"),
                        Subject("Chemical Engineering Project I"),
                        Subject("Summer Internship"),
                        Subject("Polymer Technology")
                    )
                )

                "semester6" -> list.addAll(
                    listOf(
                        Subject("Chemical Reaction Engineering"),
                        Subject("Petroleum Refining"),
                        Subject("Project Engineering"),
                        Subject("Instrumentation and Process Control"),
                        Subject("Process Equipment Design")
                    )
                )
            }

            "Automobile Engineering" -> when (semesterName) {

                "semester1" -> list.addAll(
                    listOf(
                        Subject("Mathematics I"),
                        Subject("Physics"),
                        Subject("Engineering Chemistry"),
                        Subject("Engineering Graphics I"),
                        Subject("Communication Skills in English"),
                        Subject("Workshop Practice I")
                    )
                )

                "semester2" -> list.addAll(
                    listOf(
                        Subject("Applied Mathematics"),
                        Subject("Applied Physics II"),
                        Subject("Applied Chemistry II"),
                        Subject("Engineering Graphics II"),
                        Subject("Computer Fundamentals"),
                    )
                )

                "semester3" -> list.addAll(
                    listOf(
                        Subject("Strength of Materials"),
                        Subject("Automobile Engines"),
                        Subject("Thermodynamics"),
                        Subject("Automobile Transmission Systems"),
                        Subject("Mechanical Measurements and Metrology"),
                        Subject("Automobile Chassis")
                    )
                )

                "semester4" -> list.addAll(
                    listOf(
                        Subject("Theory of Machines"),
                        Subject("Automobile Electrical and Electronics Systems"),
                        Subject("Vehicle Maintenance and Garage Practice"),
                        Subject("Automobile Pollution and Control"),
                        Subject("Fluid Mechanics and Machinery")
                    )
                )

                "semester5" -> list.addAll(
                    listOf(
                        Subject("Automobile Power Plants"),
                        Subject("Automobile Manufacturing Technology"),
                        Subject("Two and Three Wheeler Technology"),
                        Subject("Automobile Air Conditioning"),
                        Subject("Industrial Management and Safety")
                    )
                )

                "semester6" -> list.addAll(
                    listOf(
                        Subject("Vehicle Dynamics"),
                        Subject("Modern Vehicle Technology"),
                        Subject("Alternate Fuels and Energy Systems"),
                        Subject("Project Work"),
                        Subject("Industrial Training / Internship")
                    )
                )
            }

            "Mechatronics Engineering" -> when (semesterName) {
                "semester1" -> list.addAll(
                    listOf(
                        Subject("Applied Science"),
                        Subject("Mathematics I"),
                        Subject("Manufacturing Technology"),
                        Subject("Basics of Electrical and Electronics Engineering"),
                        Subject("Science Lab"),
                        Subject("Basic Electrical and Electronics Lab"),
                    )
                )

                "semester2" -> list.addAll(
                    listOf(
                        Subject("Applied Mathematics"),
                        Subject("C Programming"),
                        Subject("Analogue Electronics"),
                        Subject("Communication Skills in English"),
                        Subject("Analogue Electronics Lab"),
                        Subject("Machine Shop Practice"),
                    )
                )

                "semester3" -> list.addAll(
                    listOf(
                        Subject("Measurement System"),
                        Subject("Digital Electronics"),
                        Subject("Basics of Mechanics and Thermal Engineering"),
                        Subject("Fluid Power Engineering"),
                        Subject("Digital Electronics Lab"),
                        Subject("Computer-aided Engg. Graphics Lab"),
                        Subject("Electro-Pneumatic Lab")
                    )
                )

                "semester4" -> list.addAll(
                    listOf(
                        Subject("Microcontroller and Applications"),
                        Subject("CNC Machine Tool Technology"),
                        Subject("Automation and Computer Integrated Manufacturing System"),
                        Subject("Industrial Electronics"),
                        Subject("Microcontroller Lab"),
                        Subject("Industrial Electronics Lab"),
                        Subject("CNC Lab")
                    )
                )

                "semester5" -> list.addAll(
                    listOf(
                        Subject("Control System"),
                        Subject("Microscale Mechanical System"),
                        Subject("Basic Management Skills & Indian Constitution"),
                        Subject("PLC and Its Applications"),
                        Subject("PLC Lab"),
                        Subject("Control System Lab"),
                        Subject("Project Work and Industrial Visit")
                    )
                )

                "semester6" -> list.addAll(
                    listOf(
                        Subject("Industrial Robotics"),
                        Subject("Design of Mechatronics System"),
                        Subject("Automotive Electronics"),
                        Subject("CASP Lab"),
                        Subject("Robotics Lab"),
                        Subject("Project Work")
                    )
                )
            }

            "Electronics and Communication Engineering" -> when (semesterName) {
                "semester1" -> list.addAll(
                    listOf(
                        Subject("Physics"),
                        Subject("Engineering Chemistry"),
                        Subject("Mathematics I"),
                        Subject("Basics of Electrical and Electronics Engineering"),
                        Subject("Science Lab"),
                        Subject("Basic Electrical and Electronics Lab"),
                    )
                )

                "semester2" -> list.addAll(
                    listOf(
                        Subject("Applied Mathematics"),
                        Subject("C Programming"),
                        Subject("Analogue Electronics"),
                        Subject("Communication Skills in English"),
                        Subject("Analogue Electronics Lab"),
                        Subject("Machine Shop Practice"),
                        Subject("C Programming Lab")
                    )
                )

                "semester3" -> list.addAll(
                    listOf(
                        Subject("Digital Electronics Fundamentals"),
                        Subject("Data Structures"),
                        Subject("Relational Database Management System"),
                        Subject("Fundamentals of Operating System"),
                        Subject("Computer Networks"),
                        Subject("Responsive Web Page Design (Lab)")
                    )
                )

                "semester4" -> list.addAll(
                    listOf(
                        Subject("Advanced Object Oriented Programming"),
                        Subject("Introduction to Software Engineering"),
                        Subject("Computer Networking"),
                        Subject("Introduction to Web Development"),
                        Subject("Modern Practical Tools")
                    )
                )

                "semester5" -> list.addAll(
                    listOf(
                        Subject("Control System"),
                        Subject("Microelectronics"),
                        Subject("Communication Systems"),
                        Subject("Antenna & Wave Propagation"),
                        Subject("Signal Processing")
                    )
                )

                "semester6" -> list.addAll(
                    listOf(
                        Subject("Industrial Electronics"),
                        Subject("Microwave Engineering"),
                        Subject("VLSI Design"),
                        Subject("Project Work")
                    )
                )
            }

            "Biomedical Engineering" -> when (semesterName) {
                "semester1" -> list.addAll(
                    listOf(
                        Subject("Mathematics I"),
                        Subject("Physics"),
                        Subject("Engineering Chemistry"),
                        Subject("Engineering Graphics"),
                        Subject("Communication Skills in English"),
                        Subject("Basic Electrical Engineering")
                    )
                )

                "semester2" -> list.addAll(
                    listOf(
                        Subject("Applied Mathematics"),
                        Subject("Biology for Engineers"),
                        Subject("Basic Electronics Engineering"),
                        Subject("Human Anatomy and Physiology"),
                        Subject("Environmental Science"),
                        Subject("Computer Programming")
                    )
                )

                "semester3" -> list.addAll(
                    listOf(
                        Subject("Biomedical Instrumentation-I"),
                        Subject("Analog and Digital Electronics"),
                        Subject("Sensors and Transducers"),
                        Subject("Medical Physics"),
                        Subject("Signals and Systems"),
                        Subject("Practicals / Labs")
                    )
                )

                "semester4" -> list.addAll(
                    listOf(
                        Subject("Biomedical Instrumentation-II"),
                        Subject("Microprocessor and Interfacing"),
                        Subject("Biomaterials"),
                        Subject("Control Systems"),
                        Subject("Hospital Management"),
                        Subject("Mini Project")
                    )
                )

                "semester5" -> list.addAll(
                    listOf(
                        Subject("Diagnostic and Therapeutic Equipment"),
                        Subject("Bio-signal Processing"),
                        Subject("Medical Imaging Techniques"),
                        Subject("Biomedical Equipment Maintenance"),
                        Subject("Industrial Training / Seminar")
                    )
                )

                "semester6" -> list.addAll(
                    listOf(
                        Subject("Advanced Biomedical Instrumentation"),
                        Subject("Embedded Systems in Biomedical"),
                        Subject("Rehabilitation Engineering"),
                        Subject("Project Work"),
                        Subject("Professional Ethics in Biomedical Engineering")
                    )
                )
            }

            "Textile Manufacturing Technology" -> when (semesterName) {
                "semester1" -> list.addAll(
                    listOf(
                        Subject("Physics"),
                        Subject("Engineering Chemistry"),
                        Subject("Mathematics I"),
                        Subject("Engineering Graphics"),
                        Subject("Communication Skills in English"),
                    )
                )

                "semester2" -> list.addAll(
                    listOf(
                        Subject("Applied Mathematics"),
                        Subject("Yarn Manufacturing Process-I"),
                        Subject("Fabric Manufacturing Process-I"),
                        Subject("Textile Fiber Science"),
                        Subject("Computer Fundamentals and Applications")
                    )
                )

                "semester3" -> list.addAll(
                    listOf(
                        Subject("Yarn Manufacturing Process-II"),
                        Subject("Fabric Manufacturing Process-II"),
                        Subject("Textile Testing-I"),
                        Subject("Textile Chemistry-I"),
                        Subject("Environmental Science")
                    )
                )

                "semester4" -> list.addAll(
                    listOf(
                        Subject("Textile Testing-II"),
                        Subject("Textile Chemistry-II"),
                        Subject("Fabric Structure and Design"),
                        Subject("Industrial Training / Minor Project"),
                        Subject("Communication and Life Skills Practice")
                    )
                )

                "semester5" -> list.addAll(
                    listOf(
                        Subject("Textile Management and Quality Control"),
                        Subject("Garment Manufacturing Technology"),
                        Subject("Textile Finishing and Processing"),
                        Subject("Textile Chemical Processing"),
                        Subject("Project Work – I")
                    )
                )

                "semester6" -> list.addAll(
                    listOf(
                        Subject("Technical Textiles"),
                        Subject("Nonwoven and Smart Fabrics"),
                        Subject("Industrial Management and Entrepreneurship"),
                        Subject("Project Work – II"),
                        Subject("Seminar / Viva-Voce")
                    )
                )
            }

            "Plastic Engineering" -> when (semesterName) {
                "semester1" -> list.addAll(
                    listOf(
                        Subject("Mathematics I"),
                        Subject("Programming in C"),
                        Subject("Engineering Chemistry"),
                        Subject("Communication Skills in English"),
                        Subject("Basics of Electronics / Basic Electrical Engineering"),
                        Subject("Engineering Workshop / Engineering Drawing"),
                        Subject("Mechanics"),
                        Subject("Thermodynamics")
                    )
                )

                "semester2" -> list.addAll(
                    listOf(
                        Subject("Mathematics-II"),
                        Subject("Data Structure Using C"),
                        Subject("Physics"),
                        Subject("Business Communication"),
                        Subject("Basics of Electronics / Basic Electrical Engineering"),
                        Subject("Engineering Workshop / Engineering Drawing"),
                        Subject("Mechanics / Thermodynamics"),
                        Subject("NSS / NCC")
                    )
                )

                "semester3" -> list.addAll(
                    listOf(
                        Subject("Fluid Mechanics & Machines"),
                        Subject("Material Sciences"),
                        Subject("Strength of Material"),
                        Subject("Polymer Chemistry"),
                        Subject("Physical Chemistry of Polymers"),
                        Subject("Engineering Economics / Organizational Behavior")
                    )
                )

                "semester4" -> list.addAll(
                    listOf(
                        Subject("Purely Applied Mathematics for Specific Branch of Engineering"),
                        Subject("Polymer Structure & Properties Relationship"),
                        Subject("Additives & Compounding"),
                        Subject("Fundamental of Chemical Engineering"),
                        Subject("Plastic Materials & Application"),
                        Subject("Engineering Economics / Organizational Behavior"),
                        Subject("Skill Project")
                    )
                )

                "semester5" -> list.addAll(
                    listOf(
                        Subject("Plastic Processing Technology"),
                        Subject("Plastic Testing Technique"),
                        Subject("Fundamentals of Plastic Mould & Die Designing"),
                        Subject("Plastic Waste Management & Recycling Technology / Plastic Packaging Technology"),
                        Subject("Advance Lab-I"),
                        Subject("Machining Science & Technology / Fuel Energy Technology / Renewable Energy System")
                    )
                )

                "semester6" -> list.addAll(
                    listOf(
                        Subject("Advanced Plastics Processing Techniques"),
                        Subject("Mould Engineering"),
                        Subject("Material Engineering / Polymerization Engineering / Polymer Reaction Engineering"),
                        Subject("Industrial Lecture"),
                        Subject("Presentation Skill & Skill for Interview"),
                        Subject("Environmental Science & Engineering"),
                        Subject("Rubber Science / Polymer Nano-Composites / Biomedical Plastics (Any Two)"),
                        Subject("Yoga")
                    )
                )
            }

            "Environmental Engineering" -> when (semesterName) {
                "semester1" -> list.addAll(
                    listOf(
                        Subject("Engineering Chemistry"),
                        Subject("Physics"),
                        Subject("Mathematics I"),
                        Subject("Engineering Graphics"),
                        Subject("Communication Skills in English"),
                        Subject("Computer Applications")
                    )
                )

                "semester2" -> list.addAll(
                    listOf(
                        Subject("Mathematics-II"),
                        Subject("Environmental Studies"),
                        Subject("Basic Electrical and Electronics Engineering"),
                        Subject("Fundamentals of Civil and Mechanical Engineering"),
                        Subject("Engineering Drawing"),
                        Subject("Workshop Practice")
                    )
                )

                "semester3" -> list.addAll(
                    listOf(
                        Subject("Environmental Microbiology"),
                        Subject("Water Supply Engineering"),
                        Subject("Environmental Chemistry and Ecology"),
                        Subject("Fluid Mechanics"),
                        Subject("Environmental Hydraulics Lab"),
                        Subject("Surveying and Leveling")
                    )
                )

                "semester4" -> list.addAll(
                    listOf(
                        Subject("Wastewater Engineering"),
                        Subject("Solid Waste Management"),
                        Subject("Air and Noise Pollution Control"),
                        Subject("Environmental Impact Assessment"),
                        Subject("Environmental Monitoring and Analysis Lab"),
                        Subject("Mini Project")
                    )
                )

                "semester5" -> list.addAll(
                    listOf(
                        Subject("Industrial Waste Management"),
                        Subject("Water and Wastewater Treatment Plant Design"),
                        Subject("Remote Sensing and GIS"),
                        Subject("Environmental Management Systems"),
                        Subject("Project Work-I"),
                        Subject("Professional Ethics and Environmental Legislation")
                    )
                )

                "semester6" -> list.addAll(
                    listOf(
                        Subject("Climate Change and Sustainable Development"),
                        Subject("Environmental Audit and Certification"),
                        Subject("Energy and Environment"),
                        Subject("Project Work-II"),
                        Subject("Industrial Training / Viva-Voce")
                    )
                )
            }

            "Mining Engineering" -> when (semesterName) {
                "semester1" -> list.addAll(
                    listOf(
                        Subject("Mathematics I"),
                        Subject("Physics"),
                        Subject("Engineering Chemistry"),
                        Subject("Engineering Graphics"),
                        Subject("Communication Skills in English"),
                    )
                )

                "semester2" -> list.addAll(
                    listOf(
                        Subject("Applied Mathematics"),
                        Subject("Computer Fundamentals"),
                        Subject("Engineering Mechanics"),
                        Subject("Basic Electrical and Electronics Engineering"),
                        Subject("Environmental Studies"),
                        Subject("Engineering Drawing")
                    )
                )

                "semester3" -> list.addAll(
                    listOf(
                        Subject("Geology and Mining Terminology"),
                        Subject("Mine Surveying-I"),
                        Subject("Mine Ventilation"),
                        Subject("Mining Machinery-I"),
                        Subject("Underground Mining Methods-I"),
                        Subject("Mining Geology Lab")
                    )
                )

                "semester4" -> list.addAll(
                    listOf(
                        Subject("Mine Surveying-II"),
                        Subject("Underground Mining Methods-II"),
                        Subject("Open Cast Mining"),
                        Subject("Rock Mechanics"),
                        Subject("Mine Environmental Engineering"),
                        Subject("Mine Machinery-II")
                    )
                )

                "semester5" -> list.addAll(
                    listOf(
                        Subject("Mine Legislation and Safety"),
                        Subject("Mining Practice"),
                        Subject("Drilling and Blasting Technology"),
                        Subject("Mineral Dressing"),
                        Subject("Mine Surveying-III"),
                        Subject("Project Work-I")
                    )
                )

                "semester6" -> list.addAll(
                    listOf(
                        Subject("Computer Applications in Mining"),
                        Subject("Surface Mining Equipment"),
                        Subject("Mine Planning and Design"),
                        Subject("Environmental Management in Mines"),
                        Subject("Project Work-II"),
                        Subject("Industrial Training")
                    )
                )
            }

            "Petroleum Engineering" -> when (semesterName) {
                "semester1" -> list.addAll(
                    listOf(
                        Subject("Mathematics I"),
                        Subject("Physics"),
                        Subject("Engineering Chemistry"),
                        Subject("Engineering Graphics"),
                        Subject("Communication Skills in English"),
                    )
                )

                "semester2" -> list.addAll(
                    listOf(
                        Subject("Applied Mathematics"),
                        Subject("Computer Fundamentals"),
                        Subject("Engineering Mechanics"),
                        Subject("Environmental Science"),
                        Subject("Basic Electrical and Electronics Engineering"),
                        Subject("Engineering Drawing")
                    )
                )

                "semester3" -> list.addAll(
                    listOf(
                        Subject("Drilling Engineering-I"),
                        Subject("Petroleum Geology"),
                        Subject("Fluid Mechanics"),
                        Subject("Reservoir Engineering-I"),
                        Subject("Well Logging and Formation Evaluation"),
                        Subject("Petroleum Engineering Lab")
                    )
                )

                "semester4" -> list.addAll(
                    listOf(
                        Subject("Drilling Engineering-II"),
                        Subject("Reservoir Engineering-II"),
                        Subject("Petroleum Production Engineering-I"),
                        Subject("Petroleum Exploration"),
                        Subject("Petroleum Refining and Petrochemicals"),
                        Subject("Mini Project / Seminar")
                    )
                )

                "semester5" -> list.addAll(
                    listOf(
                        Subject("Petroleum Production Engineering-II"),
                        Subject("Enhanced Oil Recovery Techniques"),
                        Subject("Natural Gas Engineering"),
                        Subject("Health, Safety and Environment in Petroleum Industry"),
                        Subject("Industrial Training / Project Work-I")
                    )
                )

                "semester6" -> list.addAll(
                    listOf(
                        Subject("Offshore Drilling and Production"),
                        Subject("Petroleum Economics and Management"),
                        Subject("Pipeline Transportation and Storage"),
                        Subject("Project Work-II"),
                        Subject("Seminar / Viva-Voce")
                    )
                )
            }

            "Metallurgical Engineering" -> when (semesterName) {
                "semester1" -> list.addAll(
                    listOf(
                        Subject("Physics"),
                        Subject("Engineering Chemistry"),
                        Subject("Mathematics I"),
                        Subject("Engineering Graphics"),
                        Subject("Communication Skills in English"),
                        Subject("Basic Electrical and Electronics Engineering")
                    )
                )

                "semester2" -> list.addAll(
                    listOf(
                        Subject("Applied Mathematics"),
                        Subject("Engineering Chemistry"),
                        Subject("Engineering Drawing"),
                        Subject("Computer Fundamentals")
                    )
                )

                "semester3" -> list.addAll(
                    listOf(
                        Subject("Physical Metallurgy"),
                        Subject("Ferrous Metallurgy"),
                        Subject("Metallurgical Thermodynamics"),
                        Subject("Mineral Processing"),
                        Subject("Metallography Lab"),
                        Subject("Metallurgical Analysis Lab")
                    )
                )

                "semester4" -> list.addAll(
                    listOf(
                        Subject("Mechanical Metallurgy"),
                        Subject("Foundry Technology"),
                        Subject("Heat Treatment Processes"),
                        Subject("Non-Ferrous Metallurgy"),
                        Subject("Testing of Materials"),
                        Subject("Mini Project")
                    )
                )

                "semester5" -> list.addAll(
                    listOf(
                        Subject("Extractive Metallurgy"),
                        Subject("Corrosion Engineering"),
                        Subject("Powder Metallurgy"),
                        Subject("Industrial Metallurgy"),
                        Subject("Metallurgical Instrumentation"),
                        Subject("Project Work-I")
                    )
                )

                "semester6" -> list.addAll(
                    listOf(
                        Subject("Quality Control and Inspection"),
                        Subject("Failure Analysis"),
                        Subject("Welding Metallurgy"),
                        Subject("Project Work-II"),
                        Subject("Industrial Training / Viva")
                    )
                )
            }

            "Power Electronics Engineering" -> when (semesterName) {
                "semester1" -> list.addAll(
                    listOf(
                        Subject("Physics"),
                        Subject("Engineering Chemistry"),
                        Subject("Mathematics I"),
                        Subject("Basic Electrical Engineering"),
                        Subject("Engineering Graphics"),
                    )
                )

                "semester2" -> list.addAll(
                    listOf(
                        Subject("Applied Mathematics"),
                        Subject("Electronic Devices and Circuits"),
                        Subject("Electrical Machines I"),
                        Subject("Computer Fundamentals"),
                        Subject("Communication Skills in English"),
                        Subject("Electronic Devices Lab")
                    )
                )

                "semester3" -> list.addAll(
                    listOf(
                        Subject("Digital Electronics"),
                        Subject("Electrical Machines II"),
                        Subject("Network Analysis"),
                        Subject("Electrical and Electronic Measurements"),
                        Subject("Digital Electronics Lab"),
                        Subject("Measurements Lab")
                    )
                )

                "semester4" -> list.addAll(
                    listOf(
                        Subject("Power Electronics Devices"),
                        Subject("Analog Communication"),
                        Subject("Electrical Power Generation and Transmission"),
                        Subject("Microcontroller and Applications"),
                        Subject("Analog Communication Lab"),
                        Subject("Power Electronics Lab")
                    )
                )

                "semester5" -> list.addAll(
                    listOf(
                        Subject("Industrial Electronics"),
                        Subject("Power Electronics Circuits"),
                        Subject("Control Systems"),
                        Subject("Programmable Logic Controller"),
                        Subject("Industrial Electronics Lab"),
                        Subject("PLC Lab")
                    )
                )

                "semester6" -> list.addAll(
                    listOf(
                        Subject("Advanced Power Electronics"),
                        Subject("Renewable Energy Systems"),
                        Subject("Electric Drives and Control"),
                        Subject("Project Work"),
                        Subject("Industrial Training")
                    )
                )
            }

            "Architecture Assistantship" -> when (semesterName) {
                "semester1" -> list.addAll(
                    listOf(
                        Subject("Architectural Design I"),
                        Subject("Building Materials I"),
                        Subject("Engineering Graphics I"),
                        Subject("Communication Skills in English"),

                        Subject("Basic Design and Visual Arts"),
                    )
                )

                "semester2" -> list.addAll(
                    listOf(
                        Subject("Architectural Design II"),
                        Subject("Building Materials II"),
                        Subject("Building Construction I"),
                        Subject("History of Architecture I"),
                        Subject("Computer Graphics"),
                        Subject("Surveying")
                    )
                )

                "semester3" -> list.addAll(
                    listOf(
                        Subject("Architectural Design III"),
                        Subject("Building Construction II"),
                        Subject("History of Architecture II"),
                        Subject("Climatology"),
                        Subject("Structural Mechanics"),
                        Subject("Interior Design")
                    )
                )

                "semester4" -> list.addAll(
                    listOf(
                        Subject("Architectural Design IV"),
                        Subject("Building Services"),
                        Subject("Working Drawing I"),
                        Subject("Town Planning"),
                        Subject("Estimating and Costing"),
                        Subject("Model Making Workshop")
                    )
                )

                "semester5" -> list.addAll(
                    listOf(
                        Subject("Architectural Design V"),
                        Subject("Building Construction III"),
                        Subject("Landscape Design"),
                        Subject("Professional Practice"),
                        Subject("Working Drawing II"),
                        Subject("Site Planning")
                    )
                )

                "semester6" -> list.addAll(
                    listOf(
                        Subject("Architectural Design VI"),
                        Subject("Specification Writing"),
                        Subject("Building Bye Laws and Codes"),
                        Subject("Project Thesis"),
                        Subject("Practical Training")
                    )
                )
            }

            "Printing Technology" -> when (semesterName) {
                "semester1" -> list.addAll(
                    listOf(
                        Subject("Physics"),
                        Subject("Engineering Chemistry"),
                        Subject("Mathematics I"),
                        Subject("Engineering Graphics"),
                        Subject("Basic Computer Skills"),
                        Subject("Communication Skills in English"),

                        )
                )

                "semester2" -> list.addAll(
                    listOf(
                        Subject("Applied Mathematics"),
                        Subject("Printing Processes"),
                        Subject("Paper and Ink Technology"),
                        Subject("Printing Practice Lab I")
                    )
                )

                "semester3" -> list.addAll(
                    listOf(
                        Subject("Printing Machines I"),
                        Subject("Typography and Layout Design"),
                        Subject("Offset Printing"),
                        Subject("Color Theory and Management"),
                        Subject("Printing Practice Lab II")
                    )
                )

                "semester4" -> list.addAll(
                    listOf(
                        Subject("Printing Machines II"),
                        Subject("Screen and Digital Printing"),
                        Subject("Printing Finishing and Binding"),
                        Subject("Maintenance of Printing Equipment"),
                        Subject("Printing Practice Lab III")
                    )
                )

                "semester5" -> list.addAll(
                    listOf(
                        Subject("Packaging Technology"),
                        Subject("Quality Control in Printing"),
                        Subject("Cost Estimation and Production Planning"),
                        Subject("Entrepreneurship Development"),
                        Subject("Industrial Training")
                    )
                )

                "semester6" -> list.addAll(
                    listOf(
                        Subject("Advanced Printing Techniques"),
                        Subject("Publication Design"),
                        Subject("Project Work"),
                        Subject("Printing Management and Marketing")
                    )
                )
            }

        }
        return list
    }
}
