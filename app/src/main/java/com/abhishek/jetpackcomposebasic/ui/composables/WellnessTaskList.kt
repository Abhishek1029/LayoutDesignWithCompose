package com.abhishek.jetpackcomposebasic.ui.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.abhishek.jetpackcomposebasic.data.datasource.WellnessTask

@Composable
fun WellnessTaskList(
    modifier: Modifier = Modifier,
    taskList: List<WellnessTask> = remember {
        getTaskList()
    }
) {
    LazyColumn(modifier) {
        items(taskList) { item ->
            WellnessTaskItemStateful(taskName = item.label)
        }
    }
}

fun getTaskList() = List(30) { it -> WellnessTask(it, "Task $it") }