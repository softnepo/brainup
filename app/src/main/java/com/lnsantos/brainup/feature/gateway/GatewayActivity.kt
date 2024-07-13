package com.lnsantos.brainup.feature.gateway

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.lnsantos.pet.theme.PetTheme

class GatewayActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetTheme {
                GatewayScreen {

                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
    }

}
