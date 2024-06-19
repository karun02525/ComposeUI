package com.learn.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.learn.R


@Composable
fun LinkedInToolBar() {
    ConstraintLayout(modifier = Modifier
        .padding(top = 10.dp)
        .fillMaxWidth()) {

        val (userImage, searchBox, chatIcon) = createRefs()
        UserImage(modifier = Modifier.constrainAs(userImage) {
            start.linkTo(parent.start, margin = 16.dp)
            top.linkTo(parent.top, 4.dp)
            bottom.linkTo(parent.bottom, 4.dp)
        })

        SearchBox(modifier = Modifier.constrainAs(searchBox) {
            start.linkTo(userImage.end, margin = 8.dp)
            top.linkTo(userImage.top)
            bottom.linkTo(userImage.bottom)
            end.linkTo(chatIcon.start, margin = 8.dp)
            width = Dimension.fillToConstraints
        })

        ChatButton(modifier = Modifier.constrainAs(chatIcon) {
            end.linkTo(parent.end, 16.dp)
            top.linkTo(userImage.top)
            bottom.linkTo(userImage.bottom)
        })
    }
}

@Composable
fun UserImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.user_pic),
        contentDescription = null,
        modifier = modifier
            .clip(CircleShape)
            .size(30.dp)
    )
}

@Composable
fun SearchBox(modifier: Modifier = Modifier) {

    ConstraintLayout(
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .background(Color(0xFFEEF3F8))
    ) {
        val (searchIcon, text, qrIcon) = createRefs()
        Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = null,
            modifier = Modifier.constrainAs(searchIcon) {
                start.linkTo(parent.start, margin = 16.dp)
                top.linkTo(parent.top, 4.dp)
                bottom.linkTo(parent.bottom, 4.dp)
            }
        )

        Text(text = "Search", modifier = Modifier.constrainAs(text) {
            start.linkTo(searchIcon.end, 8.dp)
            top.linkTo(parent.top, margin = 4.dp)
            bottom.linkTo(parent.bottom, margin = 4.dp)
            end.linkTo(qrIcon.start, 8.dp)
            width = Dimension.fillToConstraints
        })

        Icon(
            painter = painterResource(id = R.drawable.ic_qr_code),
            contentDescription = null,
            modifier = Modifier.constrainAs(qrIcon) {
                end.linkTo(parent.end, 16.dp)
                top.linkTo(parent.top, margin = 4.dp)
                bottom.linkTo(parent.bottom, margin = 4.dp)
            }
        )

    }
}

@Composable
fun ChatButton(modifier: Modifier = Modifier) {
    Icon(
        modifier = modifier,
        painter = painterResource(id = R.drawable.ic_chat_message),
        contentDescription = null
    )
}