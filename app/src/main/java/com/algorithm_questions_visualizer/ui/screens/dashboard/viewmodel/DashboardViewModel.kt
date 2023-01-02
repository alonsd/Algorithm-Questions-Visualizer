package com.algorithm_questions_visualizer.ui.screens.dashboard.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.algorithm_questions_visualizer.data.repository.DashboardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val dashboardRepository: DashboardRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()

    private val _uiAction = MutableSharedFlow<UiAction>()
    val uiAction = _uiAction.asSharedFlow()

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    private val uiEvent = _uiEvent.asSharedFlow()


    private fun submitAction(uiAction: UiAction) = viewModelScope.launch {
        _uiAction.emit(uiAction)
    }

    private fun submitUiState(uiState: UiState) {
        _uiState.update { uiState }
    }

    fun submitEvent(uiEvent: UiEvent) = viewModelScope.launch {
        _uiEvent.emit(uiEvent)
    }

    sealed interface UiEvent {
    }

    data class UiState(
        val errorMessage: String = "",
        val state: State = State.Initial
    ) {
        enum class State {
            Data,
            Error,
            Initial
        }
    }

    sealed interface UiAction {

    }
}