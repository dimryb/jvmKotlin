import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class FiboKtTest {
    @Test
    fun fiboTest() {
        val result = fibo(7)
        assertTrue(result == "1,1,2,3,5,8,13")
    }
}