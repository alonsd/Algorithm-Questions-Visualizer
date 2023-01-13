package com.algorithm_questions_visualizer.ui.screens.problem.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.algorithm_questions_visualizer.R
import com.algorithm_questions_visualizer.data.source.leetcode1
import com.algorithm_questions_visualizer.model.AlgorithmicProblem

@Composable
fun ProblemDescription(
    modifier: Modifier = Modifier,
    algorithmicProblem: AlgorithmicProblem
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = stringResource(
                id = R.string.problem_screen_question_title,
                algorithmicProblem.questionNumber,
                algorithmicProblem.title
            ),
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = algorithmicProblem.description,
            modifier = Modifier.padding(top = 16.dp),
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.padding(top = 32.dp))
        for (i in 0 until algorithmicProblem.examples.size) {
            ExampleItem(
                example = algorithmicProblem.examples[i],
                exampleNumber = i
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProblemDescriptionPreview() {
    ProblemDescription(algorithmicProblem = leetcode1)
}