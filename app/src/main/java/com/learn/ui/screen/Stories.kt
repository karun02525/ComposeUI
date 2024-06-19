package com.learn.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.learn.R


data class Story(
    var userName: String,
    var image: String,
)

@Composable
fun StoriesListView(list: List<Story>) {
    LazyRow(
        Modifier.fillMaxWidth()
    ) {

        item {
            AddStoryView(modifier = Modifier.clickable {
                // add story
            })
        }
        items(list) { story ->
            StoryItemView(story = story, Modifier.clickable {
                // view user stories
            })
        }
    }
}

@Composable
fun AddStoryView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(4.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {

            Image(
                painter = painterResource(id = R.drawable.user_pic),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(60.dp),
                contentScale = ContentScale.Crop)


            Icon(
                painter = painterResource(id = R.drawable.ic_add),
                contentDescription = null,
                tint = Color(0xFF1079F0),
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .clip(CircleShape)
                    .background(Color.White))

        }

        Text(
            text = "Your Story",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun StoryItemView(story: Story, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(4.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data(story.image)
                .size(Size.ORIGINAL) // Set the target size to load the image at.
                .build()
        )
        if (painter.state is AsyncImagePainter.State.Success) {
            // This will be executed during the first composition if the image is in the memory cache.
        }
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .border(2.dp, color = Color.Blue, shape = CircleShape)
                .clip(shape = CircleShape)
        )
        Text(
            text = story.userName,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}