package com.alqoview.data.source

import com.alqoview.model.AlgorithmicProblem

val leetcode26 = AlgorithmicProblem(
    problemId = 26,
    questionNumber = 26,
    title = "Remove Duplicates from Sorted Array",
    problemDescription = "Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.\n" +
            "\n" +
            "Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.\n" +
            "\n" +
            "Return k after placing the final result in the first k slots of nums.\n" +
            "\n" +
            "Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.\n\n" +
            "Custom Judge:\n" +
            "\n" +
            "The judge will test your solution with the following code:\n" +
            "\n" +
            "int[] nums = [...]; // Input array\n" +
            "int[] expectedNums = [...]; // The expected answer with correct length\n" +
            "\n" +
            "int k = removeDuplicates(nums); // Calls your implementation\n" +
            "\n" +
            "assert k == expectedNums.length;\n" +
            "for (int i = 0; i < k; i++) {\n" +
            "    assert nums[i] == expectedNums[i];\n" +
            "}\n" +
            "If all assertions pass, then your solution will be accepted.\n" +
            "\n",
    solution = AlgorithmicProblem.Solution(
        solutionCode = "",
        explanation = AlgorithmicProblem.Solution.Explanation(
            bestApproach = "",
            explanationDescription = "",
            coreConcepts = listOf(
                AlgorithmicProblem.Solution.Explanation.CoreConcept(
                    "", ""
                )
            ),
            timeComplexity = "",
            spaceComplexity = ""
        )
    ),
    examples = listOf(
        AlgorithmicProblem.Example(
            input = "nums = [1,1,2]",
            output = "2, nums = [1,2,_]",
            explanation = "Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.\n" +
                    "It does not matter what you leave beyond the returned k (hence they are underscores)."
        ),
        AlgorithmicProblem.Example(
            input = "nums = [0,0,1,1,1,2,2,3,3,4]",
            output = "5, nums = [0,1,2,3,4,_,_,_,_,_]",
            explanation = "Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.\n" +
                    "It does not matter what you leave beyond the returned k (hence they are underscores)."
        ),
    ),
    source = AlgorithmicProblem.Source.LEETCODE,
    difficulty = AlgorithmicProblem.Difficulty.EASY
)

val leetcode27 = AlgorithmicProblem(
    problemId = 27,
    questionNumber = 27,
    title = "Remove Element",
    problemDescription = "Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The relative order of the elements may be changed.\n" +
            "\n" +
            "Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.\n" +
            "\n" +
            "Return k after placing the final result in the first k slots of nums.\n" +
            "\n" +
            "Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.\n" +
            "\n" +
            "Custom Judge:\n" +
            "\n" +
            "The judge will test your solution with the following code:\n" +
            "\n" +
            "int[] nums = [...]; // Input array\n" +
            "int val = ...; // Value to remove\n" +
            "int[] expectedNums = [...]; // The expected answer with correct length.\n" +
            "                            // It is sorted with no values equaling val.\n" +
            "\n" +
            "int k = removeElement(nums, val); // Calls your implementation\n" +
            "\n" +
            "assert k == expectedNums.length;\n" +
            "sort(nums, 0, k); // Sort the first k elements of nums\n" +
            "for (int i = 0; i < actualLength; i++) {\n" +
            "    assert nums[i] == expectedNums[i];\n" +
            "}\n" +
            "If all assertions pass, then your solution will be accepted.",
    solution = AlgorithmicProblem.Solution(
        solutionCode = "",
        explanation = AlgorithmicProblem.Solution.Explanation(
            bestApproach = "",
            explanationDescription = "",
            coreConcepts = listOf(
                AlgorithmicProblem.Solution.Explanation.CoreConcept(
                    "", ""
                )
            ),
            timeComplexity = "",
            spaceComplexity = ""
        )
    ),
    examples = listOf(
        AlgorithmicProblem.Example(
            input = "nums = [3,2,2,3], val = 3",
            output = "2, nums = [2,2,_,_]",
            explanation = "Your function should return k = 2, with the first two elements of nums being 2.\n" +
                    "It does not matter what you leave beyond the returned k (hence they are underscores)."
        ),
        AlgorithmicProblem.Example(
            input = "nums = [0,1,2,2,3,0,4,2], val = 2",
            output = "5, nums = [0,1,4,0,3,_,_,_]",
            explanation = "Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.\n" +
                    "Note that the five elements can be returned in any order.\n" +
                    "It does not matter what you leave beyond the returned k (hence they are underscores)."
        ),
    ),
    source = AlgorithmicProblem.Source.LEETCODE,
    difficulty = AlgorithmicProblem.Difficulty.EASY
)

val leetcode28 = AlgorithmicProblem(
    problemId = 28,
    questionNumber = 28,
    title = "Find the Index of the First Occurrence in a String",
    problemDescription = "Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.",
    solution = AlgorithmicProblem.Solution(
        solutionCode = "",
        explanation = AlgorithmicProblem.Solution.Explanation(
            bestApproach = "",
            explanationDescription = "",
            coreConcepts = listOf(
                AlgorithmicProblem.Solution.Explanation.CoreConcept(
                    "", ""
                )
            ),
            timeComplexity = "",
            spaceComplexity = ""
        )
    ),
    examples = listOf(
        AlgorithmicProblem.Example(
            input = "haystack = \"sadbutsad\", needle = \"sad\"",
            output = "0",
            explanation = "\"sad\" occurs at index 0 and 6.\n" +
                    "The first occurrence is at index 0, so we return 0."
        ),
        AlgorithmicProblem.Example(
            input = "haystack = \"leetcode\", needle = \"leeto\"",
            output = "-1",
            explanation = "\"leeto\" did not occur in \"leetcode\", so we return -1."
        ),
    ),
    source = AlgorithmicProblem.Source.LEETCODE,
    difficulty = AlgorithmicProblem.Difficulty.EASY
)