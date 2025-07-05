package infmenergy.ui.screens.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.infmenergy.ui.theme.*

@Composable
fun CheckBoxWithTitle(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit),
    checkBoxSize: Dp = 24.dp,
    checkBoxBorderWidth: Dp = 1.dp,
    checkBoxBorderColorSelected: Color = Neutral99,
    checkBoxBorderColorUnSelected: Color = Neutral70,
    checkBoxCheckedIconColor: Color = Neutral99,
) {
    val checkBoxState = remember { mutableStateOf(checked) }

    Box(
        modifier = Modifier
            .border(
                BorderStroke(
                    checkBoxBorderWidth,
                    color = if (checkBoxState.value) checkBoxBorderColorSelected else checkBoxBorderColorUnSelected
                ),
                shape = RoundedCornerShape(4.dp)
            )
            .size(checkBoxSize)
            .background(if (checkBoxState.value) Neutral80 else Color.Transparent)
            .clickable {
                val newValue = !checkBoxState.value
                onCheckedChange(newValue)
                checkBoxState.value = newValue
            },
        contentAlignment = Alignment.Center
    ) {
        if (checkBoxState.value)
            Icon(
                imageVector = Icons.Default.Check,
                tint = checkBoxCheckedIconColor,
                contentDescription = "CheckBox"
            )
    }
}
