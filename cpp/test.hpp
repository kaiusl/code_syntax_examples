#pragma once

#include <concepts>
#include <iostream>
#include <vector>

#include "other_header.hpp"

#if 0
#define log(x)
#else
#define log(x)
#endif

using Kls = test::Klass;

// comment
/* comment */

int global_var = 5;
const int const_global_var = 5;
constexpr int constexpr_global_var = 5;
static int static_global_var = 5;

// user defined literal suffix
long double operator"" _abc(long double);

void func() {
    bool bool_ = true || !false && 1 < 2 && 1 > 2 && 1 == 2 && 1 != 2 &&
                             1 <= 2 && 1 >= 2;
    int bitwise = 1 & 2 | 3 ^ ~4 << 2 >> 2;
    int int_ = 1 + (int)1u - 0x1234 * 0b1000 + static_cast<int>(1.0);
    int_++;
    int8_t int8 = 1;
    double double_ = 1.0 / (double)1.0f + 1.1e1 + 1e-1 + 1E+1 + 0x1p1 + 1.2_abc;
    double *double_pointer = &double_;
    double deref = *double_pointer;
    double &double_ref = double_;
    char *msg = nullptr;
    const char *const msg = nullptr;
    char *msg = NULL;
    char *msg[] = {"abc", "abc\n\u1234"};
    auto strs =
        ("abc\n", L"abc\n", u8"abc\n", u"abc\n", U"abc\n", R"-(abc\n)-");
    unsigned char chars[] = {'a', '\n', '\123', '\x12'};
    auto chars2 = ('a', L'a', u8'a', u'a', U'a');
    std::vector<int> v{1, 2, 3};
    typeid(v);
    sizeof v;
    sizeof(v);
    delete[] msg;

    auto lambda = [=](int i) { return i * i; };

    COLUMN col = 5;

    SomeStruct struct_ = SomeStruct();
    struct_.const_func();
    struct_.static_func();
    SomeStruct::static_func();
    struct_.member_func();
    struct_.virtual_func();
    struct_.const_var;
    struct_.instance_var;
    struct_.static_var;
    SomeStruct::static_var;

    SomeClass class_ = SomeClass(std::string("abc"));
    SomeClass::static_func();
    SomeClass::static_var;
    class_.func();
    class_.func2("a", &int_);

    SomeEnum enum_ = SomeEnum::A;
    LetterEnumClass enum_ = LetterEnumClass::A;
    SomeUnion union_;
    union_.int_ = 5;

    // Control flow
    if (true) {
    } else if (false) {
    } else {
    }

    switch (1) {
        case 1:
            break;
        default:
            break;
    }
    auto ternary = 1 < 2 ? 1 : 2;

    try {
        throw std::overflow_error("msg");
    } catch (const std::exception &e) {
    } catch (...) {
    }

    // loops
    int i = 0;
    while (i < 5) {
        for (int j = 0; j < 5; j++) {
            if (j < 3) {
                break;
            }
        }
        for (auto &&i : v) {
        }
        i++;
        continue;
    }
    do {
        i++;
    } while (i < 5);

    if (true) {
        goto label;
    }
label:

    // misc
    std::cout << double_ << std::endl;
    template_func({1, 2, 3});
}

typedef int COLUMN;

struct alignas(8) S {};

/**
 * @brief short descrption
 *
 * abc @c inline_code
 * @param param
 */
struct [[nodiscard]] SomeStruct {
  public:
    const int const_var = 5;
    int instance_var;
    static int static_var;

    std::vector<int> ints;

    SomeStruct() : instance_var(5) {
        static_var = 5;
        this->ints.push_back(5);
    }
    ~SomeStruct() {}
    SomeStruct(const SomeStruct &) = default;
    SomeStruct(SomeStruct &&) = default;

    SomeStruct &operator=(const SomeStruct &) = default;
    SomeStruct &operator=(SomeStruct &&) = default;

    constexpr int const_func() noexcept { return const_var; }
    static int static_func() { return static_var; }
    int member_func() const { return instance_var; }
    virtual void virtual_func(){};
    friend void friend_func(){};

  private:
    bool bol;
    int arr[4];
    LetterEnumClass en = LetterEnumClass::A;

    int private_func();
};

class SomeClass : public SomeStruct {
  public:
    std::string str;
    SomeClass(std::string s = "abc") : SomeStruct(), str(s) {}
    SomeClass(const SomeClass &) = default;
    SomeClass(SomeClass &&) = default;

    SomeClass &operator=(const SomeClass &) = default;
    SomeClass &operator=(SomeClass &&) = default;

    inline const void func() const {};
    static int func2(const std::string &str, int *i){};
    void virtual_func() override {}
};

enum SomeEnum { A, B };

enum class LetterEnumClass : int { A, B, C };

union SomeUnion {
    int int_;
    float float_;
};

template <class T, unsigned S>
std::string template_func(const T (&v)[S]) {
    return std::to_string(v[0]);
}

// Concepts
template <class T, class U>
concept Derived = std::is_base_of<U, T>::value;

template <Derived<SomeStruct> T>
void f() {}

template <class T>
    requires Derived<T, SomeStruct>
void f(){};
