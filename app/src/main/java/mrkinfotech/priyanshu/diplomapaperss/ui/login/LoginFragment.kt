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
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import mrkinfotech.priyanshu.diplomapaperss.R
import mrkinfotech.priyanshu.diplomapaperss.databinding.FragmentLoginBinding
import mrkinfotech.priyanshu.diplomapaperss.ui.Home.HomeMainActivity
import mrkinfotech.priyanshu.diplomapaperss.ui.utils.CustomDiloag
import mrkinfotech.priyanshu.diplomapaperss.ui.utils.PreferenceHelper
import kotlin.jvm.java

class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    private lateinit var googleSignInClient: GoogleSignInClient
    private val RC_SIGN_IN = 1001


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
                            PreferenceHelper.setUserEmail(requireContext(), userEmail)
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


        val auth = FirebaseAuth.getInstance()

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.webclient))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(requireContext(), gso)


        binding.loginWithGoogle.setOnClickListener {
            signInWithGoogle()

        }

        binding.signupLink.setOnClickListener {
            findNavController().navigate(R.id.SignupFragment)
        }
    }

    private fun signInWithGoogle() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {

                CustomDiloag.customMessage(requireContext(), "Google Sign-in Failed: ${e.message}")
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        val auth = FirebaseAuth.getInstance()

        auth.signInWithCredential(credential)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    CustomDiloag.customMessage(requireContext(), "Welcome ${user?.displayName}")

                    startActivity(Intent(requireContext(), HomeMainActivity::class.java))
                    requireActivity().finish()
                } else {
                    CustomDiloag.customMessage(requireContext(), "Authentication Failed")
                }
            }
    }


}