package lists

sealed class List<A> {
    abstract fun isEmpty(): Boolean

    abstract fun setHead(a: A): List<A>

    private object Nil : List<Nothing>() {

        override fun isEmpty() = true

        override fun toString(): String = "[NIL]"

        override fun setHead(a: Nothing): List<Nothing> {
            //Todo: Разобраться с этой проблемой. Стр 173
            throw IllegalStateException("setHead called on an empty list")
        }
    }

    private class Cons<A>(
        internal val head: A,
        internal val tail: List<A>,
    ) : List<A>() {
        override fun isEmpty(): Boolean = false

        override fun toString(): String = "[${toString("", this)}NIL]"

        private tailrec fun toString(acc: String, list: List<A>): String =
            when (list) {
                is Nil -> acc
                is Cons -> toString("$acc${list.head}, ", list.tail)
            }

        override fun setHead(a: A): List<A> = tail.cons(a)
    }

    fun cons(a: A): List<A> = Cons(a, this)

    companion object {
        operator fun <A> invoke(vararg az: A): List<A> =
            az.foldRight(Nil as List<A>) { a: A, list: List<A> ->
                Cons(a, list)
            }
    }
}

