import java.math.BigInteger

fun fibo(number: Int): String {
    tailrec fun fibo(
        acc: List<BigInteger>,
        acc1: BigInteger,
        acc2: BigInteger,
        x: BigInteger,
    ): List<BigInteger> =
        when (x) {
            BigInteger.ZERO -> acc
            BigInteger.ONE -> acc + (acc1 + acc2)
            else -> fibo(acc + (acc1 + acc2), acc2, acc1 + acc2,
                x - BigInteger.ONE)
        }

    val list = fibo(listOf(), BigInteger.ONE, BigInteger.ZERO,
        BigInteger.valueOf(number.toLong()))
    return makeStringFibo(list, ",")
}

fun <T> makeStringFibo(list: List<T>, separator: String): String =
    when {
        list.isEmpty() -> ""
        list.tail().isEmpty() -> list.head().toString()
        else -> list.head().toString() +
                foldLeft(list.tail(), "") { x, y -> x + separator + y }
    }