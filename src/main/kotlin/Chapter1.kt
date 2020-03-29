//Identity function for all types in Kotlin
fun <A> identity(a: A): A = a

//Composition function in Kotlin
fun <A, B, C> compose(f: (A) -> B, g: (B) -> C): (A) -> C = { a: A -> g(f(a)) }