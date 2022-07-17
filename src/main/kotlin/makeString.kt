fun <T> makeString(list: List<T>, delim: String): String {
    tailrec fun makeString_(list: List<T>, acc: String): String = when
    {
        list.isEmpty() -> acc
        acc.isEmpty() -> makeString_(list.tail(), "${list.head()}")
        else -> makeString_(list.tail(), "$acc$delim${list.head()}")
    }
    return makeString_(list, "")
}

fun <T> List<T>.head(): T =
    if (this.isEmpty())
        throw IllegalArgumentException("head called on empty list")
    else
        this[0]

fun <T> List<T>.tail(): List<T> =
    if (this.isEmpty())
        throw IllegalArgumentException("tail called on empty list")
    else
        this.drop(1)


fun <T> makeString2(list: List<T>, delim: String): String =
    foldLeft(list, "") {s: String, t: T ->  if (s.isEmpty()) "$t" else "$s$delim$t"}

fun <T> makeString3(list: List<T>, delim: String): String =
    foldRight(list, "") {t: T, s: String ->  if (s.isEmpty()) "$t" else "$t$delim$s"}
