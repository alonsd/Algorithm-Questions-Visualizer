package com.algorithm_questions_visualizer.ui.screens.dashboard.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import com.algorithm_questions_visualizer.data.source.leetcode1
import com.algorithm_questions_visualizer.model.AlgorithmicProblem
import com.algorithm_questions_visualizer.ui.screens.dashboard.state.data.ProblemScreen
import com.algorithm_questions_visualizer.ui.screens.dashboard.viewmodel.DashboardViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@ExperimentalComposeUiApi
@Destination
@Composable
fun DashboardScreen(
    navigator: DestinationsNavigator,
    viewModel : DashboardViewModel = hiltViewModel()
) {
    ProblemScreen(algorithmicProblem = leetcode1)
}