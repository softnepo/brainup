package com.lnsantos.pet.button

import android.content.res.Configuration
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lnsantos.pet.core.PetStyle
import com.lnsantos.pet.core.factory.rememberPetStyleClip
import com.lnsantos.pet.theme.PetTheme

@Composable
fun PetButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    style: PetStyle = PetStyle.LOW,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        modifier = Modifier.then(modifier),
        onClick = onClick,
        enabled = enabled,
        shape = rememberPetStyleClip { style },
        content = content
    ) 
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun PreviewButton() {
    PetTheme {
        PetButton(
            style = PetStyle.HIGH_X,
            enabled = false
        ) {
            Text(text = "Login")
        }
    }
}