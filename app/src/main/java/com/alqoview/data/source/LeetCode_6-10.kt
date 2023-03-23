package com.alqoview.data.source

import com.alqoview.model.AlgorithmicProblem


val leetcode9 = AlgorithmicProblem(
    problemId = 9,
    questionNumber = 9,
    title = "Palindrome Number",
    problemDescription = "Given an integer x, return true if x is a \n" +
            "palindrome \n" +
            ", and false otherwise. An integer is a palindrome when it reads the same forward and backward.\n" +
            "\n" +
            "For example, 121 is a palindrome while 123 is not.",
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
            input = "x = 121",
            output = "true",
            explanation = "121 reads as 121 from left to right and from right to left."
        ),
        AlgorithmicProblem.Example(
            input = "x = -121",
            output = "false",
            explanation = "From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome."
        ),
        AlgorithmicProblem.Example(
            input = "x = 10",
            output = "false",
            explanation = "Reads 01 from right to left. Therefore it is not a palindrome."
        ),
    ),
    source = AlgorithmicProblem.Source.LEETCODE,
    difficulty = AlgorithmicProblem.Difficulty.EASY
)

