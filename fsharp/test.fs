open System

module modd =
    let func param = printfn $"Hello {param}"

let func2 (a: string) (b: int) = printfn ""

let genericfunc<'a, 'b> (x: 'a) (y: 'b) = printfn "%A %A" x y

let exists (x: int option) =
    match x with
    | Some(x) -> true
    | None -> false

type SomeInterface =
   abstract member InterfaceFunc : unit -> unit

type Point = { X: int; mutable Y: int }

[<Struct>]
type Point3D =
    struct
        val x: float
        val y: float
        val z: float
    end

type SomeClass(a) =
    let field = a
    do printfn "%d" field
    member this.memberField = a
    static member staticMember = "member val"
    member this.MemberFunc(parameter: float) = parameter + (float) field
    interface SomeInterface with
        member this.InterfaceFunc() = printfn "%d" field

type LetterEnum<'a> =
    | A of char: string
    | B of 'a * string

// type constraints
type SomeGenericClass<'T when 
    'T :> SomeClass System.IComparable and
    'T: not struct and
    'T: (member field: int)
> = { a: int }

[<Literal>]
let Three = 3

[<EntryPoint>]
let main argv =
    modd.func "param"
    let msg: string = "f \n asf"
    let msg2 = $"abc {msg}"
    let a: String = "fas"
    printfn "Hello world %s" msg

    let i, j, k = (1, 2, 3)
    let a1 = "abc\nf"
    let a2 = $"#{a1:F5}"
    let a3 = @"a\s\nf"
    let a4 = 'b'

    let a5 =
        """
        abc "abc" abc
    """

    let mutable amut = $"abc {{}} {a1, 10}"
    let a = $"abc %.2f{2.4}"
    let a = $"""abc {"abc"}"""
    let b1 = 1
    let b = 1u
    let b3: int = 0x1_2_3
    amut <- "fasf"
    let c = &a

    let kls = SomeClass(5)
    let a = SomeClass.staticMember
    let b = kls.MemberFunc 1.5 + (float)kls.memberField

    let a =
        if true then "a"
        elif false then "a"
        else "a"

    let arr = [| 1..100 |]
    let mutable sum = 0
    let lambda_accumulate = fun x -> sum <- sum + x;
    lambda_accumulate 1
    1 |> lambda_accumulate

    let q =
        query {
            for i in arr do
                select i
        }

    let filter x =
        match x with
        | 1
        | 2
        | Three -> printfn "a"
        | var1 -> printfn "%d" var1

    for x in 1..10 do
        filter x

    let a = LetterEnum.A(char = "a")
    let a = LetterEnum.B(5, "b")

    do modd.func ()

    0
