package com.algorithm_questions_visualizer.data.repository

import com.algorithm_questions_visualizer.data.source.leetcode1
import com.algorithm_questions_visualizer.data.source.leetcode2
import com.algorithm_questions_visualizer.model.AlgorithmicProblem
import javax.inject.Inject

class DashboardRepositoryImpl @Inject constructor() : DashboardRepository {
    override fun getQuestions(): List<AlgorithmicProblem> {
        return listOf(leetcode1, leetcode2)

    }

}

