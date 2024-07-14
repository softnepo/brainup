package com.lnsantos.brainup.feature.gateway

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.invisibleToUser
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.lnsantos.brainup.R
import com.lnsantos.pet.core.Terliary
import com.lnsantos.pet.surface.factory.strategy.clip.PetSurfaceHighClip
import com.lnsantos.pet.text.PetText
import com.lnsantos.pet.text.model.PetTextStyle

@Composable
fun GatewayScreen(
    onNextClick: String.() -> Unit,
    isLoading: Boolean = false
) {
    var text by remember { mutableStateOf(String()) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp)
        ) {
            HeaderLogo()
            HeaderToolbar()
            NameEditText(
                modifier = Modifier.padding(top = 40.dp),
                text = text,
                onValueChange = { text = this }
            )
        }

        if (!isLoading) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(
                    modifier = Modifier.size(60.dp).background(
                        color = MaterialTheme.colorScheme.surface,
                        shape = PetSurfaceHighClip().create()
                    ),
                    enabled = text.length > 3,
                    onClick = { onNextClick(text) }
                ) {
                    Icon(
                        modifier = Modifier
                            .fillMaxSize(0.75F),
                        imageVector = Icons.Filled.ArrowForwardIos,
                        contentDescription = null,
                        tint = Terliary
                    )
                }
            }
        }
    }
}

@Composable
private fun NameEditText(
    modifier: Modifier = Modifier,
    maxLength: Int = 15,
    text: String = String(),
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
            maxLines = 1
        )

        PetText(
            modifier = Modifier.align(Alignment.End),
            text = "${currentCharacter}/$maxLength",
            type = PetTextStyle.DESCRIPTION
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun HeaderLogo() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp)
            .semantics { invisibleToUser() },
        contentAlignment = Alignment.CenterEnd
    ) {
        Image(
            modifier = Modifier.height(48.dp),
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null,
            alignment = AbsoluteAlignment.CenterLeft
        )
    }
}

@Composable
private fun HeaderToolbar() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        PetText(
            text = stringResource(id = R.string.gateway_title),
            type = PetTextStyle.TITLE
        )
        PetText(
            text = stringResource(id = R.string.gateway_description),
            type = PetTextStyle.DESCRIPTION
        )
    }
}