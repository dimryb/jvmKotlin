package lists

import org.junit.jupiter.api.Test

internal class ListTest{

    @Test
    fun listTest_toString(){
        val list = List(1, 2)
        val str = list.toString()
        assert(str == "[1, 2, NIL]")
    }

    @Test
    fun listTest_cons(){
        val list = List(1, 2)
        val list1 = list.cons(3)
        val list2 = list1.cons(4)
        val str = list2.toString()
        assert(str == "[4, 3, 1, 2, NIL]")
    }

    @Test
    fun listTest_setHead(){
        val list = List(1, 2)
        val list1 = list.setHead(3)
        val str = list1.toString()
        assert(str == "[3, 2, NIL]")
    }

    @Test
    fun listTest_setHead_2(){
        val list = List(1)
        val list1 = list.setHead(3)
        val str = list1.toString()
        assert(str == "[3, NIL]")
    }
}