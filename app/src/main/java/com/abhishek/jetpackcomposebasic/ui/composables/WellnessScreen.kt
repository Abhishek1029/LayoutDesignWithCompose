package com.abhishek.jetpackcomposebasic.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.abhishek.jetpackcomposebasic.data.datasource.WellnessTask
import com.abhishek.jetpackcomposebasic.ui.viewmodel.WellnessScreenViewModel

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessScreenViewModel: WellnessScreenViewModel = viewModel()
) {
    Column(modifier) {
        StatefulCounter()
        WellnessTaskList(taskList = wellnessScreenViewModel.task,
            onCloseClick = {task -> wellnessScreenViewModel.remove(task)})
    }
}

