package com.rouge41.kmm.compose.test.demos

import com.rouge41.kmm.compose.material.Text
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.ui.fillMaxWidth
import com.rouge41.kmm.compose.ui.graphics.Color
import com.rouge41.kmm.compose.ui.padding
import com.rouge41.kmm.compose.ui.text.TextStyle
import com.rouge41.kmm.compose.ui.text.font.FontFamily
import com.rouge41.kmm.compose.ui.text.font.FontWeight
import com.rouge41.kmm.compose.ui.unit.dp
import com.rouge41.kmm.compose.ui.unit.sp

@Composable
fun TitleComponent(title: String) {
    // Text is a predefined composable that does exactly what you'd expect it to - display text on
    // the screen. It allows you to customize its appearance using style, fontWeight, fontSize, etc.
    Text(
        title,
        style = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.W900,
            fontSize = 14.sp,
            color = Color.Black
        ),
        modifier = Modifier.padding(16.dp).fillMaxWidth()
    )
}
