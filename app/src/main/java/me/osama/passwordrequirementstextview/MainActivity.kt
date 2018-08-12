package me.osama.passwordrequirementstextview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val password = findViewById<TextView>(R.id.password)
        val regexList = listOf<Pair<Pattern, CheckBox>>(
                Pattern.compile("^.{8,16}\$") to findViewById(R.id.checkboxEightCharacters)!!,
                Pattern.compile("[A-Z]") to findViewById(R.id.checkboxUppercase)!!,
                Pattern.compile("[a-z]") to findViewById(R.id.checkboxLowercase)!!,
                Pattern.compile("\\d") to findViewById(R.id.checkboxDigit)!!,
                Pattern.compile("[~`!@#\$%^&*()+=_\\-{}\\[\\]|:;”’?/<>,.]") to findViewById(R.id.checkboxSpecialChars)!!
        )

        val register = findViewById<Button>(R.id.btnRegister)

        password.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                register.isEnabled = isRequirementsComplete(regexList, s)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(string: CharSequence?, start: Int, before: Int, count: Int) {

            }

        })

    }
}