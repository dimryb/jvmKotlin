
// Сгиб влево
// Откидывая первый элемент списка на каждой итерации рекурсии
// добавляет его к аккумулятору согласно функции f
fun <T, U> foldLeft(list: List<T>, z: U, f: (U, T)->U): U {
    tailrec fun foldLeft(list: List<T>, acc: U): U =
        if (list.isEmpty())
            acc
        else
            foldLeft(list.tail(), f(acc, list.head()))
    return foldLeft(list, z)
}

fun sum(list: List<Int>) = foldLeft(list, 0, Int::plus)

fun <T> prepend(list: List<T>, elem: T): List<T> = listOf(elem) + list

fun sumTest(){
    val result = sum(listOf(1, 2, 3))
    println(result)
}