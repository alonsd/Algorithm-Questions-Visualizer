package com.alqoview.data.repository

import com.alqoview.model.AlgorithmicProblem

interface ProblemsRepository {

    fun getProblems() : List<AlgorithmicProblem>

    fun getProblemById(problemId: Int) : AlgorithmicProblem?
}