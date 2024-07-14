package com.lnsantos.brainup.feature.launcher

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.lnsantos.brainup.feature.launcher.type.NextDirection
import com.lnsantos.brainup.foundation.navigation.RouterIntent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class LauncherActivity : ComponentActivity() {
    
    private val viewmodel: LauncherViewModel by viewModels()
    @Inject lateinit var routerIntent: RouterIntent

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        splashScreen.setKeepOnScreenCondition { true }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewmodel.direction.collect { direction ->
                    when (direction) {
                        NextDirection.HOME -> routerIntent.startHomeActivity()
                        NextDirection.GATEWAY -> routerIntent.startGatewayActivity()
                        else -> Log.d("sd", "init process")
                    }

                    if (direction != null) finish()
                }
            }
        }
    }
}