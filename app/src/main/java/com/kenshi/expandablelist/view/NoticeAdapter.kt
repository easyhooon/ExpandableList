package com.kenshi.expandablelist.view

import android.view.LayoutInflater
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
        holder.bind(noticeList[position])
    }

    override fun getItemCount() = noticeList.size
}
