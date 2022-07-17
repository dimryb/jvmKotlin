fun range(start: Int, end: Int): List<Int> {
    val result: MutableList<Int> = mutableListOf()
    var index = start
    while (index < end) {
        result.add(index)
        index++
    }
    return result
}

fun <T> unfold2(seed: T, f: (T) -> T, p: (T) -> Boolean): List<T> {
    val result: MutableList<T> = mutableListOf()
    var elem = seed
    while (p(elem)) {
        result.add(elem)
        elem = f(elem)
    }
    return result
}

fun range2(start: Int, end: Int): List<Int> =
    unfold(start, { it + 1 }, { it < end })

fun range3(start: Int, end: Int): List<Int> =
    if (end <= start)
        listOf()
    else
        prepend(range(start + 1, end), start)

fun <T> unfold(seed: T, f: (T) -> T, p: (T) -> Boolean): List<T> =
    if (p(seed))
        prepend(unfold(f(seed), f, p), seed)
    else
        listOf()

fun <T> unfold3(seed: T, f: (T) -> T, p: (T) -> Boolean): List<T> {
    tailrec fun unfold_(
        acc: List<T>, seed: T,
        f: (T) -> T,
    ): List<T> =
        if (p(seed))
            unfold_(acc + seed, f(seed), f)
        else
            acc
    return unfold_(listOf(), seed, f)
}