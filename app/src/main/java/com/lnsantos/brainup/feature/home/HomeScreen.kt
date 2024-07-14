package com.lnsantos.brainup.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
        modifier = Modifier.fillMaxSize()
    ) {
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .background(PetValues.Colors.get().onPrimary),
            columns = GridCells.Adaptive(minSize = 150.dp)
        ) {
            items(widgets) { widget ->
                when(widget) {
                    is WidgetButtonItem -> WidgetButtonItem(widget, onClickWidget)
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

@Composable
private fun WidgetButtonItem(
    data: WidgetButtonItem,
    onClickWidget: (WidgetParent) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(
                color = PetValues.Colors.get().background,
                shape = rememberPetStyleClip { PetStyle.LOW }
            )
            .clickable { onClickWidget(data) }
    ) {
        PetText(
            text = data.title,
            type = PetTextStyle.DESCRIPTION,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp),
            textColor = PetValues.Colors.get().tertiary
        )
    }
}