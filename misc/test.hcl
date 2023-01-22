/*
comment
*/
# another comment
// another 

nums = [1, 1.111, 1e+1, 1.1e1]
strs = ["abc", """abc""", "\n\u1234&lt;"]
bool = [true, false]
date = "1999-01-23"
time = ["22:22:22", "22:22:22.2222"]
datetimes = [
  "1999-01-23T22:22:22.22Z",
  "1999-01-23 22:22:22.22",
  "1999-01-23 22:22:22.22-01:00",
]
arr = [[], [[]]]
tup = (1, 2)
map = { a = 1, b = 2 }


str = "saf"
interpolated = "s ${str}"
num = 1.3
num2 = 1.3e+5 + num
lit = true == false || null
func = upper(interpolated)
tern = true ? "true" : "false"
nested = "${func("${num2}/value")}"

rules {
  rule "a" "b" {
    v1 = 5,
    (str) = tern
  }
}