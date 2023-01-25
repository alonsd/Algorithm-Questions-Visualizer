package com.algorithm_questions_visualizer.ui.screens.problem.screen.body

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.algorithm_questions_visualizer.R
import com.algorithm_questions_visualizer.model.AlgorithmicProblem

@Composable
fun ExampleItem(
    example: AlgorithmicProblem.Example,
    exampleNumber: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.Black)
    ) {
        CompositionLocalProvider(LocalContentColor provides Color.White) {
            Text(
                text = stringResource(
                    id = R.string.example_item_title, exampleNumber.toString()
                ),
                fontWeight = FontWeight.Bold
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(
                        top = 8.dp,
                        start = 8.dp,
                        bottom = 32.dp
                    )
            ) {
                Text(
                    text = stringResource(
                        id = R.string.example_item_input, example.input
                    ),
                )
                Text(
                    text = stringResource(
                        id = R.string.example_item_output, example.output
                    ),
                )
                example.explanation?.let { explanation ->
                    Text(
                        text = stringResource(
                            id = R.string.example_item_explanation, explanation
                        ),
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExampleItemPreview() {
    ExampleItem(
        AlgorithmicProblem.Example(
            input = "nums = [2,7,11,15], target = 9",
            output = "[0,1]",
            explanation = "Because nums[0] + nums[1] == 9, we return [0, 1]."
        ),
        1
    )
}