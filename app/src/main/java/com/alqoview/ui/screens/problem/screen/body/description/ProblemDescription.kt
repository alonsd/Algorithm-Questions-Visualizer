package com.alqoview.ui.screens.problem.screen.body.description

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alqoview.data.source.leetcode1
import com.alqoview.model.AlgorithmicProblem

@Composable
fun ProblemDescription(
    modifier: Modifier = Modifier,
    description: String,
    examples: List<AlgorithmicProblem.Example>,
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = description,
            modifier = Modifier.padding(top = 16.dp),
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.padding(top = 32.dp))
        examples.forEachIndexed { index, example ->
            DescriptionExampleItem(
                example = example,
                exampleNumber = index
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProblemDescriptionPreview() {
    ProblemDescription(
        description = leetcode1.problemDescription,
        examples = leetcode1.examples
    )
}