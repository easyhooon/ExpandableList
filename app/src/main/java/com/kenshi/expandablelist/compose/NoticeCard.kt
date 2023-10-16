package com.kenshi.expandablelist.compose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.expandVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.kenshi.expandablelist.R
import com.kenshi.expandablelist.compose.extension.noRippleClickable
import com.kenshi.expandablelist.compose.ui.theme.Gray400
import com.kenshi.expandablelist.compose.ui.theme.Gray50
import com.kenshi.expandablelist.compose.ui.theme.Gray500
import com.kenshi.expandablelist.compose.ui.theme.Gray900
import com.kenshi.expandablelist.compose.ui.theme.TextLMedium
import com.kenshi.expandablelist.compose.ui.theme.TextMRegular
import com.kenshi.expandablelist.compose.ui.theme.TextXsRegular

@Composable
fun NoticeCard(
    modifier: Modifier = Modifier,
    date: String,
    title: String,
    description: String,
) {
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(targetValue = if (expandedState) 180f else 0f)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .noRippleClickable {
                expandedState = !expandedState
            }
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 9.dp,
                    bottom = 9.dp
                ),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = title,
                    color = Gray900,
                    style = TextLMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .rotate(rotationState),
                    onClick = { expandedState = !expandedState }
                ) {
                    val image = painterResource(
                        id = R.drawable.ic_arrow_drop_down,
                    )
                    Image(
                        painter = image,
                        contentDescription = "Delete",
                    )
                }
            }
            AnimatedVisibility(
                visible = expandedState,
                enter = expandVertically()
//                // add optional animation
//                enter = fadeIn() + expandVertically(
//                    animationSpec = spring(
//                        dampingRatio = Spring.DampingRatioMediumBouncy,
//                        stiffness = Spring.StiffnessLow
//                    )
//                )
            ) {
                ExpandedContent(
                    date = date,
                    description = description
                )
            }
        }
    }
}

@Composable
fun ExpandedContent(
    modifier: Modifier = Modifier,
    date: String,
    description: String
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Gray50)
            .padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 18.dp)
    ) {
        Text(
            text = date,
            color = Gray400,
            style = TextXsRegular,
        )
        Spacer(modifier = Modifier.height(18.dp))
        Text(
            text = description,
            color = Gray500,
            style = TextMRegular,
            maxLines = 4,
            overflow = TextOverflow.Ellipsis
        )
    }
}