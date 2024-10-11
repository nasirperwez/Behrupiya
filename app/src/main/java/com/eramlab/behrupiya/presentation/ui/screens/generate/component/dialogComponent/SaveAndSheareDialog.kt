package com.eramlab.behrupiya.presentation.ui.screens.generate.component.dialogComponent


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.eramlab.behrupiya.presentation.SharedViewModel

@Composable
fun SaveAndShare(onDismiss: () -> Unit, sharedViewModel: SharedViewModel) {

    Dialog(
        onDismissRequest = { onDismiss() }, properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
            usePlatformDefaultWidth = false // Makes the dialog full screen if needed
        )
    ) {
        Box(
            modifier = Modifier
                .padding(top = 150.dp, start = 20.dp, end = 20.dp)
                .clip(
                    RoundedCornerShape(
                        topEnd = 30.dp,
                        topStart = 30.dp,

                        )
                )
                .fillMaxSize()
                .background(Color(0xF225282C)) // Semi-transparent background

        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
            ) {
                CloseButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .weight(0.035f),
                    onClose = onDismiss
                )
                SelectedImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .weight(0.565f),
                    sharedViewModel = sharedViewModel

                )
                PhoteoAndVideo(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .weight(0.07f)
                )
                HdSwitch(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .weight(0.13f)
                )
                SheareandOtherApp(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .weight(0.08f),
                    sharedViewModel = sharedViewModel

                )
                SaveNow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .weight(0.08f),
                )
                TryButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .weight(0.04f)
                )

            }
        }
    }
}


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