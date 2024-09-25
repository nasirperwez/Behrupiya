package com.eramlab.behrupiya.presentation.ui.screens.generate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.eramlab.behrupiya.presentation.ui.screens.generate.component.GenerateCard
import com.eramlab.behrupiya.presentation.ui.screens.generate.component.GenerateAndSave


@Composable
fun GenerateImageScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xC3202027))
    )
    {
        GenerateAndSave(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(0.7f)
        )
        GenerateCard(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(0.3f)


        )

    }
}


//    val color = remember {
//        mutableStateOf(Color(0xC3202027))
//    }
//    var showDialog by remember { mutableStateOf(false) }
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(color.value)
//    ) {
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxHeight(0.10f)
//                .background(color = Color(0xC3202027))
//        ) {
//            Row(modifier = Modifier.padding(top = 10.dp)) {
//                IconButton(
//                    onClick = { },
//                    modifier = Modifier
//                        .padding(start = 15.dp, top = 22.dp)
//
//                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.back_icn),
//                        contentDescription = null,
//
//
//                        )
//
//                }
//
//                Row(modifier = Modifier.padding(start = 60.dp, top = 12.dp)) {
//                    Text(
//                        text = "Sikh",
//                        modifier = Modifier.padding(top = 23.dp),
//                        fontSize = 20.sp,
//                        color = Color.White
//                    )
//                    GenerateTextSelect()
//                }
//                IconButton(
//                    onClick = { },
//                    modifier = Modifier
//                        .padding(start = 8.dp, top = 22.dp)
//
//                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.gallery_icn),
//                        contentDescription = null,
//
//
//                        )
//
//                }
//
//            }
//
//        }
//
//        // 2nd Box
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxHeight(0.72f)
//                .clip(
//                    RoundedCornerShape(
//                        bottomStart = 20.dp,
//                        bottomEnd = 20.dp
//                    )
//                )
//                .background(color = Color(0xC3202027))
//        )
//        {
//
//            Card(
//                modifier = Modifier
//
//                    .padding(top = 10.dp, start = 37.dp, end = 37.dp)
//                    .fillMaxWidth()
//                    .fillMaxHeight(0.70f)
//
//                    .shadow(elevation = 0.dp, shape = RoundedCornerShape(15.dp))
//
//
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.aa),
//                    contentDescription = null, modifier = Modifier.fillMaxSize()
//
//
//                )
//
//
//            }
//
//
//            Box(
//                modifier = Modifier
//                    .padding(top = 20.dp, start = 40.dp)
//                    .height(50.dp)
//                    .width(100.dp)
//                    .clickable { }
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.button),
//                    contentDescription = null, modifier = Modifier.fillMaxSize()
//                )
//                Text(
//                    text = "Self Edit",
//                    modifier = Modifier.align(Alignment.Center),
//                    color = Color.White
//                )
//            }
//            Box(
//                modifier = Modifier
//                    .padding(top = 20.dp, start = 300.dp)
//                    .height(50.dp)
//                    .width(50.dp)
//                    .clickable { }
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.icn),
//                    contentDescription = null, modifier = Modifier.fillMaxSize()
//                )
//            }
//
//            Image(
//                painter = painterResource(id = R.drawable.header_logo),
//                contentDescription = null, modifier = Modifier
//                    .padding(top = 320.dp, start = 280.dp)
//                    .size(70.dp)
//            )
//
//
//            Column {
//                Spacer(modifier = Modifier.padding(top = 420.dp))
//                Box(
//                    modifier = Modifier
//                        .padding(start = 50.dp, end = 50.dp)
//                        .clip(
//                            RoundedCornerShape(
//                                30.dp
//                            )
//                        )
//                        .background(color = Color(0xC3202027))
//                        .height(50.dp)
//                        .fillMaxWidth()
//
//                ) {
//                    Row {
//                        Box(
//                            modifier = Modifier
//                                .clip(
//                                    RoundedCornerShape(
//                                        30.dp
//                                    )
//                                )
//                                .background(color = Color(0xFF77B4D8))
//                                .height(50.dp)
//                                .fillMaxWidth(0.70f)
//                                .clickable { }
//
//                        )
//                        {
//                            Text(
//                                text = "Generate",
//                                modifier = Modifier.align(Alignment.Center),
//                                color = Color.White,
//                                fontSize = 15.sp
//                            )
//                        }
//                        Box(
//                            modifier = Modifier
//                                .clip(
//                                    RoundedCornerShape(
//                                        30.dp
//                                    )
//                                )
//                                .background(color = Color.Transparent)
//                                .height(50.dp)
//                                .fillMaxWidth()
//                                .clickable { }
//
//                        ) {
//                            Image(
//                                painter = painterResource(id = R.drawable.add_img),
//                                contentDescription = null,
//                                modifier = Modifier.align(Alignment.Center)
//                            )
//                        }
//
//
//                    }
//                }
//                Spacer(modifier = Modifier.padding(top = 15.dp))
//                Box(
//                    modifier = Modifier
//                        .padding(start = 50.dp, end = 50.dp)
//                        .clip(
//                            RoundedCornerShape(
//                                30.dp
//                            )
//                        )
//                        .background(color = Color(0xC3202027))
//                        .height(50.dp)
//                        .fillMaxWidth()
//                        .clickable { showDialog = true }
//
//                )
//                {
//                    Text(
//                        text = "Save / Share",
//                        modifier = Modifier.align(Alignment.Center),
//                        color = Color.White,
//                        fontSize = 15.sp
//                    )
//                }
//                if (showDialog) {
//                    SaveAndSheare(onDismiss = { showDialog = false })
//                }
//
//
//            }
//
//
//        }
//        // 3rd Box
//        Box(
//            modifier = Modifier
//        ) {
//
//            GenerateCard()
//
//        }
//    }
//
//}


//@Composable
//fun SaveAndSheare(onDismiss: () -> Unit) {
//    var selectedBox by remember { mutableStateOf<String?>(null) }
//    Dialog(
//        onDismissRequest = { onDismiss() }, properties = DialogProperties(
//            dismissOnBackPress = true,
//            dismissOnClickOutside = true,
//            usePlatformDefaultWidth = false // Makes the dialog full screen if needed
//        )
//    ) {
//        Box(
//            modifier = Modifier
//                .padding(top = 150.dp, start = 20.dp, end = 20.dp)
//                .clip(
//                    RoundedCornerShape(
//                        topEnd = 30.dp,
//                        topStart = 30.dp,
//
//                        )
//                )
//                .fillMaxSize()
//                .background(Color(0xF225282C)) // Semi-transparent background
//                .clickable { onDismiss() }, // Dismiss when clicking outside
//            //contentAlignment = Alignment.Center
//        ) {
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .fillMaxHeight(0.60f)
//                    .padding(30.dp)
//                    .clip(
//                        RoundedCornerShape(
//                            30.dp
//                        )
//                    )
//                    .background(color = Color(0xF29B87C0))
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.aa),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .align(Alignment.Center)
//                )
//            }
//            Image(painter = painterResource(id = R.drawable.close_icn),
//                contentDescription = null,
//                modifier = Modifier
//                    .padding(top = 10.dp, start = 320.dp)
//                    .size(20.dp)
//                    .clickable { }
//
//            )
//            Column(modifier = Modifier.padding(top = 390.dp)) {
//
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(50.dp)
//                        .background(color = Color.Black)
//                ) {
//                    Box(
//                        modifier = Modifier
//                            .fillMaxHeight()
//                            .weight(1f) // Use weight to take up half the width
//                            .background(
//                                if (selectedBox == "video") Color.Transparent else Color(
//                                    0xEB363434
//                                )
//                            )
//                            .clickable { selectedBox = "video" },
//                        contentAlignment = Alignment.Center
//                    ) {
//                        Text(
//                            text = "Video",
//                            color = if (selectedBox == "video") Color.Blue else Color(0xEBB5AEC9)
//                        )
//                    }
//                    Box(
//                        modifier = Modifier
//                            .fillMaxHeight()
//                            .weight(1f) // Use weight to take up the remaining half
//                            .background(
//                                if (selectedBox == "photo") Color.Transparent else Color(
//                                    0xEB363434
//                                )
//                            )
//                            .clickable { selectedBox = "photo" },
//                        contentAlignment = Alignment.Center // Center the text
//                    ) {
//                        Text(
//                            text = "Photo",
//                            color = if (selectedBox == "photo") Color.Blue else Color(0xEBB5AEC9)
//                        )
//                    }
//
//
//                }
//                var isFirstSwitchChecked by remember { mutableStateOf(false) }
//                var isSecondSwitchChecked by remember { mutableStateOf(false) }
//                Row {
//                    Text(
//                        text = "Watermark",
//                        modifier = Modifier.padding(start = 30.dp, top = 30.dp),
//                        color = Color.White
//                    )
//                    Switch(
//                        checked = isFirstSwitchChecked, onCheckedChange = {
//                            isFirstSwitchChecked = it
//                            if (it) {
//                                isSecondSwitchChecked = false
//                            }
//                        }, modifier = Modifier.padding(16.dp)
//                    )
//
//                    Text(
//                        text = "HD Quality",
//                        modifier = Modifier.padding(top = 30.dp),
//                        color = Color.White
//                    )
//                    Switch(
//                        checked = isSecondSwitchChecked, onCheckedChange = {
//                            isSecondSwitchChecked = it
//                            if (it) {
//                                isFirstSwitchChecked = false
//                            }
//                        }, modifier = Modifier.padding(16.dp)
//                    )
//
//                }
//                Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
//                    Image(painter = painterResource(id = R.drawable.social_whasapp),
//                        contentDescription = null,
//                        modifier = Modifier
//                            .padding(start = 20.dp)
//                            .size(40.dp)
//                            .clickable { }
//
//                    )
//                    Image(painter = painterResource(id = R.drawable.social_facebook),
//                        contentDescription = null,
//                        modifier = Modifier
//                            .padding(start = 20.dp)
//                            .size(40.dp)
//                            .clickable { }
//
//                    )
//                    Image(painter = painterResource(id = R.drawable.social_instgram),
//                        contentDescription = null,
//                        modifier = Modifier
//                            .padding(start = 20.dp)
//                            .size(40.dp)
//                            .clickable { }
//
//                    )
//                }
//                Spacer(modifier = Modifier.padding(top = 10.dp))
//                Button(
//                    onClick = { },
//                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
//                    shape = RoundedCornerShape(30.dp),
//                    modifier = Modifier
//                        .align(Alignment.CenterHorizontally)
//                        .width(230.dp)
//                        .height(40.dp)
//                ) {
//                    Text(text = "Save Now", fontSize = 15.sp, color = Color.White)
//                }
//                Spacer(modifier = Modifier.padding(top = 15.dp))
//                Text(
//                    text = "Try out the trial for 3 days",
//                    modifier = Modifier
//                        .align(Alignment.CenterHorizontally)
//                        .clickable { },
//                    fontSize = 15.sp,
//                    style = androidx.compose.ui.text.TextStyle(
//                        textDecoration = TextDecoration.Underline
//                    ),
//                    color = Color.White
//
//                )
//            }
//
//        }
//    }
//}