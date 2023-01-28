package com.algorithm_questions_visualizer.ui.screens.dashboard.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.algorithm_questions_visualizer.core.extensions.SingleTimeLaunchedEffect
import com.algorithm_questions_visualizer.data.source.leetcode1
import com.algorithm_questions_visualizer.ui.screens.dashboard.list_item.AlgorithmProblemListItem
import com.algorithm_questions_visualizer.ui.screens.dashboard.viewmodel.DashboardViewModel
import com.algorithm_questions_visualizer.ui.screens.problem.screen.screen.ProblemScreen
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
    viewModel: DashboardViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    val uiController = rememberSystemUiController()
    SingleTimeLaunchedEffect {
        uiController.setSystemBarsColor(color = Color.Black)
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        items(uiState.algorithmicProblems) { algorithmicProblem ->
            AlgorithmProblemListItem(
                problemId = algorithmicProblem.problemId,
                questionNumber = algorithmicProblem.questionNumber,
                questionTitle = algorithmicProblem.title,
                source = algorithmicProblem.source
            ) { problemId ->

            }
        }
    }


//    ProblemScreen(algorithmicProblem = leetcode1)
}