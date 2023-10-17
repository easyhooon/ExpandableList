package com.kenshi.expandablelist.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.kenshi.expandablelist.NoticeItem
import com.kenshi.expandablelist.databinding.ItemNoticeBinding

class NoticeViewHolder(val binding: ItemNoticeBinding) : RecyclerView.ViewHolder(binding.root) {
    private var currentItem: NoticeItem? = null

    fun bind(notice: NoticeItem) {
        currentItem = notice
        binding.apply {
            tvNoticeTitle.text = notice.title
            tvNoticeDate.text = notice.date
            tvNoticeDescription.text = notice.description
            ivNoticeExpand.rotation = if (notice.isExpanded) 180f else 0f
            llLayoutExpand.visibility = if (notice.isExpanded) View.VISIBLE else View.GONE
        }
    }
}
