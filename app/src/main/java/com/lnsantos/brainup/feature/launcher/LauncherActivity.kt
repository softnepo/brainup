package com.lnsantos.brainup.feature.launcher

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import com.lnsantos.brainup.feature.gateway.GatewayActivity
import com.lnsantos.pet.surface.PetSurface
import com.lnsantos.pet.text.PetText
import com.lnsantos.pet.text.model.PetTextStyle
import com.lnsantos.pet.theme.PetTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LauncherActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetTheme {
                PetSurface {

                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        startActivity(Intent(this, GatewayActivity::class.java).apply {
            flags = FLAG_ACTIVITY_CLEAR_TOP or FLAG_ACTIVITY_NEW_TASK
        })
        finish()
    }
}