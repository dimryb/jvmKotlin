package lists

sealed class List<A> {

    abstract fun isEmpty(): Boolean

    abstract fun concat(list: List<A>): List<A>

    abstract class Empty<A> : List<A>() {
        override fun concat(list: List<A>): List<A> = list
    }

    fun setHead(a: @UnsafeVariance A): List<A> = when (this) {
        is Empty<A> -> throw IllegalStateException("setHead called on an empty list")
        is Cons -> Cons(a, this.tail)
    }

    fun cons(a: @UnsafeVariance A): List<A> = Cons(a, this)

    fun drop(n: Int): List<A> = drop(this, n)

    fun dropWhile(p: (A) -> Boolean): List<A> = dropWhile(this, p)

    fun reverse(): List<A> {
        tailrec fun <A> reverse(acc: List<A>, list: List<A>): List<A> = when (list) {
            is Empty<A> -> acc
            is Cons -> reverse(acc.cons(list.head), list.tail)
        }
        return reverse(List.invoke(), this)
    }

    fun init(): List<A> = reverse().drop(1).reverse()

    fun sum(ints: List<Int>): Int = when (ints) {
        is Empty<Int> -> 0
        is Cons -> ints.head + sum(ints.tail)
    }

    private object Nil : Empty<Nothing>() {

        override fun isEmpty() = true

        override fun toString(): String = "[NIL]"
    }

    private class Cons<A>(
        internal val head: A,
        internal val tail: List<A>,
    ) : List<A>() {

        override fun isEmpty(): Boolean = false

        override fun toString(): String = "[${toString("", this)}NIL]"

        private tailrec fun toString(acc: String, list: List<A>): String = when (list) {
            is Empty<A> -> acc
            is Cons -> toString("$acc${list.head}, ", list.tail)
        }

        override fun concat(list: List<A>): List<A> = Cons(this.head, list.concat(this.tail))
    }


    companion object {

        tailrec fun <A> drop(list: List<A>, n: Int): List<A> = when (list) {
            is Empty<A> -> list
            is Cons -> if (n <= 0) list else drop(list.tail, n - 1)
        }

        tailrec fun <A> dropWhile(list: List<A>, p: (A) -> Boolean): List<A> = when (list) {
            is Empty<A> -> list
            is Cons -> if (p(list.head)) dropWhile(list.tail, p) else list
        }

        tailrec fun <A> reverse(acc: List<A>, list: List<A>): List<A> = when (list) {
            is Empty<A> -> acc
            is Cons -> reverse(acc.cons(list.head), list.tail)
        }

        operator fun <A> invoke(vararg az: A): List<A> = az.foldRight(Nil as List<A>) { a: A, list: List<A> ->
            Cons(a, list)
        }

    }
}


