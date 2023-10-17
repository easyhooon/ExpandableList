package com.kenshi.expandablelist.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kenshi.expandablelist.NoticeItem
import com.kenshi.expandablelist.databinding.ItemNoticeBinding

class NoticeAdapter(private var noticeList: List<NoticeItem>) :
    RecyclerView.Adapter<NoticeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        NoticeViewHolder(
            ItemNoticeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: NoticeViewHolder, position: Int) {
        val notice = noticeList[position]
        holder.bind(notice)

        with(holder.binding) {
            clNotice.setOnClickListener {
                notice.isExpanded = !notice.isExpanded
                toggleLayout(notice.isExpanded, ivNoticeExpand)
                notifyItemChanged(position)
            }
        }
    }

    override fun getItemCount() = noticeList.size

    private fun toggleLayout(isExpanded: Boolean, view: View) {
        if (isExpanded) {
            view.animate().setDuration(200).rotation(180f)
        } else {
            view.animate().setDuration(200).rotation(0f)
        }
    }
}
