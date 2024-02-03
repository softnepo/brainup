package com.lnsantos.brainup.pet

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import com.lnsantos.pet.circle.PetCircle
import com.lnsantos.pet.core.PetStyle
import com.lnsantos.pet.core.border.Enabled
import com.lnsantos.pet.surface.PetSurface
import com.lnsantos.pet.text.PetText
import com.lnsantos.pet.text.PetTextIndicator
import com.lnsantos.pet.text.model.PetTextStyle
import com.lnsantos.pet.theme.PetTheme

class PreviewActivity : ComponentActivity() {

    @OptIn(ExperimentalLayoutApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetTheme {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    contentPadding = PaddingValues(Dp(12f))
                ) {
                    item(1) {
                        Toolbar("Text")
                        PreviewPetText()
                    }
                    item(2) {
                        Toolbar("Text Indicator")
                        PreviewPetTextIndicator()
                    }
                    item(3) {
                        Toolbar("Circle")
                        PreviewPetCircle()
                    }
                    item(4) {
                        Toolbar(text = "Surface")
                        PreviewPetSurface()
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalLayoutApi::class)
    @Composable
    private fun PreviewPetCircle() {
        FlowRow(
            modifier = Modifier.padding(Dp(8f)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PetCircle(
                color = MaterialTheme.colorScheme.primary,
                size = Dp(24f)
            )
            PetCircle(
                color = MaterialTheme.colorScheme.error,
                size = Dp(18f)
            )
            PetCircle(
                color = MaterialTheme.colorScheme.onTertiary,
                size = Dp(12f)
            )
        }
    }

    @Composable
    private fun Toolbar(
        text: String
    ){
        Column(Modifier.fillMaxWidth()) {
            Text(text = text, fontSize = TextUnit(14f, TextUnitType.Sp))
            Row(
                Modifier
                    .height(Dp(2f))
                    .fillMaxWidth()
                    .background(Color.Black)){}
            Spacer(modifier = Modifier.size(Dp(8f)))
        }
    }

    @OptIn(ExperimentalLayoutApi::class)
    @Composable
    private fun PreviewPetText() {
        FlowColumn {
            PetText(
                text = "Example Title",
                type = PetTextStyle.TITLE
            )
            PetText(
                text = "Example subtitle",
                type = PetTextStyle.SUBTITLE
            )
            PetText(
                text = "Example description",
                type = PetTextStyle.DESCRIPTION
            )
        }
    }

    @OptIn(ExperimentalLayoutApi::class)
    @Composable
    private fun PreviewPetTextIndicator() {
        val showToast = {
            Toast.makeText(applicationContext, "Clicked", Toast.LENGTH_LONG).show()
        }
        FlowColumn {
            PetTextIndicator(
                text = "Example Title",
                type = PetTextStyle.TITLE,
                onClick = showToast
            )
            PetTextIndicator(
                text = "Example subtitle",
                type = PetTextStyle.SUBTITLE,
                onClick = showToast
            )
            PetTextIndicator(
                text = "Example description",
                type = PetTextStyle.DESCRIPTION,
                onClick = showToast
            )
        }
    }

    @Preview
    @Composable
    @OptIn(ExperimentalLayoutApi::class)
    private fun PreviewPetSurface() {
        FlowColumn {
            PetSurface(
                modifier = Modifier.size(Dp(100f)),
                background = Color.Green
            ) {}
            Spacer(modifier = Modifier.size(Dp(8f)))
            PetSurface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Dp(60f)),
                background = Color.Green,
                border = Enabled()
            ) {}
            Spacer(modifier = Modifier.size(Dp(8f)))
            PetSurface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Dp(60f)),
                background = Color.Blue,
                style = PetStyle.LOW,
                border = Enabled()
            ) {}
            Spacer(modifier = Modifier.size(Dp(8f)))
            PetSurface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Dp(60f)),
                background = Color.Blue,
                style = PetStyle.MEDIUM,
                border = Enabled()
            ) {}
            Spacer(modifier = Modifier.size(Dp(8f)))
            PetSurface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Dp(60f)),
                background = Color.Blue,
                style = PetStyle.HIGH,
                border = Enabled()
            ) {}
        }
    }

}