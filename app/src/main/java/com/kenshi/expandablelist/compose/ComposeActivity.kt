package com.kenshi.expandablelist.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kenshi.expandablelist.Notices.notices
import com.kenshi.expandablelist.compose.ui.theme.ExpandableListTheme
import com.kenshi.expandablelist.compose.ui.theme.Gray300

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpandableListTheme {
                Surface(color = Color.White) {
                    LazyColumn {
                        itemsIndexed(notices) { index, _ ->
                            NoticeCard(
                                title = notices[index].title,
                                date = notices[index].date,
                                description = notices[index].description
                            )
                            if (index < notices.lastIndex)
                                Divider(color = Gray300, thickness = 1.dp)
                        }
                    }
                }
            }
        }
    }
}