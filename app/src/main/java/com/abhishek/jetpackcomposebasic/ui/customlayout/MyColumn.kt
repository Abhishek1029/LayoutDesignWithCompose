package com.abhishek.jetpackcomposebasic.ui.customlayout

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout

/**
 * Simple example to create custom layout
 */
@Composable
fun MyColumn(
    modifier: Modifier = Modifier,
    /**
     * content is for the items to be laid out in vertical sequences
     */
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurable, constraints ->
        val placeables = measurable.map { measurable ->
            measurable.measure(constraints)
        }
        val height = placeables.sumOf { it.height }
        val width = placeables.maxOf { it.width }

        layout(width, height) {
            var y = 0
            placeables.forEach { placeable ->
                placeable.placeRelative(x = 0, y = y)
                y += placeable.height
            }
        }
    }
}