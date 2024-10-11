package com.example.quotely.qutotely.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quotely.ui.theme.nunitoLight


@Composable
fun QuoteScreen(vm: QuotesViewModel = viewModel()) {
    val visible1 by vm.visible.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(false, Dp.Unspecified, MaterialTheme.colorScheme.onBackground)
            ) {
                vm.nextQuote()
            },
    ) {
        AnimatedVisibility(
            visible = visible1,
            enter = fadeIn(tween(250)),
            exit = fadeOut(tween(250))
        ) {
            QuoteView(vm.quote.collectAsState())
        }
    }
}

@Composable
private fun QuoteView(quote: State<String>) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            quote.value,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontFamily = nunitoLight,
                fontSize = 22.sp,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun QuoteScreenPreview() {
    QuoteScreen()
}