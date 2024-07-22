package com.lnsantos.brainup.feature.card.modal

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.lnsantos.pet.button.PetTextButton
import com.lnsantos.pet.core.PetValues
import com.lnsantos.pet.text.PetText
import com.lnsantos.pet.text.model.PetTextStyle

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewCardBottomSheet(
    sheetState: SheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    ),
    onDismiss: () -> Unit,
    onCreate: (String, String) -> Unit,
    enabled: Boolean = true,
    frontInit: String = "",
    hiddenInit: String = "",
    descriptionFront: String = "",
    descriptionHidden: String = "",
    buttonText: String = "",
    title: String
) {
    ModalBottomSheet(
        modifier = Modifier.fillMaxWidth(),
        onDismissRequest = { onDismiss() },
        sheetState = sheetState,
        containerColor = PetValues.Colors.get().onTertiary,
        shape = RoundedCornerShape(CornerSize(16.dp)),
        dragHandle = { }
    ) {

        val (textFront, setTextFront) = remember { mutableStateOf(frontInit) }
        val (textHidden, setTextHidden) = remember { mutableStateOf(hiddenInit) }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                PetText(
                    text = title,
                    type = PetTextStyle.TITLE,
                    modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
                )

                PetText(
                    text = descriptionFront,
                    type = PetTextStyle.DESCRIPTION,
                    modifier = Modifier.fillMaxWidth()
                )
                EditText(
                    modifier = Modifier.fillMaxWidth(),
                    text = textFront,
                    onValueChange = setTextFront,
                    enabled = enabled
                )

                PetText(
                    text = descriptionHidden,
                    type = PetTextStyle.DESCRIPTION,
                    modifier = Modifier.fillMaxWidth()
                )
                EditText(
                    modifier = Modifier.fillMaxWidth(),
                    text = textHidden,
                    onValueChange = setTextHidden,
                    enabled = enabled
                )
                PetTextButton(
                    onClick = { onCreate(textFront, textHidden) },
                    modifier = Modifier.fillMaxWidth().padding(top = 32.dp),
                    text = buttonText,
                    enabled = textFront.isNotEmpty() && textHidden.isNotEmpty()
                )
            }
        }
    }
}


@Composable
private fun EditText(
    modifier: Modifier = Modifier,
    text: String = String(),
    enabled: Boolean = false,
    onValueChange: String.() -> Unit
) {
    Column(
        modifier = modifier
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent),
            value = text,
            shape = RoundedCornerShape(0.dp),
            onValueChange = { onValueChange(it) },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                autoCorrect = false
            ),
            enabled = enabled
        )
    }
}
