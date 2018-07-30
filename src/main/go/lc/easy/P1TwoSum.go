package main

import (
	"fmt"
)

func main() {
	var input = []int{2, 7, 11, 15}
	var result = twoSum(input, 9)
	fmt.Println("input: ", input, ", output: ", result)

	input = []int{3, 2, 4}
	result = twoSum(input, 6)
	fmt.Println("input: ", input, ", output: ", result)
}

func twoSum(nums []int, target int) []int {
	m := make(map[int]int)

	for i, v := range nums {
		v2, prs := m[v]
		if prs {
			return []int{v2, i}
		} else {
			m[target-v] = i
		}
	}
	panic("not found")
}
