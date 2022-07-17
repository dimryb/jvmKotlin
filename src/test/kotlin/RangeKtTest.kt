import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class RangeKtTest {

    @Test
    fun unfold3() {
        val result = unfold3(1, {it + 2}, {it < 9})
        println(result)
        assertTrue(result == listOf(1, 3, 5, 7))
    }
}