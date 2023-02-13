package com.alqoview.data.repository

import com.alqoview.data.source.leetcode1
import com.alqoview.data.source.leetcode2
import com.alqoview.model.AlgorithmicProblem
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

