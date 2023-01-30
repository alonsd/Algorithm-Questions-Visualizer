package com.algorithm_questions_visualizer.data.repository

import com.algorithm_questions_visualizer.data.source.leetcode1
import com.algorithm_questions_visualizer.data.source.leetcode2
import com.algorithm_questions_visualizer.model.AlgorithmicProblem
import javax.inject.Inject

class ProblemsRepositoryImpl @Inject constructor() : ProblemsRepository {

    private val problemsList = listOf(leetcode1, leetcode2)
    override fun getProblems(): List<AlgorithmicProblem> {
        return problemsList
    }

    override fun getProblemById(problemId: Int): AlgorithmicProblem? {
        return problemsList.find { it.problemId == problemId }
    }

}

