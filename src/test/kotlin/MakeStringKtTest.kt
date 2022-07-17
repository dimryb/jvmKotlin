import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MakeStringKtTest {

    @Test
    fun makeString() {
        assertTrue("ab|bc|cd" == makeString(listOf("ab", "bc", "cd"), "|"))
    }

    @Test
    fun makeString2() {
        val result = makeString2(listOf("ab", "bc", "cd"), "|")
        println(result)
        assertTrue("ab|bc|cd" == result)
    }

    @Test
    fun makeString3() {
        val result = makeString3(listOf("ab", "bc", "cd"), "|")
        println(result)
        assertTrue("ab|bc|cd" == result)
    }
}