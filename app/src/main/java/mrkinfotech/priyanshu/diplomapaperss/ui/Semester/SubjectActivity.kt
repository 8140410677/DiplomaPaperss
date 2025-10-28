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
                "Semester 1" -> list.addAll(
                    listOf(
                        Subject("Mathematics I"),
                        Subject("Communication Skills in English"),
                        Subject("Computer Programming Fundamentals"),
                        Subject("Environmental Sustainability"),

                        )
                )

                "Semester 2" -> list.addAll(
                    listOf(
                        Subject("Applied Mathematics"),
                        Subject("C Language"),
                        Subject("Digital Electonices"),
                        Subject("Physics"),
                    )
                )

                "Semester 3" -> list.addAll(
                    listOf(
                        Subject("Data Structure"),
                        Subject("DBMS"),
                        Subject("Operating System"),
                        Subject("Microprocessor"),
                    )
                )


                "Semester 4" -> list.addAll(
                    listOf(
                        Subject("Computer Networks"),
                        Subject("Computer Organization And Architecture"),
                        Subject("Advanced Database Management System"),
                        Subject(".NET")
                    )
                )

                "Semester 5" -> list.addAll(
                    listOf(
                        Subject("Mobile Application Development"),
                        Subject("Computer Maintenance And Trouble Shooting"),
                        Subject("Java Programming"),

                    )
                )

                "Semester 6" -> list.addAll(
                    listOf(
                        Subject("Advanced Web Technology"),
                        Subject("AJAVA"),
                        Subject("Mobile Computing And Application Development"),
                        Subject("Networking Management And Administration"),
                    )
                )
            }

            "Information Technology" -> when (semesterName) {
                "Semester 1" -> list.addAll(
                    listOf(
                        Subject("Mathematics I"),
                        Subject("Python Programming"),
                        Subject("Basic Chemistry"),
                        Subject("Communication Skills in English"),
                        Subject("IT System")
                    )
                )

                "Semester 2" -> list.addAll(
                    listOf(
                        Subject("Physics"),
                        Subject("Applied Mathematics"),
                        Subject("Environmental Sustainability"),
                        Subject("Advanced Python Programming")
                    )
                )

                "Semester 3" -> list.addAll(
                    listOf(
                        Subject("Data Structure"),
                        Subject("Software Development Fundamentals"),
                        Subject("DBMS"),
                        Subject("Operating System")
                    )
                )

                "Semester 4" -> list.addAll(
                    listOf(
                        Subject("Java Programming"),
                        Subject("Digital Marketing"),
                        Subject("Machine Learning Basics"),
                        Subject("Integrated Personality Development Course")
                    )
                )

                "Semester 5" -> list.addAll(
                    listOf(
                        Subject("AJAVA"),
                        Subject("AI and Machine Learning"),
                        Subject("Mobile Networking"),
                        Subject("Business and Startups")
                    )
                )

                "Semester 6" -> list.addAll(
                    listOf(
                        Subject("Blockchain"),
                        Subject("Cyber Security"),
                        Subject("Big Data Analytics")
                    )
                )
            }

            "Electrical Engineering" -> when (semesterName) {
                "Semester 1" -> list.addAll(
                    listOf(
                        Subject("Communication English I"),
                        Subject("Engineering Physics I"),
                        Subject("Engineering Chemistry I"),
                        Subject("Engineering Graphics I"),
                        Subject("Mathematics I"),
                        Subject("Workshop Practice")
                    )
                )

                "Semester 2" -> list.addAll(
                    listOf(
                        Subject("Communication English II"),
                        Subject("Applied Mathematics II"),
                        Subject("Engineering Physics II"),
                        Subject("Engineering Chemistry II"),
                        Subject("Engineering Graphics II")
                    )
                )

                "Semester 3" -> list.addAll(
                    listOf(
                        Subject("Electrical Circuit Theory"),
                        Subject("Electronic Devices and Circuits"),
                        Subject("Electrical Machines I"),
                        Subject("Computer Applications")
                    )
                )

                "Semester 4" -> list.addAll(
                    listOf(
                        Subject("Electrical Machines II"),
                        Subject("Digital Electronics"),
                        Subject("Measurements and Instruments"),
                        Subject("Transducers and Signal Conditioners")
                    )
                )

                "Semester 5" -> list.addAll(
                    listOf(
                        Subject("Power System I"),
                        Subject("Special Electrical Machines"),
                        Subject("Microcontroller"),
                        Subject("Electrical Machine Controller")
                    )
                )

                "Semester 6" -> list.addAll(
                    listOf(
                        Subject("Power System II"),
                        Subject("Electrical Estimation and Auditing"),
                        Subject("Computer Hardware and Networks")
                    )
                )
            }

            "Mechanical Engineering" -> when (semesterName) {
                "Semester 1" -> list.addAll(
                    listOf(
                        Subject("Mathematics"),
                        Subject("Communication Skills"),
                        Subject("Engineering Drawing"),
                        Subject("Workshop Practice"),
                        Subject("Applied Physics"),
                        Subject("Applied Chemistry"),
                        Subject("Basic Electrical and Electronics Engineering")
                    )
                )

                "Semester 2" -> list.addAll(
                    listOf(
                        Subject("Engineering Mathematics"),
                        Subject("Engineering Mechanics"),
                        Subject("Engineering Graphics"),
                        Subject("Basic Civil Engineering"),
                        Subject("Engineering Physics"),
                        Subject("Engineering Chemistry"),
                        Subject("Basic Computer Skills")
                    )
                )

                "Semester 3" -> list.addAll(
                    listOf(
                        Subject("Applied Mathematics"),
                        Subject("Manufacturing Technology"),
                        Subject("Strength of Materials"),
                        Subject("Fluid Mechanics and Machinery"),
                        Subject("Thermodynamics")
                    )
                )

                "Semester 4" -> list.addAll(
                    listOf(
                        Subject("Heat Transfer"),
                        Subject("Metrology and Quality Control"),
                        Subject("Industrial Management"),
                        Subject("CAD/CAM"),
                        Subject("Theory of Machines")
                    )
                )

                "Semester 5" -> list.addAll(
                    listOf(
                        Subject("Mechatronics"),
                        Subject("Automobile Engineering"),
                        Subject("Power Plant Engineering"),
                        Subject("Refrigeration and Air Conditioning"),
                        Subject("Non-Conventional Energy Sources")
                    )
                )

                "Semester 6" -> list.addAll(
                    listOf(
                        Subject("Design of Machine Elements"),
                        Subject("Industrial Robotics"),
                        Subject("Entrepreneurship Development"),
                        Subject("Project Work")
                    )
                )
            }

            "Civil Engineering" -> when (semesterName) {
                "Semester 1" -> list.addAll(
                    listOf(
                        Subject("Communication Skills I"),
                        Subject("Applied Chemistry"),
                        Subject("Applied Mechanics"),
                        Subject("Applied Physics"),
                        Subject("Applied Mathematics I"),
                        Subject("Computer Application for Engineering"),
                        Subject("Workshop Practice")
                    )
                )

                "Semester 2" -> list.addAll(
                    listOf(
                        Subject("Applied Mathematics II"),
                        Subject("Engineering Drawing"),
                        Subject("Fundamentals of Electrical Engineering"),
                        Subject("Communication Skills II"),
                        Subject("Surveying I"),
                        Subject("Mechanical Engineering Fundamentals")
                    )
                )

                "Semester 3" -> list.addAll(
                    listOf(
                        Subject("Surveying II"),
                        Subject("Building Construction"),
                        Subject("Hydraulics"),
                        Subject("Architectural Drafting and Design")
                    )
                )

                "Semester 4" -> list.addAll(
                    listOf(
                        Subject("Concrete Technology"),
                        Subject("Structure Theory"),
                        Subject("Irrigation Engineering"),
                        Subject("Minor Project")
                    )
                )

                "Semester 5" -> list.addAll(
                    listOf(
                        Subject("Surveying III"),
                        Subject("RCC Structure Design I"),
                        Subject("Soil Mechanics and Foundation"),
                        Subject("Industrial Training")
                    )
                )

                "Semester 6" -> list.addAll(
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
                "Semester 1" -> list.addAll(
                    listOf(
                        Subject("Mathematics I"),
                        Subject("Communication Skills in English"),
                        Subject("Engineering Graphics"),
                        Subject("Sports and Yoga"),
                        Subject("Plant Utilities"),
                        Subject("Material Science and Technology")
                    )
                )

                "Semester 2" -> list.addAll(
                    listOf(
                        Subject("Applied Physics"),
                        Subject("Applied Mathematics II"),
                        Subject("Environmental Sustainability"),
                        Subject("Basic Chemical Engineering Calculations"),
                        Subject("Mechanical Operations")
                    )
                )

                "Semester 3" -> list.addAll(
                    listOf(
                        Subject("Basics of Process Instrumentation"),
                        Subject("Fluid Flow Operation"),
                        Subject("Process Heat Transfer"),
                        Subject("Chemical Process Technology I"),
                        Subject("Safety and Hazard Management"),
                        Subject("Process Calculation")
                    )
                )

                "Semester 4" -> list.addAll(
                    listOf(
                        Subject("Process Heat Transfer II"),
                        Subject("Mass Transfer I"),
                        Subject("Chemical Engineering Thermodynamics"),
                        Subject("Safety and Pollution Control"),
                        Subject("Personality Development")
                    )
                )

                "Semester 5" -> list.addAll(
                    listOf(
                        Subject("Entrepreneurship and Startups"),
                        Subject("Mass Transfer II"),
                        Subject("Chemical Engineering Project I"),
                        Subject("Summer Internship"),
                        Subject("Polymer Technology")
                    )
                )

                "Semester 6" -> list.addAll(
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

                "Semester 1" -> list.addAll(
                    listOf(
                        Subject("Applied Mathematics I"),
                        Subject("Applied Physics I"),
                        Subject("Applied Chemistry I"),
                        Subject("Engineering Graphics I"),
                        Subject("Communication Skills I"),
                        Subject("Workshop Practice I")
                    )
                )

                "Semester 2" -> list.addAll(
                    listOf(
                        Subject("Applied Mathematics II"),
                        Subject("Applied Physics II"),
                        Subject("Applied Chemistry II"),
                        Subject("Engineering Graphics II"),
                        Subject("Computer Fundamentals"),
                        Subject("Workshop Practice II")
                    )
                )

                "Semester 3" -> list.addAll(
                    listOf(
                        Subject("Strength of Materials"),
                        Subject("Automobile Engines"),
                        Subject("Thermodynamics"),
                        Subject("Automobile Transmission Systems"),
                        Subject("Mechanical Measurements and Metrology"),
                        Subject("Automobile Chassis")
                    )
                )

                "Semester 4" -> list.addAll(
                    listOf(
                        Subject("Theory of Machines"),
                        Subject("Automobile Electrical and Electronics Systems"),
                        Subject("Vehicle Maintenance and Garage Practice"),
                        Subject("Automobile Pollution and Control"),
                        Subject("Fluid Mechanics and Machinery")
                    )
                )

                "Semester 5" -> list.addAll(
                    listOf(
                        Subject("Automobile Power Plants"),
                        Subject("Automobile Manufacturing Technology"),
                        Subject("Two and Three Wheeler Technology"),
                        Subject("Automobile Air Conditioning"),
                        Subject("Industrial Management and Safety")
                    )
                )

                "Semester 6" -> list.addAll(
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
                "Semester 1" -> list.addAll(
                    listOf(
                        Subject("Applied Science"),
                        Subject("Applied Mathematics I"),
                        Subject("Manufacturing Technology"),
                        Subject("Basics of Electrical and Electronics Engineering"),
                        Subject("Science Lab"),
                        Subject("Basic Electrical and Electronics Lab"),
                        Subject("Basic Computer Skills Lab")
                    )
                )

                "Semester 2" -> list.addAll(
                    listOf(
                        Subject("Applied Mathematics II"),
                        Subject("C Programming"),
                        Subject("Analogue Electronics"),
                        Subject("English Communication"),
                        Subject("Analogue Electronics Lab"),
                        Subject("Machine Shop Practice"),
                        Subject("C Programming Lab")
                    )
                )

                "Semester 3" -> list.addAll(
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

                "Semester 4" -> list.addAll(
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

                "Semester 5" -> list.addAll(
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

                "Semester 6" -> list.addAll(
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
                "Semester 1" -> list.addAll(
                    listOf(
                        Subject("Applied Physics"),
                        Subject("Applied Chemistry"),
                        Subject("Applied Mathematics I"),
                        Subject("Basics of Electrical and Electronics Engineering"),
                        Subject("Science Lab"),
                        Subject("Basic Electrical and Electronics Lab"),
                        Subject("Basic Computer Skills Lab")
                    )
                )

                "Semester 2" -> list.addAll(
                    listOf(
                        Subject("Applied Mathematics II"),
                        Subject("C Programming"),
                        Subject("Analogue Electronics"),
                        Subject("English Communication"),
                        Subject("Analogue Electronics Lab"),
                        Subject("Machine Shop Practice"),
                        Subject("C Programming Lab")
                    )
                )

                "Semester 3" -> list.addAll(
                    listOf(
                        Subject("Digital Electronics Fundamentals"),
                        Subject("Data Structures"),
                        Subject("Relational Database Management System"),
                        Subject("Fundamentals of Operating System"),
                        Subject("Computer Networks"),
                        Subject("Responsive Web Page Design (Lab)")
                    )
                )

                "Semester 4" -> list.addAll(
                    listOf(
                        Subject("Advanced Object Oriented Programming"),
                        Subject("Introduction to Software Engineering"),
                        Subject("Computer Networking"),
                        Subject("Introduction to Web Development"),
                        Subject("Modern Practical Tools")
                    )
                )

                "Semester 5" -> list.addAll(
                    listOf(
                        Subject("Control System"),
                        Subject("Microelectronics"),
                        Subject("Communication Systems"),
                        Subject("Antenna & Wave Propagation"),
                        Subject("Signal Processing")
                    )
                )

                "Semester 6" -> list.addAll(
                    listOf(
                        Subject("Industrial Electronics"),
                        Subject("Microwave Engineering"),
                        Subject("VLSI Design"),
                        Subject("Project Work")
                    )
                )
            }

            "Biomedical Engineering" -> when (semesterName) {
                "Semester 1" -> list.addAll(
                    listOf(
                        Subject("Mathematics-I"),
                        Subject("Physics"),
                        Subject("Chemistry"),
                        Subject("Engineering Graphics"),
                        Subject("Communication Skills in English"),
                        Subject("Basic Electrical Engineering")
                    )
                )

                "Semester 2" -> list.addAll(
                    listOf(
                        Subject("Mathematics-II"),
                        Subject("Biology for Engineers"),
                        Subject("Basic Electronics Engineering"),
                        Subject("Human Anatomy and Physiology"),
                        Subject("Environmental Science"),
                        Subject("Computer Programming")
                    )
                )

                "Semester 3" -> list.addAll(
                    listOf(
                        Subject("Biomedical Instrumentation-I"),
                        Subject("Analog and Digital Electronics"),
                        Subject("Sensors and Transducers"),
                        Subject("Medical Physics"),
                        Subject("Signals and Systems"),
                        Subject("Practicals / Labs")
                    )
                )

                "Semester 4" -> list.addAll(
                    listOf(
                        Subject("Biomedical Instrumentation-II"),
                        Subject("Microprocessor and Interfacing"),
                        Subject("Biomaterials"),
                        Subject("Control Systems"),
                        Subject("Hospital Management"),
                        Subject("Mini Project")
                    )
                )

                "Semester 5" -> list.addAll(
                    listOf(
                        Subject("Diagnostic and Therapeutic Equipment"),
                        Subject("Bio-signal Processing"),
                        Subject("Medical Imaging Techniques"),
                        Subject("Biomedical Equipment Maintenance"),
                        Subject("Industrial Training / Seminar")
                    )
                )

                "Semester 6" -> list.addAll(
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
                "Semester 1" -> list.addAll(
                    listOf(
                        Subject("Applied Physics"),
                        Subject("Applied Chemistry"),
                        Subject("Mathematics-I"),
                        Subject("Engineering Graphics"),
                        Subject("Communication Skills in English"),
                        Subject("Workshop Practice")
                    )
                )

                "Semester 2" -> list.addAll(
                    listOf(
                        Subject("Applied Mathematics-II"),
                        Subject("Yarn Manufacturing Process-I"),
                        Subject("Fabric Manufacturing Process-I"),
                        Subject("Textile Fiber Science"),
                        Subject("Computer Fundamentals and Applications")
                    )
                )

                "Semester 3" -> list.addAll(
                    listOf(
                        Subject("Yarn Manufacturing Process-II"),
                        Subject("Fabric Manufacturing Process-II"),
                        Subject("Textile Testing-I"),
                        Subject("Textile Chemistry-I"),
                        Subject("Environmental Science")
                    )
                )

                "Semester 4" -> list.addAll(
                    listOf(
                        Subject("Textile Testing-II"),
                        Subject("Textile Chemistry-II"),
                        Subject("Fabric Structure and Design"),
                        Subject("Industrial Training / Minor Project"),
                        Subject("Communication and Life Skills Practice")
                    )
                )

                "Semester 5" -> list.addAll(
                    listOf(
                        Subject("Textile Management and Quality Control"),
                        Subject("Garment Manufacturing Technology"),
                        Subject("Textile Finishing and Processing"),
                        Subject("Textile Chemical Processing"),
                        Subject("Project Work – I")
                    )
                )

                "Semester 6" -> list.addAll(
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
                "Semester 1" -> list.addAll(
                    listOf(
                        Subject("Mathematics-I"),
                        Subject("Programming in C"),
                        Subject("Chemistry / Physics"),
                        Subject("English Communication Skill"),
                        Subject("Basics of Electronics / Basic Electrical Engineering"),
                        Subject("Engineering Workshop / Engineering Drawing"),
                        Subject("Mechanics"),
                        Subject("Thermodynamics")
                    )
                )

                "Semester 2" -> list.addAll(
                    listOf(
                        Subject("Mathematics-II"),
                        Subject("Data Structure Using C"),
                        Subject("Chemistry / Physics"),
                        Subject("Business Communication"),
                        Subject("Basics of Electronics / Basic Electrical Engineering"),
                        Subject("Engineering Workshop / Engineering Drawing"),
                        Subject("Mechanics / Thermodynamics"),
                        Subject("NSS / NCC")
                    )
                )

                "Semester 3" -> list.addAll(
                    listOf(
                        Subject("Fluid Mechanics & Machines"),
                        Subject("Material Sciences"),
                        Subject("Strength of Material"),
                        Subject("Polymer Chemistry"),
                        Subject("Physical Chemistry of Polymers"),
                        Subject("Engineering Economics / Organizational Behavior")
                    )
                )

                "Semester 4" -> list.addAll(
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

                "Semester 5" -> list.addAll(
                    listOf(
                        Subject("Plastic Processing Technology"),
                        Subject("Plastic Testing Technique"),
                        Subject("Fundamentals of Plastic Mould & Die Designing"),
                        Subject("Plastic Waste Management & Recycling Technology / Plastic Packaging Technology"),
                        Subject("Advance Lab-I"),
                        Subject("Machining Science & Technology / Fuel Energy Technology / Renewable Energy System")
                    )
                )

                "Semester 6" -> list.addAll(
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
                "Semester 1" -> list.addAll(
                    listOf(
                        Subject("Applied Chemistry"),
                        Subject("Applied Physics"),
                        Subject("Mathematics-I"),
                        Subject("Engineering Graphics"),
                        Subject("Communication Skills in English"),
                        Subject("Computer Applications")
                    )
                )

                "Semester 2" -> list.addAll(
                    listOf(
                        Subject("Mathematics-II"),
                        Subject("Environmental Studies"),
                        Subject("Basic Electrical and Electronics Engineering"),
                        Subject("Fundamentals of Civil and Mechanical Engineering"),
                        Subject("Engineering Drawing"),
                        Subject("Workshop Practice")
                    )
                )

                "Semester 3" -> list.addAll(
                    listOf(
                        Subject("Environmental Microbiology"),
                        Subject("Water Supply Engineering"),
                        Subject("Environmental Chemistry and Ecology"),
                        Subject("Fluid Mechanics"),
                        Subject("Environmental Hydraulics Lab"),
                        Subject("Surveying and Leveling")
                    )
                )

                "Semester 4" -> list.addAll(
                    listOf(
                        Subject("Wastewater Engineering"),
                        Subject("Solid Waste Management"),
                        Subject("Air and Noise Pollution Control"),
                        Subject("Environmental Impact Assessment"),
                        Subject("Environmental Monitoring and Analysis Lab"),
                        Subject("Mini Project")
                    )
                )

                "Semester 5" -> list.addAll(
                    listOf(
                        Subject("Industrial Waste Management"),
                        Subject("Water and Wastewater Treatment Plant Design"),
                        Subject("Remote Sensing and GIS"),
                        Subject("Environmental Management Systems"),
                        Subject("Project Work-I"),
                        Subject("Professional Ethics and Environmental Legislation")
                    )
                )

                "Semester 6" -> list.addAll(
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
                "Semester 1" -> list.addAll(
                    listOf(
                        Subject("Applied Mathematics-I"),
                        Subject("Applied Physics"),
                        Subject("Applied Chemistry"),
                        Subject("Engineering Graphics"),
                        Subject("Communication Skills in English"),
                        Subject("Workshop Practice")
                    )
                )

                "Semester 2" -> list.addAll(
                    listOf(
                        Subject("Applied Mathematics-II"),
                        Subject("Computer Fundamentals"),
                        Subject("Engineering Mechanics"),
                        Subject("Basic Electrical and Electronics Engineering"),
                        Subject("Environmental Studies"),
                        Subject("Engineering Drawing")
                    )
                )

                "Semester 3" -> list.addAll(
                    listOf(
                        Subject("Geology and Mining Terminology"),
                        Subject("Mine Surveying-I"),
                        Subject("Mine Ventilation"),
                        Subject("Mining Machinery-I"),
                        Subject("Underground Mining Methods-I"),
                        Subject("Mining Geology Lab")
                    )
                )

                "Semester 4" -> list.addAll(
                    listOf(
                        Subject("Mine Surveying-II"),
                        Subject("Underground Mining Methods-II"),
                        Subject("Open Cast Mining"),
                        Subject("Rock Mechanics"),
                        Subject("Mine Environmental Engineering"),
                        Subject("Mine Machinery-II")
                    )
                )

                "Semester 5" -> list.addAll(
                    listOf(
                        Subject("Mine Legislation and Safety"),
                        Subject("Mining Practice"),
                        Subject("Drilling and Blasting Technology"),
                        Subject("Mineral Dressing"),
                        Subject("Mine Surveying-III"),
                        Subject("Project Work-I")
                    )
                )

                "Semester 6" -> list.addAll(
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
                "Semester 1" -> list.addAll(
                    listOf(
                        Subject("Applied Mathematics-I"),
                        Subject("Applied Physics"),
                        Subject("Applied Chemistry"),
                        Subject("Engineering Graphics"),
                        Subject("Communication Skills in English"),
                        Subject("Workshop Practice")
                    )
                )
                "Semester 2" -> list.addAll(
                    listOf(
                        Subject("Applied Mathematics-II"),
                        Subject("Computer Fundamentals"),
                        Subject("Engineering Mechanics"),
                        Subject("Environmental Science"),
                        Subject("Basic Electrical and Electronics Engineering"),
                        Subject("Engineering Drawing")
                    )
                )
                "Semester 3" -> list.addAll(
                    listOf(
                        Subject("Drilling Engineering-I"),
                        Subject("Petroleum Geology"),
                        Subject("Fluid Mechanics"),
                        Subject("Reservoir Engineering-I"),
                        Subject("Well Logging and Formation Evaluation"),
                        Subject("Petroleum Engineering Lab")
                    )
                )
                "Semester 4" -> list.addAll(
                    listOf(
                        Subject("Drilling Engineering-II"),
                        Subject("Reservoir Engineering-II"),
                        Subject("Petroleum Production Engineering-I"),
                        Subject("Petroleum Exploration"),
                        Subject("Petroleum Refining and Petrochemicals"),
                        Subject("Mini Project / Seminar")
                    )
                )
                "Semester 5" -> list.addAll(
                    listOf(
                        Subject("Petroleum Production Engineering-II"),
                        Subject("Enhanced Oil Recovery Techniques"),
                        Subject("Natural Gas Engineering"),
                        Subject("Health, Safety and Environment in Petroleum Industry"),
                        Subject("Industrial Training / Project Work-I")
                    )
                )
                "Semester 6" -> list.addAll(
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
                "Semester 1" -> list.addAll(
                    listOf(
                        Subject("Applied Physics"),
                        Subject("Applied Chemistry"),
                        Subject("Mathematics-I"),
                        Subject("Engineering Graphics"),
                        Subject("Communication Skills in English"),
                        Subject("Basic Electrical and Electronics Engineering")
                    )
                )

                "Semester 2" -> list.addAll(
                    listOf(
                        Subject("Mathematics-II"),
                        Subject("Environmental Studies"),
                        Subject("Engineering Mechanics"),
                        Subject("Basic Workshop Practice"),
                        Subject("Engineering Drawing"),
                        Subject("Computer Fundamentals")
                    )
                )

                "Semester 3" -> list.addAll(
                    listOf(
                        Subject("Physical Metallurgy"),
                        Subject("Ferrous Metallurgy"),
                        Subject("Metallurgical Thermodynamics"),
                        Subject("Mineral Processing"),
                        Subject("Metallography Lab"),
                        Subject("Metallurgical Analysis Lab")
                    )
                )

                "Semester 4" -> list.addAll(
                    listOf(
                        Subject("Mechanical Metallurgy"),
                        Subject("Foundry Technology"),
                        Subject("Heat Treatment Processes"),
                        Subject("Non-Ferrous Metallurgy"),
                        Subject("Testing of Materials"),
                        Subject("Mini Project")
                    )
                )

                "Semester 5" -> list.addAll(
                    listOf(
                        Subject("Extractive Metallurgy"),
                        Subject("Corrosion Engineering"),
                        Subject("Powder Metallurgy"),
                        Subject("Industrial Metallurgy"),
                        Subject("Metallurgical Instrumentation"),
                        Subject("Project Work-I")
                    )
                )

                "Semester 6" -> list.addAll(
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
                "Semester 1" -> list.addAll(
                    listOf(
                        Subject("Applied Physics"),
                        Subject("Applied Chemistry"),
                        Subject("Applied Mathematics I"),
                        Subject("Basic Electrical Engineering"),
                        Subject("Engineering Graphics"),
                        Subject("Workshop Practice")
                    )
                )
                "Semester 2" -> list.addAll(
                    listOf(
                        Subject("Applied Mathematics II"),
                        Subject("Electronic Devices and Circuits"),
                        Subject("Electrical Machines I"),
                        Subject("Computer Fundamentals"),
                        Subject("English Communication Skills"),
                        Subject("Electronic Devices Lab")
                    )
                )
                "Semester 3" -> list.addAll(
                    listOf(
                        Subject("Digital Electronics"),
                        Subject("Electrical Machines II"),
                        Subject("Network Analysis"),
                        Subject("Electrical and Electronic Measurements"),
                        Subject("Digital Electronics Lab"),
                        Subject("Measurements Lab")
                    )
                )
                "Semester 4" -> list.addAll(
                    listOf(
                        Subject("Power Electronics Devices"),
                        Subject("Analog Communication"),
                        Subject("Electrical Power Generation and Transmission"),
                        Subject("Microcontroller and Applications"),
                        Subject("Analog Communication Lab"),
                        Subject("Power Electronics Lab")
                    )
                )
                "Semester 5" -> list.addAll(
                    listOf(
                        Subject("Industrial Electronics"),
                        Subject("Power Electronics Circuits"),
                        Subject("Control Systems"),
                        Subject("Programmable Logic Controller"),
                        Subject("Industrial Electronics Lab"),
                        Subject("PLC Lab")
                    )
                )
                "Semester 6" -> list.addAll(
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
                "Semester 1" -> list.addAll(
                    listOf(
                        Subject("Architectural Design I"),
                        Subject("Building Materials I"),
                        Subject("Engineering Graphics I"),
                        Subject("Basic Design and Visual Arts"),
                        Subject("Workshop Practice")
                    )
                )
                "Semester 2" -> list.addAll(
                    listOf(
                        Subject("Architectural Design II"),
                        Subject("Building Materials II"),
                        Subject("Building Construction I"),
                        Subject("History of Architecture I"),
                        Subject("Computer Graphics"),
                        Subject("Surveying")
                    )
                )
                "Semester 3" -> list.addAll(
                    listOf(
                        Subject("Architectural Design III"),
                        Subject("Building Construction II"),
                        Subject("History of Architecture II"),
                        Subject("Climatology"),
                        Subject("Structural Mechanics"),
                        Subject("Interior Design")
                    )
                )
                "Semester 4" -> list.addAll(
                    listOf(
                        Subject("Architectural Design IV"),
                        Subject("Building Services"),
                        Subject("Working Drawing I"),
                        Subject("Town Planning"),
                        Subject("Estimating and Costing"),
                        Subject("Model Making Workshop")
                    )
                )
                "Semester 5" -> list.addAll(
                    listOf(
                        Subject("Architectural Design V"),
                        Subject("Building Construction III"),
                        Subject("Landscape Design"),
                        Subject("Professional Practice"),
                        Subject("Working Drawing II"),
                        Subject("Site Planning")
                    )
                )
                "Semester 6" -> list.addAll(
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
                "Semester 1" -> list.addAll(
                    listOf(
                        Subject("Applied Physics"),
                        Subject("Applied Chemistry"),
                        Subject("Applied Mathematics I"),
                        Subject("Engineering Graphics"),
                        Subject("Basic Computer Skills"),
                        Subject("Workshop Practice")
                    )
                )
                "Semester 2" -> list.addAll(
                    listOf(
                        Subject("Applied Mathematics II"),
                        Subject("Printing Processes"),
                        Subject("Paper and Ink Technology"),
                        Subject("English Communication Skills"),
                        Subject("Printing Practice Lab I")
                    )
                )
                "Semester 3" -> list.addAll(
                    listOf(
                        Subject("Printing Machines I"),
                        Subject("Typography and Layout Design"),
                        Subject("Offset Printing"),
                        Subject("Color Theory and Management"),
                        Subject("Printing Practice Lab II")
                    )
                )
                "Semester 4" -> list.addAll(
                    listOf(
                        Subject("Printing Machines II"),
                        Subject("Screen and Digital Printing"),
                        Subject("Printing Finishing and Binding"),
                        Subject("Maintenance of Printing Equipment"),
                        Subject("Printing Practice Lab III")
                    )
                )
                "Semester 5" -> list.addAll(
                    listOf(
                        Subject("Packaging Technology"),
                        Subject("Quality Control in Printing"),
                        Subject("Cost Estimation and Production Planning"),
                        Subject("Entrepreneurship Development"),
                        Subject("Industrial Training")
                    )
                )
                "Semester 6" -> list.addAll(
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
