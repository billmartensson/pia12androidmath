package se.magictechnology.pia12androidmath

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {



    @Test
    fun addition_isCorrect() {

        var mathvm = MathViewmodel()

        var res1 = mathvm.addnumberscalc("3", "2")
        var res2 = mathvm.addnumberscalc("2", "7")
        var res3 = mathvm.addnumberscalc("18", "5")
        var res4 = mathvm.addnumberscalc("banan", "1")

        assertEquals(5, res1)
        assertEquals(9, res2)
        assertEquals(10, res3)
        assertEquals(null, res4)
    }

    @Test
    fun checkminus() {
        var mathvm = MathViewmodel()

        var res4 = mathvm.subtractnumberscalc("5", "2")
        var res5 = mathvm.subtractnumberscalc("2", "99")
        var res6 = mathvm.subtractnumberscalc("", "99")

        assertEquals(3, res4)
        assertEquals(0, res5)
        assertEquals(null, res6)
    }

    @Test
    fun checkmulti() {
        var mathvm = MathViewmodel()

        var res1 = mathvm.multicalc("2", "3")
        assertEquals(6, res1)

        var res2 = mathvm.multicalc("25", "17")
        assertEquals(100, res2)

        var res3 = mathvm.multicalc("-25", "17")
        assertEquals(0, res3)

        var res4 = mathvm.multicalc("-25", "-17")
        assertEquals(100, res4)

        var res5 = mathvm.multicalc("", "-17")
        assertEquals(null, res5)

        var res6 = mathvm.multicalc("1", "")
        assertEquals(null, res6)

    }

}