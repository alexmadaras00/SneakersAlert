package com.example.sneakersalert.ui.account.login

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sneakersalert.Global
import com.example.sneakersalert.Interfaces.OnBack
import com.example.sneakersalert.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

import kotlinx.android.synthetic.main.activity_main.*


class LoginFragment : Fragment(R.layout.fragment_login), OnBack {

    lateinit var email: String
    lateinit var passwordText: String
    var rootReference: DatabaseReference = FirebaseDatabase.getInstance().reference
    var conditionReference = rootReference.child("Users").child("User1")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loginButton = view.findViewById<Button>(R.id.loginB)
        val validateInput: ValidateInput
        val usernameEditText = view.findViewById<EditText>(R.id.mail)
        val passwordEditText = view.findViewById<EditText>(R.id.password)
        val value = conditionReference.child("email").setValue("kenneth@gmail.com")

        println(conditionReference)
        validateInput = ValidateInput(this.requireActivity(), usernameEditText, passwordEditText)
        requireActivity().navigationView.setCheckedItem(R.id.nav_orders)
        if (!requireActivity().navigationView.menu.findItem(R.id.nav_orders).isChecked) {
            requireActivity().navigationView.menu.setGroupCheckable(R.id.gr, true, false)
            requireActivity().navigationView.menu.setGroupCheckable(R.id.nav_orders, true, false)
            requireActivity().navigationView.menu.getItem(2).isCheckable = true
            requireActivity().navigationView.menu.getItem(2).isChecked = true
        }
        loginButton.setOnClickListener {
            login()
        }

    }

    private fun showLoginFailed(@StringRes errorString: Int) {
        val appContext = context?.applicationContext ?: return
        Toast.makeText(appContext, errorString, Toast.LENGTH_LONG).show()
    }

    override fun onBackPressed() {
        findNavController().navigate(R.id.nav_menuLogin)
    }

    fun login() {
        val usernameEditText = view?.findViewById<EditText>(R.id.mail)
        val passwordEditText = view?.findViewById<EditText>(R.id.password)
        val validateInput: ValidateInput = ValidateInput(
            this.requireActivity(),
            usernameEditText!!,
            passwordEditText!!
        )
        val emailVerified: Boolean = validateInput.validateEmail()
        val passVerified: Boolean = validateInput.validatePassword()
        if (emailVerified && passVerified) {
            email = usernameEditText.text.toString().trim()
            Global.username = usernameEditText.text.toString().trim()
            passwordText = passwordEditText.text.toString().trim()
            Global.logged = true
            findNavController().navigate(R.id.nav_orders)
        } else {
            // If sign in fails, display a message to the user.
            Toast.makeText(
                activity, "Authentication failed.",
                Toast.LENGTH_SHORT
            ).show()

        }
    }
}


