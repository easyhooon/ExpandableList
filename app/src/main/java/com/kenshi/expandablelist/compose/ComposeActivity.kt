package com.kenshi.expandablelist.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.kenshi.expandablelist.Notices.notices
import com.kenshi.expandablelist.compose.ui.theme.ExpandableListTheme

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpandableListTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LazyColumn {
                        items(
                            count = notices.size,
                        ) {index ->
                            NoticeCard(
                                title = notices[index].title,
                                date = notices[index].date,
                                description = notices[index].description
                            )
                        }
                    }
                }
            }
        }
    }
}