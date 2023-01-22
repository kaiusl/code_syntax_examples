"use strict"

import { func_test2 as ftest2 } from './test2.js'
import * as t2 from './test2.js'
import React from 'react'

// JSX specific

let v1 = 5;
const elem = <h1>heading {v1}, {23}</h1>;
const elem2 = <a href="afs" onClick={ftest2}>asd saf  {elem}</a>

class NewHeading extends React.Component {
    render() {
        return <h1>{this.props.text}</h1>;
    }
}

const user_elem = <NewHeading text="sa"></NewHeading>

// Regular JS
ftest2()
t2.func_test2()

// comment
/*comment*/

var n1 = 5;
let n2 = 5.0;
let n3 = 10n;
const A3 = "sa ${a1}";
let a4 = 's\na\x12';
let a5 = `sa ${n1 + n2}`;
let arr = [1, 3, NaN]
let bol = true || 1 < 4;
let bol2 = true ? "fas" : 5;
let bol3 = bol2 ?? true;
let undef = undefined;
let ty = typeof A3;
let ty2 = typeof (1 + 2);
let sym = Symbol("as");
let a6 = new String(n1);

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
    continue;
}

arr.forEach(n => n ** 2)

// functions

/**
 * 
 * @param {number} param 
 * @returns 
 */
export function func1(param, p2 = 5, p3 = func1(5), ...args) {
    let a = n1 + n2 - arr[0] ** arr[1] + p2

    alert(param)
    return 0
}
let func2 = function (param, p2 = 5, p3 = func2(5)) {
    return 0
};
let func3 = (p1, p2) => p1 * p2;
let func4 = new Function("a", "return 0")

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
let f4 = func4(1)

// Objects

function ConstructorFunc(a) {
    this.a = a
}

class SomeBaseClass {
    constructor(v) {
        this.v = v
    }

    func() {
        return this.v
    }

    static func_static() { }

    static get [Symbol.species]() {
        return 5
    }
}

class SomeClass extends SomeBaseClass {
    constructor(v) {
        super(v)
    }

    func() {
        super.func()
    }
}

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

let a_obj = new ConstructorFunc()
a_obj[Symbol.iterator] = function () {
    return {
        next() {
            return null
        }
    }
}

let k = new SomeBaseClass("saf")
k.func()
k.v;
let b = SomeClass instanceof SomeBaseClass;

// Misc

test.exports = {
    n1,
    SomeClass: SomeClass,
    gen: generator,
}

throw new Error("msg")
