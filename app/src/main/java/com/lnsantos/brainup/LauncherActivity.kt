package com.lnsantos.brainup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import com.lnsantos.pet.surface.PetSurface
import com.lnsantos.pet.text.PetText
import com.lnsantos.pet.text.model.PetTextStyle
import com.lnsantos.pet.theme.PetTheme

class LauncherActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetTheme {
                PetSurface {
                    Column {
                        PetText(
                            text = "Hello",
                            type = PetTextStyle.TITLE
                        )
                        PetText(
                            text = "Hello",
                            type = PetTextStyle.SUBTITLE
                        )
                        PetText(
                            text = "Hello",
                            type = PetTextStyle.DESCRIPTION
                        )
                    }
                }
            }
        }
    }
}