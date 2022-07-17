fun square(num: Int) = num * num
fun triple(num: Int) = num * 3
fun compose(f: (Int) -> Int, g: (Int) -> Int): (Int) -> Int = { x -> f(g(x)) }
val squareOfTriple = compose(::square, ::triple)

fun <T> compose2(f: (T) -> T, g: (T) -> T): (T) -> T = { x -> f(g(x)) }
val squareOfTriple2 = compose2(::square, ::triple)

fun <T, U, V> compose3(f: (U) -> V, g: (T) -> U): (T) -> V = { x -> f(g(x)) }
val squareOfTriple3 = compose3(::square, ::triple)

fun <T, U, V> higherCompose(): ((U) -> V) -> ((T) -> U) -> (T) -> V =
    { f: (U) -> V ->
        { g: (T) -> U ->
            { x: T -> f(g(x)) }
        }
    }

val squareOfTriple4 = higherCompose<Int, Int, Int>()(::square)(::triple)

fun <T, U, V> higherAndThen(): ((T) -> U) -> ((U) -> V) -> (T) -> V =
    { f: (T) -> U ->
        { g: (U) -> V ->
            { x: T -> g(f(x)) }
        }
    }

val squareOfTriple5 = higherAndThen<Int, Int, Int>()(::triple)(::square)

fun printCompositionResult() {
    println("squareOfTriple(2) = ${squareOfTriple(2)}")
    println("squareOfTriple2(2) = ${squareOfTriple2(2)}")
    println("squareOfTriple3(2) = ${squareOfTriple3(2)}")
    println("squareOfTriple4(2) = ${squareOfTriple4(2)}")
    println("squareOfTriple5(2) = ${squareOfTriple5(2)}")
    // Выводит: squareOfTriple(2) = 36
}
