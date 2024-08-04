package com.alqoview.ui.screens.problem.screen.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.alqoview.ui.screens.problem.screen.state.ProblemScreenDataState
import com.alqoview.ui.screens.problem.screen.viewmodel.ProblemScreenViewModel
import com.ramcosta.composedestinations.annotation.Destination

@Destination(
    navArgsDelegate = ProblemScreenNavArgs::class,
)
@Composable
fun ProblemScreen(
    modifier: Modifier = Modifier,
    viewmodel: ProblemScreenViewModel = hiltViewModel()
) {


    val uiState by viewmodel.uiState.collectAsStateWithLifecycle()

    when (uiState.state) {
        ProblemScreenViewModel.UiState.State.DATA -> {
            ProblemScreenDataState(modifier, uiState.algorithmicProblem!!)
        }
        ProblemScreenViewModel.UiState.State.ERROR -> {

        }
        ProblemScreenViewModel.UiState.State.INITIAL -> Unit
    }
}


@Preview
@Composable
fun ProblemScreenPreview() {
    ProblemScreen()
}