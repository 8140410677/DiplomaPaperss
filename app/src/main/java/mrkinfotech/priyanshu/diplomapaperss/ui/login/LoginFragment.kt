package mrkinfotech.priyanshu.diplomapaperss.ui.login

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import mrkinfotech.priyanshu.diplomapaperss.R
import mrkinfotech.priyanshu.diplomapaperss.databinding.FragmentLoginBinding
import mrkinfotech.priyanshu.diplomapaperss.ui.Home.HomeMainActivity

class LoginFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var binding: FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginEditForget.setOnClickListener {
            findNavController().navigate(R.id.ForgetFragment)
        }

        binding.loginGoButton.setOnClickListener {
            val userEmail = binding.loginEditEmail.text.toString()
            val Password = binding.loginEditPassword.text.toString()

            val auth = FirebaseAuth.getInstance()
            if (userEmail.isNotEmpty() && Password.isNotEmpty()) {
                auth.signInWithEmailAndPassword(userEmail, Password)
                    .addOnCompleteListener(requireActivity()) {
                        if (it.isSuccessful) {
                            Log.d(TAG, "signInWithEmail:success")
                            val user = auth.currentUser
                            val intent = Intent(requireContext(), HomeMainActivity::class.java)
                            startActivity(intent)

                        } else {
                            Log.w(TAG, "signInWithEmail:failure", it.exception)
                            Toast.makeText(
                                requireContext(),
                                "Authentication failed.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            }
        }

        binding.signupLink.setOnClickListener {
            findNavController().navigate(R.id.SignupFragment)
        }
    }

}