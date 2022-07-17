import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ReverseKtTest {

    @Test
    fun reverse() {
        val result = reverse (listOf(1, 2, 3, 4))
        println(result)
        assertTrue(result == listOf(4, 3, 2, 1))
    }

    @Test
    fun copy1() {
        val result = copy1 (listOf(1, 2, 3, 4))
        println(result)
        assertTrue(result == listOf(1, 2, 3, 4))
    }

    @Test
    fun prepend2() {
        val result = prepend2 (listOf(1, 2, 3, 4), 0)
        println(result)
        assertTrue(result == listOf(0, 1, 2, 3, 4))
    }

    @Test
    fun reverse2() {
        val result = reverse2 (listOf(1, 2, 3, 4))
        println(result)
        assertTrue(result == listOf(4, 3, 2, 1))
    }
}