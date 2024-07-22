package com.lnsantos.brainup.feature.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.focused
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.requestFocus
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.lnsantos.brainup.R
import com.lnsantos.brainup.feature.card.cardNavigationHost
import com.lnsantos.brainup.feature.deck.deckNavigationHost
import com.lnsantos.brainup.foundation.navigation.Router
import com.lnsantos.pet.core.PetValues
import com.lnsantos.pet.surface.PetSurface
import com.lnsantos.pet.text.PetText
import com.lnsantos.pet.text.model.PetTextStyle
import com.lnsantos.pet.theme.PetTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
        title: String = "",
        showBackButton: Boolean = false,
        onBackStack: () -> Unit = { }
    ) {

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
                .semantics { heading() }
                .animateContentSize()
        ) {

            AnimatedVisibility(
                visible = !showBackButton,
                enter = slideInHorizontally(),
                exit = fadeOut()
            ) {
                Image(
                    modifier = Modifier.height(48.dp),
                    painter = painterResource(id = R.drawable.ic_logo),
                    contentDescription = null,
                    alignment = AbsoluteAlignment.CenterLeft
                )
            }
            AnimatedVisibility(
                visible = showBackButton,
                enter = slideInHorizontally(),
                exit = slideOutHorizontally()
            ) {
                Icon(
                    modifier = Modifier
                        .size(48.dp)
                        .semantics { role = Role.Button }
                        .clickable(onClick = onBackStack, enabled = true),
                    imageVector = Icons.Filled.ArrowBackIos,
                    contentDescription = stringResource(id = R.string.accessibility_toolbar_back),
                    tint = PetValues.Colors.get().tertiary
                )
            }


            PetText(
                text = title,
                type = PetTextStyle.DESCRIPTION,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(alignment = CenterVertically)
                    .semantics {
                        requestFocus { true }
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
        val (showBackButton, setShowBackButton) = remember { mutableStateOf(false) }
        val (showHeader, setHeader) = remember { mutableStateOf(true) }

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .animateContentSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                if (showHeader) {
                    TopHeader(
                        title = stringResource(id = R.string.app_name),
                        showBackButton = showBackButton,
                        onBackStack = { navController.popBackStack() }
                    )
                }

                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box(
                        modifier = Modifier
                            .offset(x = 4.dp, y = 4.dp)
                            .padding(16.dp)
                            .shadow(elevation = 5.dp, shape = RoundedCornerShape(12.dp))
                            .background(PetValues.Colors.get().secondary)
                            .fillMaxSize(),
                        content = { }
                    )
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
                        homeNavigationHost(
                            init = {
                                setShowBackButton.invoke(false)
                                setHeader.invoke(true)
                            },
                            onClickWidget = { navController.navigate(it.deeplink) },
                            onClickMain = { }
                        )
                        deckNavigationHost(
                            init = {
                                setShowBackButton.invoke(true)
                                setHeader.invoke(true)
                            },
                            onDeckSelected = { navController.navigate("cards/$this") }
                        )
                        cardNavigationHost(
                            init = { setHeader.invoke(false) },
                            onBackScreen = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}