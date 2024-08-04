package com.alqoview.data.source

import com.alqoview.model.AlgorithmicProblem

val leetcode35 = AlgorithmicProblem(
    problemId = 35,
    questionNumber = 35,
    title = "Search Insert Position",
    problemDescription = "Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.  You must write an algorithm with O(log n) runtime complexity.",
    examples = listOf(
        AlgorithmicProblem.Example(
            input = "nums = [1,3,5,6], target = 5",
            output = "2",
            explanation = ""
        ),
        AlgorithmicProblem.Example(
            input = "2",
            output = "1",
            explanation = ""
        ),
        AlgorithmicProblem.Example(
            input = "nums = [1,3,5,6], target = 7",
            output = "4",
            explanation = ""
        ),
    ),
    source = AlgorithmicProblem.Source.LEETCODE,
    difficulty = AlgorithmicProblem.Difficulty.EASY,
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
    )
)