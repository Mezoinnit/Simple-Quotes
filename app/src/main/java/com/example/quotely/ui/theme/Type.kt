package com.example.quotely.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.quotely.R

val nunitoLight = FontFamily(Font(R.font.nunitolight))

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = nunitoLight,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 26.sp,
        letterSpacing = 0.2.sp,
        textAlign = TextAlign.Left
    ),
    bodyMedium = TextStyle(
        fontFamily = nunitoLight,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.175.sp
    ),
    bodySmall = TextStyle(
        fontFamily = nunitoLight,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.15.sp
    ),
    titleLarge = TextStyle(
        fontFamily = nunitoLight,
        fontSize = 32.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = nunitoLight,
        fontSize = 24.sp,
    ),
    titleSmall = TextStyle(
        fontFamily = nunitoLight,
        fontSize = 16.sp,
    ),

    )