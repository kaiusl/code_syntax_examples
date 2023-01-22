//extern alias A;

using System.Diagnostics;
using System.Runtime.InteropServices;
using M = System.Math;
using D = System.Diagnostics;
using NamespaceA.SubNamespace;

using ClassAlias = NamespaceA.SubNamespace.SomeClass<int>;

#region region name
#endregion

#nullable enable
#if true 
#endif

// comment
/* also comment */

const int ConstGlobalVar = 5;
int GlobalVar = 5;

void func<T>(ref T t) {
    GlobalVar += ConstGlobalVar;
    int[] ints = new int[] { 1, (int)1u, 0x123, 0b100, };
    var doubles = new double[] { 1.0, (double)2.0f, 2e1, 2e-1, 2E+1, 0x123, 0b100 };
    dynamic strings = ("abc", "abc\n\u1234", @"abc\n\u1234", $"#{doubles[0]:.2f}");
    var raw_string = """
        abc
        abc
    """;
    raw_string = """""
                abc """" abc 
                """"abc
            """"";
    raw_string = $$"""{abc {{strings[0]:-^10}}}""";
    var chars = ('a', '\n');
    var @bool = true
        && !false
        || 1 < 2
        & 1 > 2
        | 1 == 2
        ^ 1 != 2
        | 1 <= 2
        | 1 >= 2
        << 1 >> 1 >>> 1
        | strings is int;
    double? nullable = ints[0] as double?;

    var size = sizeof(char);
    var size2 = typeof(char);

    int[,] multi_dim_arr = new int[1, 1];

    IEnumerable<int> type_erased_query = from int_ in ints where int_ > 50 select int_;
    Func<int, int> lambda = x => x * x;
    SomeDelegate<int> delegate_ = delegate (int x) {
        return x * x;
    };
    delegate_.Invoke(1);

    SomeEnum someenum = SomeEnum.A | SomeEnum.B;
    var cls = new SomeClass<int>();
    var a = (
        SomeClass<int>.ConstVar,
        SomeClass<int>.StaticVar,
        cls.ReadonlyVar,
        cls.Field,
        cls.Prop,
        SomeClass<int>.StaticProp,
        cls[1],
        cls + new SomeClass<int>(5)
    );
    cls.InterfaceFunc();
    SomeClass<int>.InterfaceStaticFunc();
    ClassAlias.StaticFunc(1);
    cls.Func();
    cls.SomeEvent += (i) => { return i; };

    // Control flow
    if (@bool) { } else if (true) { } else { }

    var ternary = ints[0] < 2 ? 2 : 1;

    switch (chars) {
        case ('a', 'b') when true:
            break;
        case ('b', _):
            break;
        default:
            break;
    }

    try {
        throw new Exception("msg");
    } catch (Exception e) { } finally { }

    // Loops

    var i = 0;
    while (i < 5) {
        for (int j = 0; j < 5; j++) {
            if (j < 3) {
                break;
            }
        }
        i++;
        continue;
    }

    foreach (var int_ in ints) { }


    IEnumerable<int> type_erased_query2 = from int_ in ints where int_ > 50 select int_;
    int number = ints.Select(i => i).Aggregate((acc, i) => acc += i);


    // misc

    if (@bool) {
        goto label;
    }
label:

    Console.WriteLine("Hello, World!");


    lock (ints) {
        checked { ints[0]++; }
        unchecked { ints[0]--; }
    }
}

async Task<int> async_func() {
    var value = await Task.Run(() => 5);
    return value;
};

namespace NamespaceA.SubNamespace {
    [Flags]
    public enum SomeEnum {
        A = 0,
        B,
    }

    interface ISomeInterface {
        public const int InterfaceConstVar = 5;
        public static int InterfaceStaticVar = 5;

        abstract void InterfaceFunc();
        abstract static void InterfaceStaticFunc();
    }

    public delegate int SomeDelegate<out T>(int i);

    abstract class BaseClass { }

    /// <summary>
    /// summary <paramref name="to"> <code> Klass<T></code>
    /// </summary>
    /// <typeparam name="T"></typeparam>
    class SomeClass<T> : BaseClass, ISomeInterface, IDisposable {
        // fields
        private int _privVar = 5;
        protected int ProtectedVar = 5;
        public const int ConstVar = 5;
        public static int? StaticVar = null;
        public readonly int ReadonlyVar = 5;
        internal int Field = 5;
        // properties
        private int _PrivateProp { get; set; } = 5;
        protected int ProtectedProp { get; private set; } = 5;
        public static int StaticProp { get => StaticVar ?? 1; private set => StaticVar = value; }
        public int Prop { get { return 5; } set { _privVar = 5; } }

        // delegate and event
        public event SomeDelegate<int>? SomeEvent;

        private T[] _data = new T[1];

        public SomeClass(T def = default(T)) {
            _data[0] = def;
            var a = _privVar
                + this.ProtectedVar
                + ConstVar
                + StaticVar
                + ReadonlyVar
                + Field
                + _PrivateProp
                + ProtectedProp
                + StaticProp;

        }
        ~SomeClass() { }

        public T this[int i] {
            get => _data[i];
            set => this._data[i] = value;
        }

        [method: Conditional("DEBUG")]
        public static void StaticFunc([In] int i) { }
        public int Func() => 3;
        void IDisposable.Dispose() { }
        public void InterfaceFunc() { }
        public static void InterfaceStaticFunc() { }
        public static SomeClass<T> operator +(SomeClass<T> a, SomeClass<T> b) {
            return a;
        }
    }

    // Custom attribute
    [System.AttributeUsage(System.AttributeTargets.Method)]
    public class CustomAttribute : System.Attribute {
        private bool value;
        public CustomAttribute(bool value) {
            this.value = value;
        }
    }
}
