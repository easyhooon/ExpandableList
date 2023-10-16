package com.kenshi.expandablelist.view

import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.kenshi.expandablelist.NoticeItem
import com.kenshi.expandablelist.databinding.ItemNoticeBinding

class NoticeViewHolder(val binding: ItemNoticeBinding) : RecyclerView.ViewHolder(binding.root) {
  private var currentItem: NoticeItem? = null

  init {
    with(binding) {
      clNotice.setOnClickListener {
        currentItem?.let {
          it.isExpanded = toggleLayout(!it.isExpanded, ivNoticeExpand, llLayoutExpand)
        }
      }
    }
  }

  fun bind(notice: NoticeItem) {
    currentItem = notice
    binding.apply {
      tvNoticeTitle.text = notice.title
      tvNoticeDate.text = notice.date
      tvNoticeDescription.text = notice.description
    }
  }

  private fun toggleLayout(isExpanded: Boolean, view: View, layoutExpand: LinearLayout): Boolean {
    ToggleAnimation.toggleArrow(view, isExpanded)
    if (isExpanded) {
      ToggleAnimation.expand(layoutExpand)
    } else {
      ToggleAnimation.collapse(layoutExpand)
    }
    return isExpanded
  }
}
