package com.lnsantos.brainup.feature.deck.modal

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
fun SimpleModelBottomSheet(
    sheetState: SheetState = rememberModalBottomSheetState(),
    onDismiss: () -> Unit,
    onCreate: (String) -> Unit,
    enabled: Boolean = true,
    textInit: String = "",
    description: String = "",
    buttonText: String = ""
) {
    ModalBottomSheet(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
        onDismissRequest = { onDismiss() },
        sheetState = sheetState,
        containerColor = PetValues.Colors.get().onTertiary,
        shape = RoundedCornerShape(CornerSize(16.dp)),
        dragHandle = { }
    ) {

        val (text, setText) = remember { mutableStateOf(textInit) }

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
                    text = description,
                    type = PetTextStyle.DESCRIPTION,
                    modifier = Modifier.fillMaxWidth()
                )

                NameEditText(
                    modifier = Modifier.fillMaxWidth(),
                    maxLength = 20,
                    text = text,
                    onValueChange = setText,
                    enabled = enabled
                )
            }

            PetTextButton(
                onClick = { onCreate(text) },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                text = buttonText,
                enabled = text.length > 3
            )
        }
    }
}

// create component in pet
@Composable
private fun NameEditText(
    modifier: Modifier = Modifier,
    maxLength: Int = 15,
    text: String = String(),
    enabled: Boolean = false,
    onValueChange: String.() -> Unit
) {
    Column(
        modifier = modifier
    ) {
        var currentCharacter by remember { mutableIntStateOf(text.length) }

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent),
            value = text,
            shape = RoundedCornerShape(0.dp),
            onValueChange = {
                if (it.length <= maxLength) {
                    onValueChange(it)
                }
                currentCharacter = it.length
            },
            singleLine = true,
            maxLines = 1,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                autoCorrect = false
            ),
            enabled = enabled
        )

        PetText(
            modifier = Modifier.align(Alignment.End),
            text = "${currentCharacter}/$maxLength",
            type = PetTextStyle.DESCRIPTION
        )
    }
}
