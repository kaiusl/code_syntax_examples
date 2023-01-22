package main

import (
	"errors"
	"fmt"
)

func func1(regular_param string, pointer_param *int, fn_param func(int64) int64, channel_param chan int) (string, error) {
	if regular_param == "" {
		return "", errors.New("err")
	}
	return "sf", nil
}

func generic_func[K comparable, V int | float64](m map[K]V) float64 {
	return 0
}

type Number interface {
	int64 | float64
}

type Interface interface {
	Func() string
}

type SomeType[T Number] struct {
	Num T
}

// impl Interface
func (t SomeType[T]) Func() string { return "" }

func (t SomeType[T]) some_type_method() {}

func main() {
	var msg string
	msg = "af"
	msg2 := "f\nas"
	rune := 'f' | 'v'
	const n1 = 1
	_ = 1.5
	_ = true

	lst := []int{1, 2}
	var a int
	a = lst[0]
	_ = lst[0:3]

	mp := make(map[string]int)
	mp["a"] = 1
	mp["b"] = 2

	go generic_func(mp)

	for i := range msg {
		fmt.Println(i)
	}

	switch 2 {
	case 1:
		_ = "f"
	case 2:
		_ = "g"
	default:
		_ = "b"
	}

	type_ := SomeType[int64]{Num: 1}
	type_.Num = 3
	type_.some_type_method()

	lambda := func(a int64) int64 {
		return a
	}
	_ = lambda(43)

	var interface_instance Interface
	interface_instance = &type_

	fmt.Println(msg, msg2, a, rune, type_, interface_instance)
}
