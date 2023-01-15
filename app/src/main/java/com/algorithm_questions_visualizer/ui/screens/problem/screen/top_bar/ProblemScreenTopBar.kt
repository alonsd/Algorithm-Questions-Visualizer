package com.algorithm_questions_visualizer.ui.screens.problem.screen.top_bar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.launch
import com.google.accompanist.pager.*

@Composable
fun ProblemScreenTopBar(
    currentPage: Int,
    onTabClicked: (index: Int) -> Unit
) {

    Column {
        TabRow(
            selectedTabIndex = currentPage,
            indicator = @Composable { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(tabPositions[currentPage]),
                    color = Color.White
                )
            }
        ) {
            ProblemScreenTabs.values().forEachIndexed { index, tabRowItem ->
                Tab(
                    modifier = Modifier.padding(16.dp),
                    selected = currentPage == index,
                    onClick = { onTabClicked(index) },
                    content = {
                        Text(
                            text = tabRowItem.value,
                            color = Color.White
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
    ProblemScreenTopBar(1) {}
}