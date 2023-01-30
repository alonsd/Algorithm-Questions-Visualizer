package com.algorithm_questions_visualizer.ui.screens.dashboard.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.algorithm_questions_visualizer.data.repository.ProblemsRepository
import com.algorithm_questions_visualizer.model.AlgorithmicProblem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    problemsRepository: ProblemsRepository
) : ViewModel() {

    val uiState: StateFlow<UiState> = flow {
        emit(
            UiState(
                state = UiState.State.Data,
                algorithmicProblems = problemsRepository.getProblems()
            )
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        UiState()
    )

    private val _uiAction = MutableSharedFlow<UiAction>()
    val uiAction = _uiAction.asSharedFlow()

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    private val uiEvent = _uiEvent.asSharedFlow()

    init {
        observeUiEvent()
    }

    private fun observeUiEvent() = viewModelScope.launch {
        uiEvent.collect {event ->
            when(event) {
                is UiEvent.OnListItemClicked -> {
                    submitAction(UiAction.NavigateToProblemScreen(event.itemId))
                }
            }
        }
    }


    private fun submitAction(uiAction: UiAction) = viewModelScope.launch {
        _uiAction.emit(uiAction)
    }

    fun submitEvent(uiEvent: UiEvent) = viewModelScope.launch {
        _uiEvent.emit(uiEvent)
    }

    sealed interface UiEvent {
        data class OnListItemClicked(val itemId: Int) : UiEvent
    }

    data class UiState(
        val errorMessage: String = "",
        val state: State = State.Initial,
        val algorithmicProblems: List<AlgorithmicProblem> = emptyList()
    ) {
        enum class State {
            Data,
            Error,
            Initial
        }
    }

    sealed interface UiAction {
        data class NavigateToProblemScreen(val itemId: Int) : UiAction
        object NoAction
    }
}