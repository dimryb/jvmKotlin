
fun <T> prepend(list: List<T>, elem: T): List<T> = listOf(elem) + list

fun <T> reverse (list: List<T>): List<T> =
    foldLeft(list, listOf(), ::prepend)

fun <T> copy1 (list: List<T>): List<T> =
    foldLeft(list, listOf()) { lst: List<T>, elem: T ->  lst + elem}

fun <T> prepend2(list: List<T>, elem: T): List<T> =
    foldLeft(list, listOf(elem)) {lst: List<T>, elem: T -> lst + elem }

fun <T> reverse2 (list: List<T>): List<T> =
    foldLeft(list, listOf(), ::prepend2)