package com.algorithm_questions_visualizer.ui.screens

fun twoSum(numbers: IntArray, target: Int): IntArray? {
    val map = hashMapOf<Int, Int>()
    numbers.forEachIndexed { index, value ->
        val complement = target - value
        if (map.containsKey(complement))
            return intArrayOf(map[complement]!!, index)
        map[value] = index
    }
    return null
}