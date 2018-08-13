package me.osama.passwordrequirementstextview

import android.app.Activity
import android.util.Log
import android.widget.CheckBox
import me.osama.passwordrequirementstextview.password.*
import java.util.regex.Pattern


fun Activity.logError(message: () -> String) {
    Log.e(this.javaClass.simpleName.take(20), message())
}

fun Activity.logInfo(message: () -> String?) {
    Log.i(this.javaClass.simpleName, message())
}

fun Activity.logDebug(message: () -> String) {
    if (BuildConfig.DEBUG) {
        Log.i(this.javaClass.simpleName, message())
    }
}

fun isValidPassword(password: String): Boolean {
    return password.let {
        isWithinEightAndSixteenCharacters(it) and
                hasUppercaseLetters(it) and
                hasLowercaseLetters(it) and
                hasDigits(it) and
                hasSpecialCharacters(it)
    }
}

fun handleCheckMarks(regexList: List<Pattern>, checkboxes: List<CheckBox>, check: (Pair<Pattern, CheckBox>) -> Unit) {
    if (regexList.size != checkboxes.size) {
        throw Exception("un equal checkboxes and regexes")
    }
    regexList.zip(checkboxes).forEach { check(it) }
}