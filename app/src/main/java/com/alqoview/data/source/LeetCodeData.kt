package com.alqoview.data.source

import com.alqoview.model.AlgorithmicProblem

val leetcode1 = AlgorithmicProblem(
    problemId = 1,
    questionNumber = 1,
    title = "Two Sum",
    problemDescription = "Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.\n" +
            "\n" +
            "You may assume that each input would have exactly one solution, and you may not use the same element twice.\n" +
            "\n" +
            "You can return the answer in any order.",
    solution = AlgorithmicProblem.Solution(
        solutionCode = "fun twoSum(numbers: IntArray, target: Int): IntArray? { \n" +
                "        val map = hashMapOf<Int, Int>() \n" +
                "        numbers.forEachIndexed { index, value -> \n" +
                "            val complement = target - value \n" +
                "            if (map.containsKey(complement)) \n" +
                "                return intArrayOf(map[complement]!!, index) \n" +
                "            map[value] = index \n" +
                "        } \n" +
                "        return null \n" +
                "    }",
        explanation = AlgorithmicProblem.Solution.Explanation(
            bestApproach = "One-pass Hash Table",
            explanationDescription = "We can iterate through the array while inserting at each iteration the value(of the current iteration) to the index of the current iteration." +
                    "At each iteration, before we are inserting elements into the hash table, we also look back to check if current element's complement already exists in the hash table." +
                    "If it exists, we have found a solution and return the indices immediately. ",
            coreConcepts = listOf(AlgorithmicProblem.Solution.Explanation.CoreConcept("Compliment", "Compliment, from the word 'completion' is the number that we" +
                    " are missing in each iteration in order to find the desired target number.")),
            timeComplexity = "O(n).\nWe traverse the list containing n elements only once. Each lookup in the table costs only O(1) time.",
            spaceComplexity = "O(n).\nThe extra space required depends on the number of items stored in the hash table, which stores at most n elements."
        )
    ),
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
val leetcode2 = AlgorithmicProblem(
    problemId = 2,
    questionNumber = 2,
    title = "Add Two Numbers",
    problemDescription = "You are given two non-empty linked lists representing two non-negative integers." +
            " The digits are stored in reverse order, and each of their nodes contains a single digit." +
            " Add the two numbers and return the sum as a linked list. \n" +
            "\n" +
            "You may assume the two numbers do not contain any leading zero, except the number 0 itself.",
    solution = AlgorithmicProblem.Solution(
        solutionCode =
        "class ListNode(var `val`: Int) { \n" +
                "    var next: ListNode? = null \n" +
                "} \n\n" +
                "fun addTwoNumbers(list1: ListNode?, list2: ListNode?): ListNode? { \n" +
                "    var l1 = list1 \n" +
                "    var l2 = list2 \n" +
                "    val head = ListNode(0) \n" +
                "    var current = head \n" +
                "    var carry = 0 \n" +
                "    while (l1 != null || l2 != null || carry != 0) { \n" +
                "        val x = l1?.`val` ?: 0 \n" +
                "        val y = l2?.`val` ?: 0 \n" +
                "        val sum = carry + x + y \n" +
                "        carry = sum / 10 \n" +
                "        current.next = ListNode(sum % 10) \n" +
                "        current = current.next!! \n" +
                "        if (l1 != null) { \n" +
                "            l1 = l1.next \n" +
                "        } \n" +
                "        if (l2 != null) { \n" +
                "            l2 = l2.next \n" +
                "        } \n" +
                "    } \n" +
                "    return head.next \n" +
                "}",
        explanation = AlgorithmicProblem.Solution.Explanation(
            bestApproach = "",
            explanationDescription = "",
            coreConcepts = listOf(AlgorithmicProblem.Solution.Explanation.CoreConcept("", "")),
            timeComplexity = "",
            spaceComplexity = ""
        )
    ),
    examples = listOf(
        AlgorithmicProblem.Example(
            input = "l1 = [2,4,3], l2 = [5,6,4]",
            output = "[7,0,8]",
            explanation = "342 + 465 = 807."
        ),
        AlgorithmicProblem.Example(
            input = "l1 = [0], l2 = [0]",
            output = "[0]"
        ),
        AlgorithmicProblem.Example(
            input = "l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]",
            output = "[8,9,9,9,0,0,0,1]"
        ),
    ),
    source = AlgorithmicProblem.Source.LEETCODE,
    difficulty = AlgorithmicProblem.Difficulty.MEDIUM
)

