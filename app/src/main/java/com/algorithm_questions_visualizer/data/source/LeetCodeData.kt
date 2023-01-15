package com.algorithm_questions_visualizer.data.source

import com.algorithm_questions_visualizer.model.AlgorithmicProblem

val leetcode1 = AlgorithmicProblem(
    questionNumber = 1,
    title = "Two Sum",
    description = "Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.\n" +
            "\n" +
            "You may assume that each input would have exactly one solution, and you may not use the same element twice.\n" +
            "\n" +
            "You can return the answer in any order.",
    solution = "fun twoSum(numbers: IntArray, target: Int): IntArray? {\n" +
            "        val map = hashMapOf<Int, Int>()\n" +
            "        numbers.forEachIndexed { index, value ->\n" +
            "            val complement = target - value\n" +
            "            if (map.containsKey(complement))\n" +
            "                return intArrayOf(map[complement]!!, index) \n" +
            "            map[value] = index \n" +
            "        }\n" +
            "        return null\n" +
            "    }",
    examples = listOf(
        AlgorithmicProblem.Example(
            input = "nums = [2,7,11,15], target = 9",
            output = "[0,1]",
            explanation = "Because nums[0] + nums[1] == 9, we return [0, 1]."
        ),
        AlgorithmicProblem.Example(
            input = "nums = [2,7,11,15], target = 9",
            output = "[0,1]"
        ),
        AlgorithmicProblem.Example(
            input = "nums = [3,3], target = 6",
            output = "[0,1]"
        ),
    ),
    source = AlgorithmicProblem.Source.LEETCODE,
    difficulty = AlgorithmicProblem.Difficulty.EASY
)