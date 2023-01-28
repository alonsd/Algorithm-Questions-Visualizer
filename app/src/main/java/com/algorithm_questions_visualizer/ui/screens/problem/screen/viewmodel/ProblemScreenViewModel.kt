package com.algorithm_questions_visualizer.ui.screens.problem.screen.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.algorithm_questions_visualizer.data.repository.ProblemsRepository
import com.algorithm_questions_visualizer.model.AlgorithmicProblem
import com.algorithm_questions_visualizer.ui.screens.dashboard.viewmodel.DashboardViewModel
import com.algorithm_questions_visualizer.ui.screens.destinations.ProblemScreenDestination
import com.algorithm_questions_visualizer.ui.screens.problem.screen.screen.ProblemScreenNavArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ProblemScreenViewModel @Inject constructor(
    problemsRepository: ProblemsRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val uiState: StateFlow<UiState> = flow {
        val problem = problemsRepository.getProblemById(ProblemScreenDestination.argsFrom(savedStateHandle).problemId)
        problem?.let {
            emit(UiState(state = UiState.State.DATA, algorithmicProblem = it))
        } ?: run {
            emit(UiState(state = UiState.State.ERROR))
        }
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        UiState()
    )


    data class UiState(
        val state: State = State.INITIAL,
        val errorMessage: String = "",
        val algorithmicProblem: AlgorithmicProblem? = null
    ) {

        enum class State {
            DATA,
            ERROR,
            INITIAL
        }
    }
}