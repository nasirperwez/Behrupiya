package com.eramlab.behrupiya.presentation.ui.screens.onboarding.Components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eramlab.behrupiya.R

@Composable
fun TermsAndConditionsText1() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            stringResource(id = R.string.continuing),
            color = Color.White,
            fontSize = 14.sp
        )
        Row(
            modifier = Modifier.offset(y = (-4).dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                stringResource(id = R.string.Terms) + " ",
                color = Color.White,
                fontSize = 14.sp
            )
            Text(
                stringResource(id = R.string.Privacy),
                modifier = Modifier
                    .clickable { },
                color = Color.White,
                fontSize = 14.sp,
                textDecoration = TextDecoration.Underline
            )
        }
    }
}
