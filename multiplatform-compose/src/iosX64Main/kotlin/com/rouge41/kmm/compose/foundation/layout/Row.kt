package com.rouge41.kmm.compose.foundation.layout

import cocoapods.YogaKit.*
import com.rouge41.kmm.compose.ios.UIComposeView
import com.rouge41.kmm.compose.ios.addSubview
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.AlignmentVertical
import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.ui.iosAlignmentVertical

actual interface RowScope
class iosRowScope : RowScope

@Composable
actual fun Row(
        modifier: Modifier,
        horizontalArrangement: ArrangementHorizontal,
        verticalAlignment: AlignmentVertical,
        content: @Composable RowScope.() -> Unit
) {
    val view = UIComposeView.createOrReuse("${content::class}")
    modifier.setup(view)
    view.configureLayoutWithBlock { layout ->
        layout?.flexDirection = YGFlexDirection.YGFlexDirectionRow
        when (horizontalArrangement) {
            iosArrangementHorizontal.Start -> layout?.justifyContent = YGJustify.YGJustifyFlexStart
            iosArrangementHorizontal.End -> layout?.justifyContent = YGJustify.YGJustifyFlexEnd
            iosArrangement.Center -> layout?.justifyContent = YGJustify.YGJustifyCenter
            iosArrangement.SpaceEvenly -> layout?.justifyContent = YGJustify.YGJustifySpaceEvenly
            iosArrangement.SpaceBetween -> layout?.justifyContent = YGJustify.YGJustifySpaceBetween
            iosArrangement.SpaceAround -> layout?.justifyContent = YGJustify.YGJustifySpaceAround
        }
        when (verticalAlignment) {
            iosAlignmentVertical.Top -> layout?.alignItems = YGAlign.YGAlignFlexStart
            iosAlignmentVertical.CenterVertically -> layout?.alignItems = YGAlign.YGAlignCenter
            iosAlignmentVertical.Bottom -> layout?.alignItems = YGAlign.YGAlignFlexEnd
        }
    }
    addSubview(view) { content.invoke(iosRowScope()) }
}