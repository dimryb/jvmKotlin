fun add1(a: Int): (Int) -> Int = { b -> a + b }
fun add11(a: Int): (Int) -> Int {
    return { a + it }
}


val add2: (Int) -> (Int) -> Int = { a -> { b -> a + b } }

typealias IntBinOp = (Int) -> (Int) -> Int

val add: (Int) -> ((Int) -> Int) = { a -> { b -> a + b } }
val mult: IntBinOp = { a -> { b -> a * b } }

fun printCurriedResult() {
    println("add1(3)(5): ${add1(3)(5)}")
    println("add2(3)(5): ${add2(3)(5)}")
    println("add(3)(5): ${add(3)(5)}")
    println("mult(3)(5): ${mult(3)(5)}")
}
