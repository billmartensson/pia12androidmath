package se.magictechnology.pia12androidmath

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * Very nice viewmodel for *math* stuff
 *
 */
class MathViewmodel : ViewModel() {

    private val _mathresult = MutableStateFlow<Int?>(null)
    val mathresult : StateFlow<Int?> get() = _mathresult


    fun addnumbers(n1 : String, n2 : String) {
        var result = addnumberscalc(n1, n2)

        _mathresult.value = result
    }

    /**
     * Add two numbers
     * @return The result
     */
    fun addnumberscalc(n1 : String, n2 : String) : Int? {

        if(n1.toIntOrNull() == null) {
            return null
        }
        if(n2.toIntOrNull() == null) {
            return null
        }

        var result = n1.toInt() + n2.toInt()
        if(result > 10) {
            result = 10
        }

        return result
    }

    fun subtractnumbers(n1 : String, n2 : String) {
        var result = subtractnumberscalc(n1, n2)

        _mathresult.value = result
    }

    fun subtractnumberscalc(n1 : String, n2 : String) : Int? {

        if(n1.toIntOrNull() == null) {
            return null
        }
        if(n2.toIntOrNull() == null) {
            return null
        }

        var result = n1.toInt() - n2.toInt()
        if(result < 0) {
            result = 0
        }

        return result
    }

    fun multi(n1 : String, n2 : String) {
        var result = multicalc(n1, n2)

        _mathresult.value = result
    }

    fun multicalc(n1 : String, n2 : String) : Int? {

        if(n1.toIntOrNull() == null) {
            return null
        }
        if(n2.toIntOrNull() == null) {
            return null
        }

        var result = n1.toInt() * n2.toInt()

        if(result > 100) {
            result = 100
        }
        if(result < 0) {
            result = 0
        }

        return result
    }

}