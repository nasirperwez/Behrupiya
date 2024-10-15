package com.eramlab.behrupiya.presentation.ui.screens.homescreen.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.eramlab.behrupiya.R
import kotlinx.coroutines.delay

@Composable
fun FeaturedContent(modifier: Modifier = Modifier) {
    Spacer(modifier = Modifier.padding(top = 5.dp))
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 30.dp, vertical = 5.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        item {
            // Call the reusable carousel for each row
            ImageCarouselRow(
                imageList = listOf(
                    painterResource(id = R.drawable.output_30),
                    painterResource(id = R.drawable.output_31),
                    painterResource(id = R.drawable.output_32),
                    painterResource(id = R.drawable.output_33),
                    painterResource(id = R.drawable.output_34),
                    painterResource(id = R.drawable.output_35),
                    painterResource(id = R.drawable.output_36),
                    painterResource(id = R.drawable.output_37),
                    painterResource(id = R.drawable.output_38),
                    painterResource(id = R.drawable.output_39)

                ),
                backgroundPainter = painterResource(id = R.drawable.digital),
                startDelay = 0
            )
            Spacer(modifier = Modifier.padding(start = 10.dp))

            ImageCarouselRow(
                imageList = listOf(

                    painterResource(id = R.drawable.output_0),
                    painterResource(id = R.drawable.output_1),
                    painterResource(id = R.drawable.output_2),
                    painterResource(id = R.drawable.output_3),
                    painterResource(id = R.drawable.output_4),
                    painterResource(id = R.drawable.output_5),
                    painterResource(id = R.drawable.output_6),
                    painterResource(id = R.drawable.output_7),
                    painterResource(id = R.drawable.output_8),
                    painterResource(id = R.drawable.output_9)
                ),
                backgroundPainter = painterResource(id = R.drawable.book),
                startDelay = 500
            )
            Spacer(modifier = Modifier.padding(start = 10.dp))

            ImageCarouselRow(
                imageList = listOf(
                    painterResource(id = R.drawable.output_60),
                    painterResource(id = R.drawable.output_61),
                    painterResource(id = R.drawable.output_62),
                    painterResource(id = R.drawable.output_63),
                    painterResource(id = R.drawable.output_64),
                    painterResource(id = R.drawable.output_65),
                    painterResource(id = R.drawable.output_66),
                    painterResource(id = R.drawable.output_67),
                    painterResource(id = R.drawable.output_68),
                    painterResource(id = R.drawable.output_69),
                    painterResource(id = R.drawable.output_70),
                    painterResource(id = R.drawable.output_71),
                ),
                backgroundPainter = painterResource(id = R.drawable.pencilart),
                startDelay = 150
            )
            Spacer(modifier = Modifier.padding(start = 10.dp))
            ImageCarouselRow(
                imageList = listOf(
                    painterResource(id = R.drawable.output_40),
                    painterResource(id = R.drawable.output_41),
                    painterResource(id = R.drawable.output_42),
                    painterResource(id = R.drawable.output_43),
                    painterResource(id = R.drawable.output_44),
                    painterResource(id = R.drawable.output_45),
                    painterResource(id = R.drawable.output_46),
                    painterResource(id = R.drawable.output_47),
                    painterResource(id = R.drawable.output_48),
                    painterResource(id = R.drawable.output_49)
                ),
                backgroundPainter = painterResource(id = R.drawable.fantasy),
                startDelay = 500
            )
            Spacer(modifier = Modifier.padding(start = 10.dp))
            ImageCarouselRow(
                imageList = listOf(
                    painterResource(id = R.drawable.output_20),
                    painterResource(id = R.drawable.output_21),
                    painterResource(id = R.drawable.output_22),
                    painterResource(id = R.drawable.output_23),
                    painterResource(id = R.drawable.output_24),
                    painterResource(id = R.drawable.output_25),
                    painterResource(id = R.drawable.output_26),
                    painterResource(id = R.drawable.output_27),
                    painterResource(id = R.drawable.output_28),
                    painterResource(id = R.drawable.output_29)
                ),
                backgroundPainter = painterResource(id = R.drawable.disneyart),
                startDelay = 50
            )
            Spacer(modifier = Modifier.padding(start = 10.dp))
            ImageCarouselRow(
                imageList = listOf(
                    painterResource(id = R.drawable.output_50),
                    painterResource(id = R.drawable.output_51),
                    painterResource(id = R.drawable.output_52),
                    painterResource(id = R.drawable.output_53),
                    painterResource(id = R.drawable.output_54),
                    painterResource(id = R.drawable.output_55),
                    painterResource(id = R.drawable.output_56),
                    painterResource(id = R.drawable.output_57),
                    painterResource(id = R.drawable.output_58),
                    painterResource(id = R.drawable.output_59)
                ),
                backgroundPainter = painterResource(id = R.drawable.neonpunk),
                startDelay = 1500
            )
            Spacer(modifier = Modifier.padding(start = 10.dp))
            ImageCarouselRow(
                imageList = listOf(
                    painterResource(id = R.drawable.output_10),
                    painterResource(id = R.drawable.output_11),
                    painterResource(id = R.drawable.output_12),
                    painterResource(id = R.drawable.output_13),
                    painterResource(id = R.drawable.output_14),
                    painterResource(id = R.drawable.output_15),
                    painterResource(id = R.drawable.output_16),
                    painterResource(id = R.drawable.output_17),
                    painterResource(id = R.drawable.output_18),
                    painterResource(id = R.drawable.output_19)
                ),
                backgroundPainter = painterResource(id = R.drawable.lineart),
                startDelay = 100
            )

        }
    }
}

@Composable
fun ImageCarouselRow(
    imageList: List<Painter>,
    backgroundPainter: Painter,
    durationMillis: Int = 2000,
    startDelay: Long = 0 // Add start delay as a parameter
) {
    var currentImageIndex by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        delay(startDelay)
        while (true) {
            delay(durationMillis.toLong()) // Adjust timing for crossfade
            currentImageIndex = (currentImageIndex + 1) % imageList.size
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        // Foreground animated image
        Image(
            painter = imageList[currentImageIndex],
            contentDescription = null,
            modifier = Modifier
                .clip(RoundedCornerShape(13.dp)) // Apply rounded corners
        )

        // Background static image
        Image(
            painter = backgroundPainter,
            contentDescription = null
        )
    }
}
