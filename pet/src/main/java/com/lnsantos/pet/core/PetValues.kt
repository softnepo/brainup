package com.lnsantos.pet.core

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.lnsantos.pet.R

sealed class PetValues {

    object Colors : PetValues() {
        val light = lightColors(
            primary = Primary,
            primaryVariant = PrimaryVariant,
            secondary = Secondary,
            secondaryVariant = SecondaryVariant,
            background = Background,
            error = Error
        )

        val dark = darkColors(
            primary = PrimaryDark,
            primaryVariant = PrimaryVariantDark,
            secondary = SecondaryDark,
            secondaryVariant = SecondaryVariantDark,
            background = BackgroundDark,
            error = ErrorDark
        )
    }

    object FontFamily : PetValues() {
        val default = FontFamily(
            Font(resId = R.font.inter_regular, weight = FontWeight.Normal),
            Font(resId = R.font.inter_bold, weight = FontWeight.Bold),
            Font(resId = R.font.inter_extra_bold, weight = FontWeight.ExtraBold),
            Font(resId = R.font.inter_semi_bold, weight = FontWeight.SemiBold),
            Font(resId = R.font.inter_black, weight = FontWeight.Black),
            Font(resId = R.font.inter_light, weight = FontWeight.Light),
            Font(resId = R.font.inter_extra_light, weight = FontWeight.ExtraLight),
            Font(resId = R.font.inter_medium, weight = FontWeight.Medium),
            Font(resId = R.font.inter_thin, weight = FontWeight.Thin)
        )
    }

    object FontSize : PetValues() {
        val x1 = 4.sp
        val x2 = 8.sp
        val x3 = 12.sp
        val x4 = 16.sp
        val x5 = 20.sp
        val x6 = 24.sp
        val x7 = 28.sp
        val x8 = 32.sp
        val x9 = 36.sp
        val x10 = 40.sp
    }

    object Spacing : PetValues() {
        val x1 = 4.dp
        val x2 = 8.dp
        val x3 = 12.dp
        val x4 = 16.dp
        val x5 = 20.dp
        val x6 = 24.dp
        val x7 = 28.dp
        val x8 = 32.dp
        val x9 = 36.dp
        val x10 = 40.dp
    }

    object Size : PetValues() {
        val iconLow = Spacing.x4
        val iconMedium = Spacing.x6
        val iconHigh = Spacing.x9
    }
}
