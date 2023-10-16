package com.kenshi.expandablelist.view

import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.kenshi.expandablelist.NoticeItem
import com.kenshi.expandablelist.databinding.ItemNoticeBinding

class NoticeViewHolder(val binding: ItemNoticeBinding) : RecyclerView.ViewHolder(binding.root) {
  fun bind(notice: NoticeItem) {
    binding.apply {
      tvNoticeTitle.text = notice.title
      tvNoticeDate.text = notice.date
      tvNoticeDescription.text = notice.description
      clNotice.setOnClickListener {
        notice.isExpanded = toggleLayout(!notice.isExpanded, ivNoticeExpand, llLayoutExpand)
      }
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
