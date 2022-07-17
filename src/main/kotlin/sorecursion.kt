fun inc(n: Int) = n + 1
fun dec(n: Int) = n - 1

tailrec fun add(a: Int, b: Int): Int {
    return if (b == 0) a else add(inc(a), dec(b))
}

fun add_test() {
    println("10 + 7 == ${add(10, 7)}")
}

