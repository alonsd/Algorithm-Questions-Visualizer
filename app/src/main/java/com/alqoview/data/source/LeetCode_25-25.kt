package com.alqoview.data.source

import com.alqoview.model.AlgorithmicProblem

val leetcode20 = AlgorithmicProblem(
    problemId = 20,
    questionNumber = 20,
    title = "Valid Parentheses",
    problemDescription = "Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.\n" +
            "\n" +
            "An input string is valid if:\n" +
            "\n" +
            "Open brackets must be closed by the same type of brackets.\n" +
            "Open brackets must be closed in the correct order.\n" +
            "Every close bracket has a corresponding open bracket of the same type.",
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
            input = "s = \"()\"",
            output = "true"
        ),
        AlgorithmicProblem.Example(
            input = "s = \"()[]{}\"",
            output = "true"
        ),
        AlgorithmicProblem.Example(
            input = "s = \"(]\"",
            output = "false"
        ),
    ),
    source = AlgorithmicProblem.Source.LEETCODE,
    difficulty = AlgorithmicProblem.Difficulty.EASY
)

val leetcode21 = AlgorithmicProblem(
    problemId = 21,
    questionNumber = 21,
    title = "Merge Two Sorted Lists",
    problemDescription = "You are given the heads of two sorted linked lists list1 and list2.\n" +
            "\n" +
            "Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.\n" +
            "\n" +
            "Return the head of the merged linked list.\n\n" +
            "Both list1 and list2 are sorted in non-decreasing order.",
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
            input = "list1 = [1,2,4], list2 = [1,3,4]",
            output = "[1,1,2,3,4,4]"
        ),
        AlgorithmicProblem.Example(
            input = "list1 = [], list2 = []",
            output = "[]"
        ),
        AlgorithmicProblem.Example(
            input = "list1 = [], list2 = [0]",
            output = "[0]"
        ),
    ),
    source = AlgorithmicProblem.Source.LEETCODE,
    difficulty = AlgorithmicProblem.Difficulty.EASY
)