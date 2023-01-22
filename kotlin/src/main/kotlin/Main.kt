package test

import kotlin.text.*

// Comment
/* Comment */

annotation class CustomAnnotation

@CustomAnnotation var global_var = 1
val global_val: Int by lazy { 2 }
const val global_const = 3

@Deprecated("annotation") fun func2() = global_var

fun func(a: Int, b: String): Array<Int> {
    return arrayOf(a)
}

fun funcNullable(): SomeBaseClass? = null

fun SomeEnum.extensionFunc() {
    //TODO("todo")
}

inline fun <T : Comparable<T>> genericFunc(@CustomAnnotation t: T, other: T): Boolean = t == other

@CustomAnnotation
enum class SomeEnum {
    @CustomAnnotation A,
    B,
    C
}

typealias funcAlias = (Int) -> Int

@CustomAnnotation
interface SomeInterface<T> where T : Comparable<T> {
    val interfaceVal: T

    @CustomAnnotation fun interfaceFunc()
}

/**
 * Class with value [interfaceVal] and func [func]
 * @param interfaceVal parameter
 */
abstract class SomeBaseClass(override var interfaceVal: Double = 2.4) : SomeInterface<Double> {
    lateinit var lateinitVar: SomeEnum
    private var privateVar = 5

    init {
        lateinitVar = SomeEnum.A
    }

    public var pubVar: Int
        get() = privateVar
        set(value) {
            privateVar = value
        }

    abstract fun func()
    override fun interfaceFunc() {}
}

class SomeClass : SomeBaseClass() {
    var str: String = "a".also(::println)

    init {
        str = "a"
    }

    override fun func() {
        var aas = 5
        println(this.pubVar)
    }
}

data class SomeDataClass constructor(val a: Int)

object SomeObject {
    val a = "object"
}

fun main(args: Array<String>) {
    val arg = args.size
    val string = "Hello \n World!" + 'c' + "text $arg ${func(1, "str")}"
    val n1 = 1 + 1L - 0x123 * 0b1_0_0_0
    val n2: Double? = 4.53 / 4.53e+2 % 4.253f * 4.53e2f
    val n3 = Double.NaN
    val bol = true || false && 5 < 5
    val nul = null
    val maybeNull = funcNullable()
    val b = maybeNull?.pubVar ?: 2.512
    val b2 = n2!!.toInt()
    val b3 = n2 as? Double

    var kls = SomeClass()
    val kvar = kls.lateinitVar?.extensionFunc()
    var kvar2 = kls.lateinitVar.let { it }

    val bool = genericFunc(t = 1, other = 2)

    with(kls) { lateinitVar.apply { extensionFunc() } }

    val map = mapOf("a" to 1, "b" to 2, "c" to 3)
    val mutSet: MutableSet<String> = HashSet()
    val letters = listOf("a", "b", "c")

    val lambda = { x: Int -> x * x }

    val c =
        if (n1 > 4) {
            5
        } else {
            6
        }

    when (arg as Any) {
        1 -> ""
        "text" -> ""
        is String -> ""
        else -> ""
    }

    for (letter in letters) {}
    for (i in 0..4) {}
    for (i in 4 downTo 0 step 2) {}
    while (false) {}
    letters
        .filter label@{
            if (it.startsWith("a")) {
                true
            } else {
                return@label false
            }
        }
        .forEach {}

    try {
        throw Exception("msg")
    } catch (e: Exception) {
    } finally {}
}
