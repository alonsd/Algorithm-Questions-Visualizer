package com.algorithm_questions_visualizer.model

data class AlgorithmicProblem(
    val questionNumber: Int,
    val title: String,
    val description: String,
    val solution: String,
    val examples: List<Example>,
    val source: Source,
    val difficulty: Difficulty
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
}
