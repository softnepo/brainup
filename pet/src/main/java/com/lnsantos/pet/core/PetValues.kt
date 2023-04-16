package com.lnsantos.pet.core

import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lnsantos.pet.R

public sealed class PetValues {

    object Typographies : PetValues() {
        val extraBold = TextStyle(
            fontFamily = FontFamily.default,
            fontWeight = FontWeight.ExtraBold
        )

        val bold = TextStyle(
            fontFamily = FontFamily.default,
            fontWeight = FontWeight.Bold
        )

        val semiBold = TextStyle(
            fontFamily = FontFamily.default,
            fontWeight = FontWeight.SemiBold
        )

        val normal = TextStyle(
            fontFamily = FontFamily.default,
            fontWeight = FontWeight.Normal
        )

        val black = TextStyle(
            fontFamily = FontFamily.default,
            fontWeight = FontWeight.Black
        )

        val medium = TextStyle(
            fontFamily = FontFamily.default,
            fontWeight = FontWeight.Medium
        )

        val thin = TextStyle(
            fontFamily = FontFamily.default,
            fontWeight = FontWeight.Thin
        )

        val light = TextStyle(
            fontFamily = FontFamily.default,
            fontWeight = FontWeight.Light
        )

        val extraLight = TextStyle(
            fontFamily = FontFamily.default,
            fontWeight = FontWeight.ExtraLight
        )

        val typography = Typography(
            displayLarge = extraBold,
            displayMedium = bold,
            displaySmall = semiBold,
            headlineLarge = extraBold,
            headlineMedium = bold,
            headlineSmall = semiBold,
            titleLarge = bold,
            titleMedium = medium,
            titleSmall = normal,
            bodyLarge = medium,
            bodyMedium = thin,
            bodySmall = light,
            labelLarge = black,
            labelMedium = medium,
            labelSmall = extraLight
        )
    }
    object Colors : PetValues() {
        val light = lightColorScheme(
            primary = Primary,
            onSurfaceVariant = PrimaryVariant,
            secondary = Secondary,
            surfaceVariant = SecondaryVariant,
            background = Background,
            error = Error,
            surface = Background
        )

        val dark = darkColorScheme(
            primary = PrimaryDark,
            onSurfaceVariant = PrimaryVariantDark,
            secondary = SecondaryDark,
            surfaceVariant = SecondaryVariantDark,
            background = BackgroundDark,
            error = ErrorDark,
            surface = BackgroundDark
        )

        fun getColorsByScheme(isDark: Boolean) = if (isDark) dark else light
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

    object SizeValues : PetValues() {
        val x1 = 4
        val x2 = 8
        val x3 = 12
        val x4 = 16
        val x5 = 20
        val x6 = 24
        val x7 = 28
        val x8 = 32
        val x9 = 36
        val x10 = 40
    }

    object FontSize : PetValues() {
        val x1 = SizeValues.x1.sp
        val x2 = SizeValues.x2.sp
        val x3 = SizeValues.x3.sp
        val x4 = SizeValues.x4.sp
        val x5 = SizeValues.x5.sp
        val x6 = SizeValues.x6.sp
        val x7 = SizeValues.x7.sp
        val x8 = SizeValues.x8.sp
        val x9 = SizeValues.x9.sp
        val x10 = SizeValues.x10.sp

        val Low = x4
        val Medium = x6
        val High = x9
    }

    object Spacing : PetValues() {
        val x1 = SizeValues.x1.dp
        val x2 = SizeValues.x2.dp
        val x3 = SizeValues.x3.dp
        val x4 = SizeValues.x4.dp
        val x5 = SizeValues.x5.dp
        val x6 = SizeValues.x6.dp
        val x7 = SizeValues.x7.dp
        val x8 = SizeValues.x8.dp
        val x9 = SizeValues.x9.dp
        val x10 = SizeValues.x10.dp

        val Low = x4
        val Medium = x6
        val High = x9
    }

    object Size : PetValues() {
        val iconLow = Spacing.x4
        val iconMedium = Spacing.x6
        val iconHigh = Spacing.x9
    }
}
