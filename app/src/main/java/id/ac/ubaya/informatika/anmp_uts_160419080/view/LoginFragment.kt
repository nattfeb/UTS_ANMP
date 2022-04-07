package id.ac.ubaya.informatika.anmp_uts_160419080.view

import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.anmp_uts_160419080.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txtRegisterHere.setOnClickListener {
            val action = LoginFragmentDirections.actionRegister()
            Navigation.findNavController(it).navigate(action)
        }

        btnLogin.setOnClickListener {
            val username = txtUsername.text.toString()
            val action = LoginFragmentDirections.actionLoginToEbookList(username)
            Navigation.findNavController(it).navigate(action)
        }
    }

}