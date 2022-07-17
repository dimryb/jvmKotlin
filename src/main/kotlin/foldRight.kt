
fun <T, U> foldRight(list: List<T>, identity: U, f: (T, U)->U): U =
    if (list.isEmpty())
        identity
    else
        f(list.head(), foldRight(list.tail(), identity, f))