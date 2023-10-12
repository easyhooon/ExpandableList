package com.kenshi.expandablelist

data class NoticeItem(
    val title: String,
    val date: String,
    val description: String,
    var isExpanded: Boolean = false,
)
