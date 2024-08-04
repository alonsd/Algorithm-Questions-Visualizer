package com.alqoview.ui.screens.problem.screen.top_bar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alqoview.R

@Composable
fun ProblemScreenTopBar(
    title: String,
    questionNumber: String,
    currentPage: Int,
    onTabClicked: (index: Int) -> Unit
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = stringResource(
                id = R.string.question_title,
                title,
                questionNumber
            ),
            fontSize = 20.sp,
        )
        TabRow(
            selectedTabIndex = currentPage,
            indicator = @Composable { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(tabPositions[currentPage]),
                    color = Color.White
                )
            },
            containerColor = Color.Transparent,
        ) {
            ProblemScreenTabs.entries.forEachIndexed { index, tabRowItem ->
                Tab(
                    selected = currentPage == index,
                    selectedContentColor = Color.White,
                    onClick = { onTabClicked(index) },
                    content = {
                        Text(
                            modifier = Modifier.padding(16.dp),
                            text = tabRowItem.value,
                            fontSize = 14.sp,
                            color = Color.White,
                            maxLines = 1
                        )
                    }
                )
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun ProblemScreenTopBarPreview() {
    ProblemScreenTopBar("1", "Test", 1) {}
}