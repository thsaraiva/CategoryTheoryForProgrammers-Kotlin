import kotlin.random.Random

/**
 * [2.1] Define a higher-order function (or a function object) memoize in your favorite language. This function takes a pure
 * function f as an argument and returns a function that behaves almost exactly like f, except that it only calls the
 * original function once for every argument, stores the result internally, and subsequently returns this stored result
 * every time it’s called with the same argument. You can tell the memoized function from the original by watch- ing its
 * performance. For instance, try to memoize a function that takes a long time to evaluate. You’ll have to wait for the
 * result the first time you call it, but on subsequent calls, with the same argument, you should get the result immediately.
 */

fun <A, B> memoize(function: (A) -> B): (A) -> B {
    val memoizedValues = mutableMapOf<A, B>()
    return { value: A ->
        memoizedValues.getOrElse(value, {
            val result = function(value)
            memoizedValues[value] = result
            result
        })
    }
}

fun f(arg: String): String {
    val newString = arg + arg
    newString.forEach { print("$it ,") }
    println()
    return newString
}

fun g(arg: String): Int {
    arg.forEach { print("$it ,") }
    println()
    return arg.length
}

//fun main() {
//    println("Without Memoizing:")
//    println(g("thiago"))
//    println(g("marcela"))
//    println(g("thiago"))
//    println(g("marcela"))
//    println()
//
//    println("Memoizing:")
//    val memoizedG = memoize(::g)
//    println(memoizedG("thiago"))
//    println(memoizedG("thiago"))
//    println(memoizedG("marcela"))
//    println(memoizedG("thiago"))
//    println(memoizedG("thiago"))
//    println(memoizedG("marcela"))
//}
//fun memoizeStrStr(function: (String) -> String): (String) -> String {
//    val memoizedValues = mutableMapOf<String, String>()
//    return { value: String ->
//        memoizedValues.getOrElse(value, {
//            val result = function(value)
//            memoizedValues[value] = result
//            result
//        })
//    }
//}

/**
 * [2.2] Try to memoize a function from your standard library that you normally use to produce random numbers. Does it work?
 */
//No, it does not work.
fun <B> memoizeNoArg(function: () -> B): () -> B {
    var memoizedValue: B? = null
    return {
        if (memoizedValue == null) {
            memoizedValue = function()
        }
        memoizedValue!!
    }
}

val memoizedRandom = memoizeNoArg(Math::random)

//fun main() {
//    println("Without Memoizing:")
//    println(Math.random())
//    println(Math.random())
//    println(Math.random())
//    println()
//    println("Memoizing:")
//
//    println(memoizedRandom())
//    println(memoizedRandom())
//    println(memoizedRandom())
//}

/**
 *[2.3] Most random number generators can be initialized with a seed. Implement a function that takes a seed, calls
 * the random number generator with that seed, and returns the result. Memoize that function. Does it work?
 */
//It does work as the generator produces the same random number always for a specific seed.

fun generateRandom(seed: Int): Int {
    return Random(seed).nextInt()
}

val memoizedGenerateRandom = memoize(::generateRandom)

//fun main() {
//    println("Without Memoizing:")
//    println(generateRandom(10))
//    println(generateRandom(10))
//    println(generateRandom(10))
//    println()
//    println("Memoizing:")
//
//    println(memoizedGenerateRandom(15))
//    println(memoizedGenerateRandom(15))
//    println(memoizedGenerateRandom(15))
//}

/**
 * [2.4] Which of these functions are pure? Try to memoize them and observe what happens when you call them multiple times: memoized and not.
 *(a) The factorial function from the example in the text. -> PURE, produces same result every time is called with same argument and has no side effects.
 *
 *(b) std::getchar() -> NOT PURE, can produce different results every time is called with same argument.
 *
 *(c) bool f() {
 *  std::cout << "Hello!" << std::endl; return true;
 *} -> NOT PURE, has side effects.
 *
 * (d) int f(int x) {
 *  static int y = 0;
 *  y += x;
 *  return y;
 *  } -> NOT PURE, produces diff results every time is called with same argument.
 **/

/**
 * [2.5] How many different functions are there from Bool to Bool? Can you implement them all?
 */
fun alwaysTrue(arg: Boolean): Boolean = true
fun alwaysFalse(arg: Boolean): Boolean = false
fun same(arg: Boolean): Boolean = arg
fun opposite(arg: Boolean): Boolean = !arg

/**
 * [2.6] Draw a picture of a category whose only objects are the types Void, () (unit), and Bool; with arrows
 * corresponding to all possible functions between these types. Label the arrows with the names of the functions.
 **/
//Void -> no elements
//Unit -> The type with only one value: the `Unit` object. This type corresponds to the `void` type in Java.
//Boolean -> true,false

/**
 * You can define a function that takes Void, but you can never call it. To call it, you would have to provide a value
 * of the type Void, and there just aren’t any
 */
fun functionThatReceivesVoid(a: Void) {}


/**
 * You could never define a function that returns Void, cause you'd have to be able to instantiate an element of type
 * Void, and it's impossible by definition. Code below results in compile error
 */
//fun functionThatReturnsVoid(): Void {
//    return ??
//}

/**
 * A function that takes “nothing” can NEVER be called because there is no value representing “nothing”. Conceptually,
 * it takes a dummy value of which there is only one instance ever, so we don’t have to mention it explicitly.
 */
fun functionThatTakesUnitAndReturnsUnit(): Unit {}
