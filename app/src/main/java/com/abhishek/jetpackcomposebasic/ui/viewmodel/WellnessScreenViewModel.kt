package com.abhishek.jetpackcomposebasic.ui.viewmodel

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.abhishek.jetpackcomposebasic.data.datasource.WellnessTask

class WellnessScreenViewModel : ViewModel() {
    private var _list = getTaskList().toMutableStateList()
    val task: List<WellnessTask>
        get() = _list

    fun remove(wellnessTask: WellnessTask) {
        _list.remove(wellnessTask)
    }

    fun getTaskList() = List(30) { it -> WellnessTask(it, "Task $it") }
}