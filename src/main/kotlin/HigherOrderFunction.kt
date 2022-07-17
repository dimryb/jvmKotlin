typealias funBinOp = ((Int) -> Int) -> ((Int) -> Int) -> (Int) -> Int

val composeHof: funBinOp = { a -> { b -> { x -> a(b(x)) } } }

typealias func = (Int) -> Int

val composeHof2 = { a: func -> { b: func -> { x: Int -> a(b(x)) } } }