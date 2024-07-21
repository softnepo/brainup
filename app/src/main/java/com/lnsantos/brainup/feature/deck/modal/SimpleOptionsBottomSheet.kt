package com.lnsantos.brainup.feature.deck.modal

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.lnsantos.pet.core.PetValues
import com.lnsantos.pet.text.PetText
import com.lnsantos.pet.text.model.PetTextStyle

data class SimpleOption<T>(
    val data: T,
    val title: String,
    val icon: ImageVector? = null
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> SimpleOptionsBottomSheet(
    options: List<SimpleOption<T>>,
    onDismissRequest: () -> Unit,
    onClick: (T) -> Unit
) {
    ModalBottomSheet(
        sheetState = rememberModalBottomSheetState(
            skipPartiallyExpanded = true,
            confirmValueChange = {
                if (it != SheetValue.PartiallyExpanded) {
                    onDismissRequest()
                    true
                } else {
                    false
                }
            }
        ),
        onDismissRequest = onDismissRequest
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            items(options) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .padding(8.dp)
                        .clickable { onClick(it.data) }
                        .background(
                            color = PetValues.Colors.get().tertiary,
                            shape = RoundedCornerShape(6.dp)
                        )
                        .padding(start = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    it.icon?.run {
                        Icon(
                            imageVector =  this,
                            contentDescription = null
                        )
                    }
                    PetText(
                        text = it.title,
                        type = PetTextStyle.DESCRIPTION,
                        textColor = PetValues.Colors.getNegative().tertiary
                    )
                }

            }
        }
    }
}