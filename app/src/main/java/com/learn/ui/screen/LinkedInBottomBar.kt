package com.learn.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.learn.R

@Composable
fun LinkedInBottomBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        val items = listOf(
            BottomItem("Home", R.drawable.ic_home),
            BottomItem("My Network", R.drawable.ic_network_pepole),
            BottomItem("Post", R.drawable.ic_add_post),
            BottomItem("Notifications", R.drawable.ic_notification),
            BottomItem("Jobs", R.drawable.ic_work_job),
        )
        var selectedItem: BottomItem by remember { mutableStateOf(items[0]) }

        items.forEach { item ->
            BottomBarItem(
                item = item,
                selected = selectedItem == item,
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                    selectedItem = item
                })
        }
    }

}

@Composable
fun BottomBarItem(modifier: Modifier = Modifier, item: BottomItem, selected: Boolean = false) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        if (selected) {
            Divider(
                color = Color.Black,
                thickness = 2.dp
            )
        }

        val color = if (selected) Color.Black else Color(0xFF59595C)
        Icon(
            painter = painterResource(id = item.icon),
            contentDescription = null,
            tint = color
        )
        Text(
            text = item.name,
            fontSize = 10.sp,
            color = color
        )
    }
}

data class BottomItem(
    val name: String,
    val icon: Int
)