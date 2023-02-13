package com.alqoview.data.repository

import com.alqoview.data.source.leetcode1
import com.alqoview.data.source.leetcode2
import com.alqoview.data.source.leetcode3
import com.alqoview.data.source.leetcode4
import com.alqoview.model.AlgorithmicProblem
import javax.inject.Inject

class ProblemsRepositoryImpl @Inject constructor() : ProblemsRepository {

    private val problemsList = listOf(
        leetcode1, leetcode2, leetcode3,
        leetcode4
    )

    override fun getProblems(): List<AlgorithmicProblem> {
        return problemsList
    }

    override fun getProblemById(problemId: Int): AlgorithmicProblem? {
        return problemsList.find { it.problemId == problemId }
    }

}

