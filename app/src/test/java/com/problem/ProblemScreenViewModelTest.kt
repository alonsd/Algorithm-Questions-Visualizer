package com.problem//package com.problem
//
//import androidx.arch.core.executor.testing.InstantTaskExecutorRule
//import androidx.lifecycle.SavedStateHandle
//import androidx.lifecycle.ViewModel
//import app.cash.turbine.test
//import com.google.common.truth.Truth.assertThat
//import com.example.YourApp.data.ProblemsRepository
//import com.example.YourApp.model.AlgorithmicProblem
//import com.example.YourApp.ui.ProblemScreenViewModel
//import com.example.YourApp.ui.ProblemScreenViewModel.UiState
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.flow.flow
//import kotlinx.coroutines.flow.flowOf
//import kotlinx.coroutines.flow.stateIn
//import kotlinx.coroutines.runBlocking
//import kotlinx.coroutines.test.*
//import org.junit.Before
//import org.junit.Rule
//import org.junit.Test
//import org.mockito.Mockito
//import org.mockito.Mockito.`when`
//
//@ExperimentalCoroutinesApi
//class ProblemScreenViewModelTest {
//
//    @get:Rule
//    val instantExecutorRule = InstantTaskExecutorRule()
//
//    private val testDispatcher = UnconfinedTestDispatcher()
//    private lateinit var problemsRepository: ProblemsRepository
//    private lateinit var savedStateHandle: SavedStateHandle
//    private lateinit var viewModel: ProblemScreenViewModel
//
//    @Before
//    fun setup() {
//        Dispatchers.setMain(testDispatcher)
//
//        problemsRepository = Mockito.mock(ProblemsRepository::class.java)
//        savedStateHandle = SavedStateHandle(mapOf("problemId" to "testId"))
//
//        viewModel = ProblemScreenViewModel(problemsRepository, savedStateHandle)
//    }
//
//    @Test
//    fun `uiState emits ERROR when problem is not found`() = runTest {
//        `when`(problemsRepository.getProblemById("testId")).thenReturn(null)
//
//        viewModel.uiState.test {
//            val emission = awaitItem()
//            assertThat(emission.state).isEqualTo(UiState.State.ERROR)
//        }
//    }
//
//    @Test
//    fun `uiState emits DATA when problem is found`() = runTest {
//        val testProblem = AlgorithmicProblem(id = "testId", name = "Test Problem", description = "Test Description")
//        `when`(problemsRepository.getProblemById("testId")).thenReturn(testProblem)
//
//        viewModel.uiState.test {
//            val emission = awaitItem()
//            assertThat(emission.state).isEqualTo(UiState.State.DATA)
//            assertThat(emission.algorithmicProblem).isEqualTo(testProblem)
//        }
//    }
//
//    @Test
//    fun `uiState emits INITIAL state initially`() = runTest {
//        viewModel.uiState.test {
//            val emission = awaitItem()
//            assertThat(emission.state).isEqualTo(UiState.State.INITIAL)
//        }
//    }
//}