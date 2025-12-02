package mrkinfotech.priyanshu.diplomapaperss.ui.navigationDrawer

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import mrkinfotech.priyanshu.diplomapaperss.databinding.ActivityFeedbackBinding

class FeedbackActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFeedbackBinding
    private val auth by lazy { FirebaseAuth.getInstance() }
    private val db = FirebaseDatabase.getInstance().reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedbackBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmitFeedback.setOnClickListener { submitFeedback() }
    }

    private fun submitFeedback() {
        val feedback = binding.etFeedback.text.toString().trim()

        if (feedback.isEmpty()) {
            Toast.makeText(this, "Please write something first!", Toast.LENGTH_SHORT).show()
            return
        }

        val user = auth.currentUser
        val data = mapOf(
            "userId" to user?.uid,
            "userName" to (user?.displayName ?: "Anonymous"),
            "userEmail" to user?.email,
            "feedback" to feedback,
            "timestamp" to System.currentTimeMillis()
        )

        db.child("Feedbacks").push().setValue(data)
            .addOnSuccessListener {
                Toast.makeText(this, "Feedback sent successfully!", Toast.LENGTH_SHORT).show()
                finish()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed to send feedback!", Toast.LENGTH_SHORT).show()
            }
    }
}
