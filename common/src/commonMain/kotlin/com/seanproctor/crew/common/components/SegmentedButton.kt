//package com.seanproctor.crew.common.components
//
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.offset
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.layout.wrapContentSize
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.OutlinedButton
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.Dp
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.zIndex
//
///**
// * items : list of items to be render
// * defaultSelectedItemIndex : to highlight item by default (Optional)
// * useFixedWidth : set true if you want to set fix width to item (Optional)
// * itemWidth : Provide item width if useFixedWidth is set to true (Optional)
// * cornerRadius : To make control as rounded (Optional)
// * color : Set color to control (Optional)
// * onItemSelection : Get selected item index
// */
//@Composable
//fun SegmentedButton(
//    items: List<String>,
//    defaultSelectedItemIndex: Int = 0,
//    itemWidth: Dp? = null,
//    cornerRadius: Int = 50,
//    color: Color = MaterialTheme.colorScheme.primary,
//    onItemSelection: (selectedItemIndex: Int) -> Unit
//) {
//    check(defaultSelectedItemIndex < items.size)
//    check(items.size > 1)
//
//    val selectedIndex = remember { mutableStateOf(defaultSelectedItemIndex) }
//
//    Row {
//        items.forEachIndexed { index, item ->
//            OutlinedButton(
//                modifier = Modifier
//                    .let {
//                        if (itemWidth != null)
//                            it.width(itemWidth)
//                        else
//                            it.wrapContentSize()
//                    }
//                    .offset((-1 * index).dp, 0.dp)
//                    .zIndex(if (selectedIndex.value == index) 1f else 0f),
//                onClick = {
//                    selectedIndex.value = index
//                    onItemSelection(selectedIndex.value)
//                },
//                shape = when (index) {
//                    /**
//                     * left outer button
//                     */
//                    0 -> RoundedCornerShape(
//                        topStartPercent = cornerRadius,
//                        topEndPercent = 0,
//                        bottomStartPercent = cornerRadius,
//                        bottomEndPercent = 0
//                    )
//                    /**
//                     * right outer button
//                     */
//                    items.size - 1 -> RoundedCornerShape(
//                        topStartPercent = 0,
//                        topEndPercent = cornerRadius,
//                        bottomStartPercent = 0,
//                        bottomEndPercent = cornerRadius
//                    )
//                    /**
//                     * middle buttons
//                     */
//                    else -> RoundedCornerShape(
//                        topStartPercent = 0,
//                        topEndPercent = 0,
//                        bottomStartPercent = 0,
//                        bottomEndPercent = 0
//                    )
//                },
//                border = BorderStroke(
//                    1.dp, if (selectedIndex.value == index) {
//                        color
//                    } else {
//                        color.copy(alpha = 0.75f)
//                    }
//                ),
//                colors = if (selectedIndex.value == index) {
//                    /**
//                     * selected colors
//                     */
//                    /**
//                     * selected colors
//                     */
//                    ButtonDefaults.outlinedButtonColors(
//                        containerColor = color
//                    )
//                } else {
//                    /**
//                     * not selected colors
//                     */
//                    /**
//                     * not selected colors
//                     */
//                    ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent)
//                },
//            ) {
//                Text(
//                    text = item,
//                    fontWeight = FontWeight.Normal,
//                    color = if (selectedIndex.value == index) {
//                        Color.White
//                    } else {
//                        color.copy(alpha = 0.9f)
//                    },
//                )
//            }
//        }
//    }
//}