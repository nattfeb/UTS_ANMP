package id.ac.ubaya.informatika.anmp_uts_160419080.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.anmp_uts_160419080.R
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txtLoginHere.setOnClickListener {
            val action = RegisterFragmentDirections.actionRegToLog()
            Navigation.findNavController(it).navigate(action)
        }

        btnRegister.setOnClickListener {
            val username = txtNewUsername.text.toString()
            val action = RegisterFragmentDirections.actionEbookList(username)
            Navigation.findNavController(it).navigate(action)
        }
    }
}