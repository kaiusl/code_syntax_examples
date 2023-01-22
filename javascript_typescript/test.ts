"use strict"

import { func_test2 as ftest2 } from './test2.js'
import * as t2 from './test2.js'

ftest2()
t2.func_test2()

// comment
/*comment*/

var n1 = 5;
let n2: number = 5.0;
let n3 = 10n;
let n4 = 10 as number;
let n5 = <number>10
const A3: string = "sa ${a1}";
let a4 = 's\na\x12';
let a5 = `sa ${n1 + n2}`;
let arr: Array<number> = [1, 3, NaN]
let bol: boolean = true || 1 < 4;
let bol2 = true ? "fas" : 5;
let bol3 = bol2 ?? true;
let undef = undefined;
let ty = typeof A3;
let ty2 = typeof (1 + 2);
let sym = Symbol("as");
let a6 = String(n1);

// control flow

let v = 5;
switch (v) {
    case 1:
        break;
    case 5:
        break;
    default:
        break;
}

// loops


while (false) { }

do {
    break
} while (false)

label: for (let i = 0; i < 5; i++) {
    while (i == 0) {
        break label;
    }
}

arr.forEach(n => n ** 2)

// functions

type OneOrMore<T> = T | T[]
type Kls = keyof SomeBaseClass

/**
 * 
 * @param {number} param 
 * @returns 
 */
export function func1(param?: number, p2 = 5, p3 = func1(5), ...args): number {
    let a = n1 + n2 - arr[0] ** arr[1] + p2

    alert(param)
    return 0
}

let func2 = function (param: OneOrMore<number>, p2 = 5, p3 = func1(5)) {
    return param
};

let func3 = (p1, p2) => p1 * p2;
let func4 = new Function("a", "return 0")
let func5 = function (): 0 | 1 | SomeEnum.A {
    return SomeEnum.A
}

function generic_func<T extends { a: unknown }>(t: T) {

}

async function async_func() {
    return 0
}

async function async_func2() {
    return await async_func()
}

function* generator() {
    yield 1;
    return 2;
}

let f1 = func1(6)
let f2 = func2(5, 3, 7)
let f3 = func3(1, 2)

// objects

function ConstructorFunc(a) {
    this.a = a
}

enum SomeEnum {
    A,
    B,
    C
}

const enum SomeConstEnum {
    A,
    B,
    C
}

interface SomeInterface {
    a: number,

    func(): void
}

class SomeBaseClass implements SomeInterface {
    public v!: number
    readonly r: SomeEnum
    a: number
    constructor(v) {
        this.v = v
    }

    func() {
    }

    static func_static() {

    }

    static get [Symbol.species]() {
        return 5
    }
}

class SomeClass extends SomeBaseClass {
    constructor(v) {
        super(v)
    }

    func(): void {
        console.log("abc")
    }

    func2() {
        super.func()
    }
}

let b = SomeClass instanceof SomeBaseClass;


let object = new Object();
let object_clone = Object.assign({}, object)
object["f"] = "abc"
let propname = "s";
let other_object = {
    prop1: 1,
    prop2: 2,
    "a b": null,
    [propname]: true,
    return: 4,
    let: 5,

    get get_prop2() {
        return this.get_prop2
    },

    object_func() { this.let }
}
let p1 = other_object?.prop1;
delete other_object["some_prop"];
let _ = "s" in object;
let p2 = other_object.object_func()
for (let a in other_object) { }

let a_obj = new ConstructorFunc(5)
a_obj[Symbol.iterator] = function () {
    return {
        next() {
            return null
        }
    }
}

let k = new SomeBaseClass("saf")
k.func()
SomeBaseClass.func_static()
k.v;

if ("func" in SomeBaseClass) { }


test.exports = {
    n1,
    SomeClass,
    generator,
}

throw new Error("msg")

