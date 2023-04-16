package com.lnsantos.brainup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import com.lnsantos.pet.text.PetText
import com.lnsantos.pet.text.model.PetTextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
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