package com.algorithm_questions_visualizer.model

data class AlgorithmicProblem(
    val problemId : Int,
    val title: String,
    val source: Source,
    val solution: Solution,
    val description: String,
    val questionNumber: Int,
    val difficulty: Difficulty,
    val examples: List<Example>
) {
    enum class Source {
        LEETCODE,
        HACKER_RANK
    }

    enum class Difficulty {
        EASY,
        MEDIUM,
        HARD
    }

    data class Example(
        val input: String,
        val output: String,
        val explanation: String? = null
    )

    data class Solution(
        val solutionCode: String,
        val explanation: String
    )
}
