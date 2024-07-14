package com.lnsantos.brainup.feature.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.focused
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.requestFocus
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lnsantos.brainup.R
import com.lnsantos.brainup.feature.home.widgets.WidgetMemory
import com.lnsantos.brainup.foundation.navigation.Router
import com.lnsantos.pet.button.PetButton
import com.lnsantos.pet.core.PetValues
import com.lnsantos.pet.surface.PetSurface
import com.lnsantos.pet.text.PetText
import com.lnsantos.pet.text.model.PetTextStyle
import com.lnsantos.pet.theme.PetTheme

class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetTheme {
                PetSurface {
                    Content()
                }
            }
        }
    }

    @Composable
    @Preview
    private fun TopHeader(
        modifier: Modifier = Modifier,
        title: String = ""
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
                .semantics { heading() }
        ) {
            Image(
                modifier = Modifier.height(48.dp),
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = null,
                alignment = AbsoluteAlignment.CenterLeft
            )

            PetText(
                text = title,
                type = PetTextStyle.DESCRIPTION,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(alignment = CenterVertically)
                    .semantics {
                        requestFocus { true}
                        heading()
                        focused = true
                    }
            )
        }
    }

    @Composable
    @Preview
    private fun Content() {
        val navController = rememberNavController()

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                TopHeader(title = stringResource(id = R.string.app_name))

                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box(
                        modifier = Modifier
                            .offset(x = 4.dp, y = 4.dp)
                            .padding(16.dp)
                            .shadow(
                                elevation = 5.dp,
                                shape = RoundedCornerShape(12.dp)
                            )
                            .background(PetValues.Colors.get().secondary)
                            .fillMaxSize()
                    ) {}
                    NavHost(
                        navController = navController,
                        startDestination = Router.HOME.router,
                        modifier = Modifier
                            .padding(16.dp)
                            .shadow(
                                elevation = 5.dp,
                                shape = RoundedCornerShape(12.dp)
                            )
                            .fillMaxSize()
                    ) {
                        composable(route = Router.HOME.router) {
                            HomeScreen(
                                widgets = WidgetMemory.getWidget(),
                                onClickWidget = { navController.navigate(it.deeplink) },
                                onClickMain = { }
                            )
                        }
                        composable(route = Router.MY_CARD.router) {
                            HomeScreen(
                                widgets = listOf(),
                                onClickWidget = { navController.navigate(it.deeplink) },
                                onClickMain = { }
                            )
                        }
                    }
                }
            }
        }
    }
}