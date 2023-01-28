package com.algorithm_questions_visualizer.data.repository

import com.algorithm_questions_visualizer.model.AlgorithmicProblem

interface ProblemsRepository {

    fun getProblems() : List<AlgorithmicProblem>

    fun getProblemById(problemId: Int) : AlgorithmicProblem?
}