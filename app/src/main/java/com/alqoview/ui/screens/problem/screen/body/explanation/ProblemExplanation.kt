package com.alqoview.ui.screens.problem.screen.body.explanation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alqoview.R
import com.alqoview.data.source.leetcode1
import com.alqoview.model.AlgorithmicProblem

@Composable
fun ProblemExplanation(
    modifier: Modifier = Modifier,
    explanation: AlgorithmicProblem.Solution.Explanation
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
    ) {

        Text(
            text = stringResource(
                R.string.problem_screen_explanation_best_approach,
                explanation.bestApproach,
            ),
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline,
            fontSize = 16.sp,
            color = Color.White
        )

        Text(
            text = stringResource(R.string.problem_screen_explanation_core_concepts),
            modifier = Modifier.padding(top = 16.dp),
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        explanation.coreConcepts.forEachIndexed { index, concept ->
            ExplanationCoreConceptItem(index, concept)
        }

        Text(
            text = stringResource(R.string.problem_screen_explanation_explanation),
            modifier = Modifier.padding(top = 16.dp),
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )

        Text(
            text = explanation.explanationDescription,
            modifier = Modifier.padding(top = 8.dp),
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Thin
        )
        Text(
            text = stringResource(R.string.problem_screen_explanation_complexity_analysis),
            modifier = Modifier.padding(top = 16.dp),
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 16.sp
        )
        Text(
            text = stringResource(
                R.string.problem_screen_explanation_time_complexity,
                explanation.timeComplexity
            ),
            modifier = Modifier.padding(top = 16.dp),
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Thin
        )
        Text(
            text = stringResource(
                R.string.problem_screen_explanation_space_complexity,
                explanation.spaceComplexity
            ),
            modifier = Modifier.padding(top = 16.dp),
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Thin
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProblemExplanationPreview_BlackBackground() {
    ProblemExplanation(
        modifier = Modifier.background(Color.Black),
        explanation = leetcode1.solution.explanation
    )
}