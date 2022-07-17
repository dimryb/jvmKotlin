import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class FoldLeftKtTest {

    @Test
    fun sumTest() {
        val result = sum(listOf(1, 2, 3))
        assertTrue(result == 6)
    }

    @Test
    fun string() {
        val result = string(listOf('a', 'b', 'c'))
        assertTrue(result == "abc")
    }

    @Test
    fun string2() {
        val result = string2(listOf('a', 'b', 'd'))
        assertTrue(result == "abd")
    }

    @Test
    fun string3() {
        val result = string3(listOf('a', 'b', 'd'))
        println(result)
        assertTrue(result == "abd")
    }
}