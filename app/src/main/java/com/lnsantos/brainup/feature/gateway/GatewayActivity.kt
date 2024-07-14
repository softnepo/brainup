package com.lnsantos.brainup.feature.gateway

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.lnsantos.brainup.feature.home.HomeActivity
import com.lnsantos.pet.surface.PetSurface
import com.lnsantos.pet.theme.PetTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GatewayActivity : ComponentActivity() {

    private val viewmodel : GatewayViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetTheme {
                val state = viewmodel.state.collectAsState()

                PetSurface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    GatewayScreen(
                        onNextClick = { viewmodel.create(this) },
                        isLoading = state.value.isLoading
                    )
                }

                if (state.value.next) {
                    val intent = Intent(this, HomeActivity::class.java).apply {
                        flags = FLAG_ACTIVITY_CLEAR_TOP or FLAG_ACTIVITY_NEW_TASK
                    }
                    startActivity(intent)
                    finish()
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
    }

}
