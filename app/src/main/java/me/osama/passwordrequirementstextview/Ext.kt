package me.osama.passwordrequirementstextview

import android.app.Activity
import android.text.Editable
import android.util.Log
import android.widget.CheckBox
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

fun isRequirementsComplete(regexList: List<Pair<Pattern, CheckBox>>, password: Editable?): Boolean {
    return regexList.map {
        it.second.isChecked = it.first.matcher(password.toString()).find() // this is a side effect, should not happen
        return@map it.first.matcher(password.toString()).find()
    }.all { it }
}