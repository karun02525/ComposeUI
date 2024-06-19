package com.learn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learn.ui.screen.LinkedInBottomBar
import com.learn.ui.screen.LinkedInToolBar
import com.learn.ui.screen.StoriesListView
import com.learn.ui.screen.Story
import com.learn.ui.theme.ComposeLearnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  enableEdgeToEdge()
        setContent {
            ComposeLearnTheme {
                LinkedInMain()
            }
        }
    }
}

@Composable
fun LinkedInMain() {
    Scaffold(
        topBar = { LinkedInToolBar() },
        bottomBar = { LinkedInBottomBar() }
    ) {padding->
        Column(Modifier.fillMaxSize()
            .padding(padding)
        ) {
            val stories = loadStories()
            StoriesListView(list = stories)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeLearnTheme {
        LinkedInMain()
    }
}

private fun loadStories(): List<Story> {
    return listOf(
        Story(
            "User 1",
            "https://ih1.redbubble.net/image.4490659955.9193/st,small,507x507-pad,600x600,f8f8f8.jpg"
        ),
        Story(
            "User 2",
            "https://ww2.kqed.org/app/uploads/sites/23/2018/03/iStock-471301626-520x520.jpg"
        ),
        Story(
            "User 3",
            "https://img.freepik.com/premium-photo/illustration-scince-chemical-beaker-flask_968529-97530.jpg"
        ),
        Story(
            "User 4",
            "https://cdn4.sharechat.com/2152dd6f_1703255076999_sc.webp?tenant=sc&referrer=pwa-sharechat-service&f=99_sc.webp"
        ),
        Story(
            "User 5",
            "https://media-exp1.licdn.com/dms/image/C4D03AQEayrMUbxD_zA/profile-displayphoto-shrink_100_100/0/1589416332840?e=1621468800&v=beta&t=Oe6StYST3oYUeafD-6WJd_YHNSBiBGelTuvsp5sMtKY"
        ),
        Story(
            "User 6",
            "https://media-exp1.licdn.com/dms/image/C4E03AQHt09d7wOKqCQ/profile-displayphoto-shrink_100_100/0/1611966644166?e=1621468800&v=beta&t=8QaUS1MIWKmq7dNlMulYcQe1Y1Mvygi_SCzKsWPL9Gg"
        ),
    )
}