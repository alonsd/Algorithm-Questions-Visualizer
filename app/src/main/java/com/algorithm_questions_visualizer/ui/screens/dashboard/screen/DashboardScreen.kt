package com.algorithm_questions_visualizer.ui.screens.dashboard.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import com.algorithm_questions_visualizer.core.extensions.SingleTimeLaunchedEffect
import com.algorithm_questions_visualizer.data.source.leetcode1
import com.algorithm_questions_visualizer.ui.screens.problem.screen.ProblemScreen
import com.algorithm_questions_visualizer.ui.screens.dashboard.viewmodel.DashboardViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
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
    val uiController = rememberSystemUiController()

    SingleTimeLaunchedEffect {
        uiController.isStatusBarVisible = false
    }

    ProblemScreen(algorithmicProblem = leetcode1)
}