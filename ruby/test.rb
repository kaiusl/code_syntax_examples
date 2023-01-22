pi = Math::PI

# comment
=begin
    comment
=end

a = "alocal\n"
a = %|abc|
a = :sym
$aglob = "aglob #{a}"
ACONST = "aconst"
@ainstance = "ainstance"
regex = /\d*\w+/

b = 1, 0x1234, 0b1000, 10.0, 1.0e6
c = true || false && 5 <= 6
d = 5 < 6 ? true : false

scope = defined? a
a.class

module TestMod
    def func(a, b, *args)
        p a
        c = b + 1 + 2 - 3 / 4 * 5 % 6
        args.each { |a| puts a }
        args.each do |a| puts a end
        return c
    end
    alias funcalias func
end
include TestMod

func "no_braces", 2, 3, 4
TestMod::funcalias(1, 2, 3, 4)

lam = lambda { puts "f" } 
lam2 = -> (arg) { puts arg }
lam.call
lam2.(5)

for i in 0..5
end

arr = Array.new(5, "a")
arr.sort!
arr[1..3]

map = {
    "a" => "map - a",
    "b" => "map - b"
}
puts map['a']
map2 = {
    a: "map2 - a",
    b: "map2 - b"
}
puts map2[:a]
map3 = Hash["a" => "map3 - a", "b" => "map3 - b"]
puts map3["a"]

case 5 
when 0..1
    "abc"
else "def"
end

class Class
    @@acls = "abc"
    @aloc = "abc"

    def b
        @b
    end

    private

    def b=(v)
        @b = v
    end 

    public

    def initialize(a)
        @a = a
        self.func
    end

    def func
        puts "a = #{@a}"
    end

    def self.clsfunc
        return "class func"
    end

    class << self
        private

        def other_cls_func
            return "class func2"
        end

        public :other_cls_func
    end
end

g = Class.new("abc")
g.func
g.b
puts Class.clsfunc
puts Class.other_cls_func

class Class2
end

class Class3 < Class2
end

i = 0
while i < 5 do 
    i += 1
    break if i == 1
end

puts $!

begin
    fail
rescue
ensure
end

