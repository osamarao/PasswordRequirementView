package me.osama.passwordrequirementstextview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import me.osama.passwordrequirementstextview.password.passwordSpec

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val passwordView = findViewById<TextView>(R.id.password)

        val checkboxes = listOf<CheckBox>(
                findViewById(R.id.checkboxEightCharacters),
                findViewById(R.id.checkboxUppercase),
                findViewById(R.id.checkboxLowercase),
                findViewById(R.id.checkboxDigit),
                findViewById(R.id.checkboxSpecialChars)
        )

        val register = findViewById<Button>(R.id.btnRegister)

        passwordView.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(password: Editable?) {
                register.isEnabled = isValidPassword(password.toString())
                handleCheckMarks(passwordSpec, checkboxes) {
                    it.second.isChecked = it.first.matcher(password.toString()).find()
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(string: CharSequence?, start: Int, before: Int, count: Int) {

            }

        })

    }
}