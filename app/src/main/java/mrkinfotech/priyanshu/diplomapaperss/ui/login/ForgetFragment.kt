package mrkinfotech.priyanshu.diplomapaperss.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import mrkinfotech.priyanshu.diplomapaperss.R
import mrkinfotech.priyanshu.diplomapaperss.databinding.FragmentForgetBinding
import mrkinfotech.priyanshu.diplomapaperss.databinding.FragmentLoginBinding
import mrkinfotech.priyanshu.diplomapaperss.ui.utils.CustomDiloag

class ForgetFragment : Fragment() {

    private lateinit var binding: FragmentForgetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentForgetBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.resetpassword.setOnClickListener {

            val newPassword = binding.forgeteditText.text.toString()
            val ConfirmPassword = binding.forgeteditText2.text.toString()

            if(newPassword.isEmpty() || ConfirmPassword.isEmpty())
            {
                CustomDiloag.customMessage(requireContext(),"Fill The Password And New Password")
            }
            else if (newPassword.equals(ConfirmPassword))
            {
                findNavController().navigate(R.id.LoginFragment)
            }
            else if(!newPassword.equals(ConfirmPassword)){
                CustomDiloag.customMessage(requireContext(),"Enter a Correct Both Password")
            }
            else { }

        }
    }
}