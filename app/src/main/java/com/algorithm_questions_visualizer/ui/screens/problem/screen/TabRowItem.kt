package com.algorithm_questions_visualizer.ui.screens.problem.screen

import androidx.compose.runtime.Composable

data class TabRowItem(
    val title: String = ProblemScreenTabs.DESCRIPTION.value,
    val screen: @Composable () -> Unit,
) {
    enum class ProblemScreenTabs(val value : String) {
        DESCRIPTION("Description"),
        SOLUTION("Solution"),
        EXPLANATION("Explanation")
    }
}
