package com.lnsantos.brainup.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.invisibleToUser
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lnsantos.brainup.feature.home.widgets.WidgetButtonItem
import com.lnsantos.brainup.feature.home.widgets.WidgetParent
import com.lnsantos.pet.button.PetButton
import com.lnsantos.pet.core.PetStyle
import com.lnsantos.pet.core.PetValues
import com.lnsantos.pet.core.factory.rememberPetStyleClip
import com.lnsantos.pet.text.PetText
import com.lnsantos.pet.text.model.PetTextStyle

@Composable
fun HomeScreen(
    widgets: List<WidgetParent> = listOf(),
    onClickWidget: (WidgetParent) -> Unit,
    onClickMain: () -> Unit = {},
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PetValues.Colors.get().tertiary)
    ) {
        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize(),
            columns = GridCells.Adaptive(minSize = 150.dp),
            contentPadding = PaddingValues(12.dp)
        ) {
            items(widgets) { widget ->
                when(widget) {
                    is WidgetButtonItem -> WidgetButtonItem(
                        modifier = Modifier.padding(8.dp),
                        widget,
                        onClickWidget
                    )
                }
            }
        }

        PetButton(
            style = PetStyle.HIGH_X,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.BottomCenter),
            onClick = onClickMain
        ) {
            PetText(
                text = "Praticar",
                type = PetTextStyle.TITLE,
                textColor = PetValues.Colors.get().tertiary
            )
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
@Preview
private fun WidgetButtonItem(
    modifier: Modifier = Modifier,
    data: WidgetButtonItem = WidgetButtonItem("title", "sds", icon = Icons.Filled.Settings),
    onClickWidget: (WidgetParent) -> Unit = {}
) {
    Box(
        modifier = modifier
            .size(200.dp)
            .background(
                color = PetValues.Colors.get().background,
                shape = rememberPetStyleClip { PetStyle.LOW }
            )
            .clickable { onClickWidget(data) }
            .semantics {
                contentDescription = data.title
                role = Role.Button
            }
    ) {
        PetText(
            text = data.title,
            type = PetTextStyle.TITLE,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 24.dp)
                .semantics { invisibleToUser() },
            textColor = PetValues.Colors.get().tertiary,
        )

        if (data.icon != null) {
            Icon(
                imageVector = data.icon,
                contentDescription = null,
                tint = PetValues.Colors.get().tertiary,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .size(150.dp)
                    .alpha(alpha = 0.1f)
                    .clip(RoundedCornerShape(
                        topEnd = 50.dp,
                        bottomEnd = 10.dp
                    ))
                    .offset(x = (60.dp), y = 20.dp)


            )
        }
    }
}