package me.osama.passwordrequirementstextview

import assertk.assert
import assertk.assertions.isEqualTo
import me.osama.passwordrequirementstextview.password.*
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TestPasswordRequirements {

    @Test
    fun `test password is valid`() {
        val password = "P@55word"
        assert(isValidPassword(password)).isEqualTo(true)
    }

    @Test
    fun `given password is less than eight chars test password is invalid`() {
        val password = "012345"
        assert(isWithinEightAndSixteenCharacters(password)).isEqualTo(false)
    }

    @Test
    fun `given password is greater than sixteen chars test password is invalid`() {
        val password = "0123456789ABCDEFG"
        assert(isWithinEightAndSixteenCharacters(password)).isEqualTo(false)
    }

    @Test
    fun `given has uppercase test password is valid`() {
        val password = "P@55word"
        assert(hasUppercaseLetters(password)).isEqualTo(true)
    }

    @Test
    fun `given has lowercase test password is valid`() {
        val password = "P@55word"
        assert(hasLowercaseLetters(password)).isEqualTo(true)
    }

    @Test
    fun `given has digits test password is valid`() {
        val password = "P@55word"
        assert(hasDigits(password)).isEqualTo(true)
    }

    @Test
    fun `given has special characters test password is valid`() {
        val password = "P@55word"
        assert(hasSpecialCharacters(password)).isEqualTo(true)
    }

}