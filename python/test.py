from abc import abstractmethod
from dataclasses import dataclass
import dataclasses
from typing import Union
import numpy as np
import os
from enum import Enum
import re

"""
doc comment in wrong place
"""
# comment

CONST = 5
regular_var = 4
_drop = 4

string = "abc\n\u1234&lt;"
string: str = 'abc\n\u1234&lt;'
old_style_template = "abc %s %.2f" % ("s\"f", 3.3)
old_style_template = 'abc %s %.2f' % ('s\"f', 3.3)
fstr = f"{string} {{}} {3.6:a^10.2f}"
fstr = f'{string} {{}} {3.6:a^10.2f}'
rawstr = r"abc"
rawstr = r'abc'
bytestr = b"abc\x12\123"
bytestr = b'abc\x12\123'
multilinestr = f"""
    abc
    {string}
abc
"""
multilinestr = f'''
    abc
    {string}
abc
'''

regex = re.compile(r"\d*[abc]+")

nums = 1 + 0x1234 - 0b1000 * 0o1234 / 1e6 // 1.0E+3 % 1.0e-1 ** 1.0
nums += 1
nums -= 1
nums *= 1
nums /= 1
nums %= 1
nums **= 1
nums = abs(nums)

boolean = (True
           or False
           and 1 == 1
           or 1 != 1
           or not 1 < 1
           or 1 > 1
           or 1 <= 1
           or 1 >= 1
           or 1 in [1, 2]
           or "a" is str
           or isinstance(nums, float)
           )

list_ = [1, 2, 3]
list_ = list([1, 2, 3])
tuple_ = (1, 2, 3)
tuple_ = tuple([1, 2, 3])
set_ = {1, 2, 3}
set_ = set([1, 2, 3])
dict_ = {
    1: 1,
    2: 2,
    3: 3
}
dict_ = dict(a=1, b=2, c=3)
dict_ = dict([(1, 1), (2, 2), (3, 3)])

first = list_[0]
list_access = (
    list_[0],
    list_[1:],
    list_[::-1]
)
first = tuple_[0]
first = dict_[0]

list_comprehension = [x ** 2 for x in range(5) if x < 4]
tuple_comprehension = (x ** 2 for x in range(5) if x < 4)
set_comprehension = {x ** 2 for x in range(5) if x < 4}
dict_comprehension = {x ** 2: 2 for x in range(5) if x < 4}


def square(x):
    return x * x


square_lambda = lambda x: x * x
square_fn = square

one, two = 1, 2
if one < two:
    pass
elif one > two:
    pass
else:
    pass

ternary = 2 if 1 < 2 else 3


class Point:
    x: int = 1
    y: int = 2


class Color(Enum):
    RED = 0
    GREEN = 1
    BLUE = 2


match nums:
    case 1:
        pass
    case 2 | 3 | 4:
        pass
    case (5, 6) | [5, 6]:
        pass
    case [9, *tail]:
        pass
    case Point(x, y) if x == 1:
        pass
    case Point(x=1, y=2):
        pass
    case Color.RED:
        pass
    case _:
        pass

i = 0
while i < 5:
    for j in range(5):
        if j < 4:
            break
    else:
        break

    i += 1
    continue

try:
    raise Exception
except Exception:
    pass
finally:
    pass

with open("filename") as f:
    pass

global_var = 1


def func(param: Union[int, str]) -> None:
    """
    this is a doc 
    @param param variable

    Parameters
    ----------
    var: `str` or `ìnt`
    """
    global global_var

    local_var = 5
    global_var = local_var + param


func(1)
func(param="abc")


def custom_func_decorator(a, b):
    def returned_func(func_inner):
        def wrapper_func(*args, **kwargs):
            print(a, b)
            return func_inner(*args, **kwargs)

        return wrapper_func

    return returned_func


@dataclass(init=False)
class SomeClass:
    r"""
    raw doc comment
    """

    property_ = 1.87
    other_property = np.linspace(0, 1, 100)
    integer: int = dataclasses.field(default=1)

    def __init__(self, name: str = "abc") -> None:
        self.name = name

    @custom_func_decorator(15, "abc")
    def func(self):
        x = self.other_property[..., 0]
        print(f"{self.property_} {{{x}}} {3.6546:.2f}")


class SomeSubClass2(SomeClass):
    def __init__(self, name: str) -> None:
        if name is None: name = "name"
        super().__init__(name)

    def func(self):
        print(f"{self.name}")

    @classmethod
    def classmethod(cls):
        for j in range(5):
            if j % 2 == 0:
                print(j)

    @staticmethod
    def staticmethod():
        return 1 + 1.1e1


class_ = SomeSubClass2("name")
SomeSubClass2.staticmethod()
SomeSubClass2.classmethod()
class_.func()
