package com.algorithm_questions_visualizer.data.repository

import com.algorithm_questions_visualizer.model.AlgorithmicProblem

interface DashboardRepository {

    fun getQuestions() : List<AlgorithmicProblem>
}