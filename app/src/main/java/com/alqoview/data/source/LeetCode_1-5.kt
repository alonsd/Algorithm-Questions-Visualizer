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
            coreConcepts = listOf(
                AlgorithmicProblem.Solution.Explanation.CoreConcept(
                    "Compliment", "Compliment, from the word 'completion' is the number that we" +
                            " are missing in each iteration in order to find the desired target number."
                )
            ),
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
            bestApproach = "Elementary Math",
            coreConcepts = listOf(
                AlgorithmicProblem.Solution.Explanation.CoreConcept(
                    "Least Significant Digit",
                    "When combining 2 numbers, we start from right to left of each number. Each time, we all the most right digit of the first number to the " +
                            "most right number of the second number. For each iteration of doing that, we are combining digits that are considered the " +
                            "least significant ones, because their numbers effect the least compared to their left digits which will come next.\n" +
                            "For example: 24 + 73 = 97. We are starting by adding 4 and 3 which are the least significant digits, then we continue to add 2 and 7. " +
                            "Things will get complicated when a least significant digits sums at each iteration will pass 10, making us need to use a carry."
                ),
                AlgorithmicProblem.Solution.Explanation.CoreConcept(
                    "Carry",
                    "What happens in the previous concept when we need to sum the following numbers - 27 + 78 = 105 ? This is where we need to use a carry." +
                            "Carry is the remainder of a calculation for each iteration, therefore it can only be 0 or 1. Why? " +
                            "because the maximum calculation we do for each least significant digit is 9+9 which is 18, or we can get a result that is less than 10, which means our carry is 0."
                ),
                AlgorithmicProblem.Solution.Explanation.CoreConcept(
                    "Head/Tail Swapping",
                    "When building a new LinkedList 'head' that will represents our result in an iterative way, we need to update heads 'next' value each iteration." +
                            " In order to achieve such behavior, we create a new tail node called 'current' that will initially take the same pointer of 'head' but will be the one responsible " +
                            "for assigning new values to it's 'next' value instead of 'head' variable, allowing us to return 'head' at the end of the algorithm with all of the 'next' values that " +
                            "we have calculated."

                ),
            ),
            explanationDescription = "Just like how you would sum two numbers on a piece of paper, we begin by summing the least-significant digits, which is the heads of l1 and l2." +
                    " Since each digit is in the range of 0 to 9, summing two digits may \"overflow\" as we explained in the first core concept." +
                    " For example 5 + 7 = 12 - in this case, we set the current digit to 2 and bring over the carry with a value of 1 to the next iteration.",
            timeComplexity = "O(max(m,n))\nAssume that m and n represents the length of l1 and l2 respectively, the algorithm above iterates at most max(m,n) times.",
            spaceComplexity = "O(max(m,n)).\nThe length of the new list is at most max(m,n)+1."
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
val leetcode3 = AlgorithmicProblem(
    problemId = 3,
    questionNumber = 3,
    title = "Longest Substring Without Repeating Characters",
    problemDescription = "Given a string s, find the length of the longest \n" +
            "substring\n" +
            " without repeating characters. A substring is a contiguous non-empty sequence of characters within a string.",
    solution = AlgorithmicProblem.Solution(
        solutionCode =
        "fun lengthOfLongestSubstring(string: String): Int { \n" +
                "        val charToIndexMap = hashMapOf<Char, Int>() \n" +
                "        var result = 0 \n" +
                "        //Window starts from 0,1 because window represents the length of our result \n" +
                "        var slidingWindowLeftSide = 0 \n" +
                "        var slidingWindowRightSide = 1 \n" +
                "        string.forEach { char -> \n" +
                "            if (charToIndexMap.containsKey(char)) { \n" +
                "                // Since we are iterating and constantly updating the left window side, the  \n" +
                "                // correct answer could be  either one of the index of the current char already  \n" +
                "                // visited or the current position of the sliding window left side. \n" +
                "                slidingWindowLeftSide = max(charToIndexMap[char]!!, slidingWindowLeftSide) \n" +
                "            } \n" +
                "            val currentWindow = slidingWindowRightSide - slidingWindowLeftSide \n" +
                "            // Same as before - iterating while updating. The current window is not guaranteed to be  \n" +
                "            // bigger than the last result saved \n" +
                "            result = max(result, currentWindow) \n" +
                "            charToIndexMap[char] = slidingWindowRightSide \n" +
                "            slidingWindowRightSide++ \n" +
                "        } \n" +
                "        return result \n" +
                "    }",
        explanation = AlgorithmicProblem.Solution.Explanation(
            bestApproach = "Optimized Sliding Window",
            coreConcepts = listOf(
                AlgorithmicProblem.Solution.Explanation.CoreConcept(
                    "Substring",
                    "A substring is a contiguous non-empty sequence of characters within a string.\n" +
                            "For example, given a string \"fast car\" the word \"fast\" is a substring. Note that for this specific " +
                            "problem, we are looking for a substring without repeating characters, therefore the result for the string \"abcabcab\" " +
                            "for this problem will be 3 - \"abc\"."
                ),
                AlgorithmicProblem.Solution.Explanation.CoreConcept(
                    "Iterating and changing values via max() function",
                    "We are using the max() function 2 times in this solution. The concept is to update the needed value firstly by" +
                            " a new value than it's initial 0, and from there going on we are not sure that the new value that we got will be bigger than " +
                            "what we already recorded."
                ),
                AlgorithmicProblem.Solution.Explanation.CoreConcept(
                    "Sliding Window",
                    "Sliding window is a method used to solve array or lists related problems. Iterating from left to right, we " +
                            "\"open\" the window to the right side and \"close\" the window to the left side when needed, giving us the solution we need."
                ),
            ),
            explanationDescription = "Since we are looking for a substring without repeating characters, we can iterate through the string and " +
                    "record a map of char : position. Each time we see a char that we have already recorded in our map, we update 2 values:\n" +
                    "1 - The window's left side as the max between the current window left side value and the index of the same char\n" +
                    "2 - The problem's result to be the max value between the current result and the current window, which is the right - left",
            timeComplexity = "O(n)\n We iterate through the entire string and in the worst case fill the map with all of the chars.",
            spaceComplexity = "O(min(n,m))\n We iterate through the entire string, filling the map entirely in the worst case - meaning" +
                    "a complexity of O(n). We also need to consider the charset/alphabet we are using, meaning another complexity of" +
                    "O(m). Therefor, we chose the minimum between n and m."
        )
    ),
    examples = listOf(
        AlgorithmicProblem.Example(
            input = "s = \"abcabcbb\"",
            output = "3",
            explanation = "The answer is \"abc\", with the length of 3."
        ),
        AlgorithmicProblem.Example(
            input = "s = \"bbbbb\"",
            output = "1",
            explanation = "The answer is \"b\", with the length of 1."

        ),
        AlgorithmicProblem.Example(
            input = "s = \"pwwkew\"",
            output = "3",
            explanation = "The answer is \"wke\", with the length of 3.\n" +
                    "Notice that the answer must be a substring, \"pwke\" is a subsequence and not a substring."
        ),
    ),
    source = AlgorithmicProblem.Source.LEETCODE,
    difficulty = AlgorithmicProblem.Difficulty.MEDIUM
)
val leetcode4 = AlgorithmicProblem(
    problemId = 4,
    questionNumber = 4,
    title = "Median of Two Sorted Arrays",
    problemDescription = "Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays." +
            "The overall run time complexity should be O(log (m+n)).",
    solution = AlgorithmicProblem.Solution(
        solutionCode =
        "",
        explanation = AlgorithmicProblem.Solution.Explanation(
            bestApproach = "",
            coreConcepts = listOf(
                AlgorithmicProblem.Solution.Explanation.CoreConcept(
                    "",
                    ""
                ),
            ),
            explanationDescription = "",
            spaceComplexity = "",
            timeComplexity = ""
        )
    ),
    examples = listOf(
        AlgorithmicProblem.Example(
            input = "nums1 = [1,3], nums2 = [2]",
            output = "2.00000",
            explanation = "merged array = [1,2,3] and median is 2."
        ),
        AlgorithmicProblem.Example(
            input = "nums1 = [1,2], nums2 = [3,4]",
            output = "2.50000",
            explanation = "merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.    "

        ),
    ),
    source = AlgorithmicProblem.Source.LEETCODE,
    difficulty = AlgorithmicProblem.Difficulty.HARD
)
