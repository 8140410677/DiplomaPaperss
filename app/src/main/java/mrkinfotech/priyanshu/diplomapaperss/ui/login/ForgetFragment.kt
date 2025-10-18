package mrkinfotech.priyanshu.diplomapaperss.ui.login

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import mrkinfotech.priyanshu.diplomapaperss.databinding.FragmentForgetBinding
import mrkinfotech.priyanshu.diplomapaperss.ui.utils.CustomDiloag

class ForgetFragment : Fragment() {

    private lateinit var binding: FragmentForgetBinding
    private lateinit var auth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentForgetBinding.inflate(layoutInflater)
        auth = FirebaseAuth.getInstance()

        binding.progressBar.visibility = View.GONE


        binding.infoText.text = ""


        binding.resetpassword.setOnClickListener {
            val email = binding.forgeteditText.text.toString().trim()

            if (!isValidEmail(email)) {


                binding.forgeteditText.error = "Enter a valid email"

                binding.forgeteditText.requestFocus()

                return@setOnClickListener
            }
            sendResetEmail(email)
        }
        return binding.root
    }


    private fun isValidEmail(email: String): Boolean {
        return email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    @SuppressLint("SetTextI18n")
    private fun sendResetEmail(email: String) {
        binding.progressBar.visibility = View.VISIBLE
        binding.resetpassword.isEnabled = false
        binding.infoText.text = ""

        auth.sendPasswordResetEmail(email)
            .addOnCompleteListener { task ->


                binding.progressBar.visibility = View.GONE



                binding.resetpassword.isEnabled = true

                if (task.isSuccessful) {


                    CustomDiloag.customMessage(requireContext(), "Reset link sent to $email")


                    binding.infoText.text =
                        "Check your email for the reset link. It may take a few minutes."

                 binding.forgeteditText.text?.clear()


                } else {
                    val msg = task.exception?.message ?: "Failed to send reset email"

                    CustomDiloag.customMessage(requireContext(), msg)


                    binding.infoText.text = "Error: ${task.exception?.localizedMessage}"
                }
            }
    }
}