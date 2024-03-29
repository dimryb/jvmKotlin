package lists

import org.junit.jupiter.api.Test

internal class ListTest {

    @Test
    fun listTest_toString() {
        val list = List(1, 2)
        val str = list.toString()
        assert(str == "[1, 2, NIL]")
    }

    @Test
    fun listTest_cons() {
        val list = List(1, 2)
        val list1 = list.cons(3)
        val list2 = list1.cons(4)
        val str = list2.toString()
        assert(str == "[4, 3, 1, 2, NIL]")
    }

    @Test
    fun listTest_setHead() {
        val list = List(1, 2)
        val list1 = list.setHead(3)
        val str = list1.toString()
        assert(str == "[3, 2, NIL]")
    }

    @Test
    fun listTest_setHead_2() {
        val list = List(1)
        val list1 = list.setHead(3)
        val str = list1.toString()
        assert(str == "[3, NIL]")
    }

    @Test
    fun listTest_drop() {
        val list = List(1, 2, 3, 4, 5)
        val list1 = list.drop(3)
        val str = list1.toString()
        assert(str == "[4, 5, NIL]")
    }

    @Test
    fun listTest_dropWhile() {
        val list = List(1, 2, 3, 4, 5)
        val list1 = list.dropWhile {
            it != 4
        }
        val str = list1.toString()
        assert(str == "[4, 5, NIL]")
    }

    @Test
    fun listTest_reverse() {
        val list = List( 1, 2, 3, 4, 5)
        val list1 = list.reverse()
        val str = list1.toString()
        assert(str == "[5, 4, 3, 2, 1, NIL]")
    }

    @Test
    fun listTest_init() {
        val list = List( 1, 2, 3, 4, 5)
        val str = list.init().toString()
        assert(str == "[1, 2, 3, 4, NIL]")
    }

    @Test
    fun listTest_sum() {
        val list = List( 1, 2, 3, 4, 5)
        val str = sum(list).toString()
        assert(str == "15")
    }

    @Test
    fun listTest_product() {
        val list = List( 1.0, 2.0, 3.0)
        val str = product(list).toString()
        assert(str == "6.0")
    }

    @Test
    fun listTest_length() {
        val list = List( 1, 2, 3, 4, 5)
        val str = list.length().toString()
        assert(str == "5")
    }
}