package com.alqoview.data.repository

import com.alqoview.data.source.*
import com.alqoview.model.AlgorithmicProblem
import javax.inject.Inject

class ProblemsRepositoryImpl @Inject constructor() : ProblemsRepository {

    private val problemsList = listOf(
        leetcode1, leetcode2, leetcode3, leetcode4, leetcode9, leetcode13,
        leetcode14, leetcode20, leetcode21, leetcode26, leetcode27, leetcode28, leetcode35
    )

    override fun getProblems(): List<AlgorithmicProblem> {
        return problemsList.sortedBy { it.difficulty }
    }

    override fun getProblemById(problemId: Int): AlgorithmicProblem? {
        return problemsList.find { it.problemId == problemId }
    }

}

