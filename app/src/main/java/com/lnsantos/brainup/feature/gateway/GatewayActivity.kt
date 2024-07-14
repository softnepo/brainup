package com.lnsantos.brainup.feature.gateway

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.lnsantos.brainup.feature.home.HomeActivity
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

                GatewayScreen(
                    onNextClick = { viewmodel.create(this) },
                    isLoading = state.value.isLoading
                )

                if (state.value.next) {
                    val intent = Intent(this, HomeActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                    }

                    startActivity(intent)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
    }

}
