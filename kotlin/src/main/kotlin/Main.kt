package test

import kotlin.text.*

// Comment
/* Comment */

annotation class CustomAnnotation

@CustomAnnotation var global_var = 1
val global_val: Int by lazy { 2 }
const val global_const = 3

@Deprecated("annotation") fun func2() = global_var + global_val + global_const
fun func(a: Int, b: String): Array<Int> {
    println(b)
    return arrayOf(a)
}

fun funcNullable(): SomeBaseClass? = null

fun Int.extensionFunc() {
    println(this)
    //TODO("todo")
}

typealias FuncAlias<T> = (T, T) -> Boolean
inline fun <T : Comparable<T>> genericFunc(@CustomAnnotation t: T, other: T, f: FuncAlias<T>): Boolean = f(t, other)

@CustomAnnotation
enum class SomeEnum {
    @CustomAnnotation A,
    B,
    C
}

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
    private lateinit var lateinitVar: SomeEnum
    private var privateVar: Int?

    init {
        privateVar = null
    }

    var pubVar: Int?
        get() = privateVar
        set(value) {
            privateVar = value
        }

    fun init() {
        lateinitVar = SomeEnum.B
    }

    abstract fun func()
    override fun interfaceFunc() {}
}

class SomeClass : SomeBaseClass() {
    private var str: String = "a".also(::println)

    init {
        str = "a"
    }

    override fun func() {
        var aas = 5
        println("${this.pubVar}, $aas")
        aas = 6
        print(aas)
    }
}

data class SomeDataClass constructor(val a: Int)

object SomeObject {
    const val a = "object"
}

fun main(args: Array<String>) {
    val arg = args.size
    val string = "Hello \n World!" + 'c' + "text $arg ${func(1, "str")}"
    val n1 = 1 + 1L - 0x123 * 0b1_0_0_0
    val n2: Double = 4.53 / 4.53e+2 % 4.253f * 4.53e2f
    val n3 = Double.NaN
    val bol = arrayOf(true, false)
    val nul = null
    val maybeNull: SomeBaseClass? = funcNullable()
    maybeNull?.init()
    val b = maybeNull?.pubVar ?: 2.512
    val b2 = b!!.toInt()
    val b3 = n2 as? Double

    val obj = SomeObject.a
    val dataCls = SomeDataClass(5)

    var kls: SomeClass? = null
    print("$string $n3 $bol $nul $b $b2 $b3 $kls $obj $dataCls")
    kls = SomeClass()
    val bool = genericFunc(t = 1, other = 2) { x, y -> x == y }
    print("$bool")

    with(kls) { pubVar?.apply { extensionFunc() } }

    val map = mapOf("a" to 1, "b" to 2, "c" to 3)
    val mutSet: MutableSet<String> = HashSet()
    val letters = listOf("a", "b", "c")

    val lambda = { x: Int -> x * x }

    if (n1 > (kls.pubVar ?: 1)) {
        print(lambda(map["a"] ?: 1))
    } else {
        print(mutSet.contains("a"))
    }
    val argAsAny = arg as Any
    println(argAsAny)
    when (argAsAny) {
        1 -> print("")
        "text" -> print("")
        is String -> print("")
        else -> print("")
    }

    for (letter in letters) {
        print(letter)
    }
    for (i in 0..4) { print(i) }
    for (i in 4 downTo 0 step 2) { print(i) }
    while (false) { print(1) }
    letters
        .filter label@{
            if (it.startsWith("a")) {
                true
            } else {
                return@label false
            }
        }
        .forEach {
            print(it)
        }

    try {
        throw Exception("msg")
    } catch (e: Exception) {
        print("")
    } finally {}
}
