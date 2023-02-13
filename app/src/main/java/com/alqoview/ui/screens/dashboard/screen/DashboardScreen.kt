package com.alqoview.ui.screens.dashboard.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.alqoview.core.extensions.SingleTimeLaunchedEffect
import com.alqoview.ui.screens.dashboard.body.DashboardScreenBody
import com.alqoview.ui.screens.dashboard.viewmodel.DashboardViewModel
import com.alqoview.ui.screens.dashboard.viewmodel.DashboardViewModel.UiAction.NavigateToProblemScreen
import com.alqoview.ui.screens.dashboard.viewmodel.DashboardViewModel.UiAction.NoAction
import com.alqoview.ui.screens.destinations.ProblemScreenDestination
import com.alqoview.ui.screens.problem.screen.screen.ProblemScreenNavArgs
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@ExperimentalComposeUiApi
@Composable
fun DashboardScreen(
    navigator: DestinationsNavigator,
    viewModel: DashboardViewModel = hiltViewModel()
) {
    SetSystemBarsColors()

    val uiState by viewModel.uiState.collectAsState()
    val uiAction by viewModel.uiAction.collectAsState(initial = NoAction)

    when(val action = uiAction) {
        is NavigateToProblemScreen -> {
            navigator.navigate(ProblemScreenDestination(ProblemScreenNavArgs(action.itemId)))
        }
        NoAction -> Unit
    }

    DashboardScreenBody(algorithmicProblems = uiState.algorithmicProblems) { itemId ->
        viewModel.submitEvent(DashboardViewModel.UiEvent.OnListItemClicked(itemId))
    }

}

@Composable
private fun SetSystemBarsColors() {
    val uiController = rememberSystemUiController()
    SingleTimeLaunchedEffect {
        uiController.setSystemBarsColor(color = Color.Black)
    }
}