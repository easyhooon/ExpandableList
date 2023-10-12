package com.kenshi.expandablelist.view

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import com.kenshi.expandablelist.Notices.notices
import com.kenshi.expandablelist.R
import com.kenshi.expandablelist.databinding.ActivityViewBinding

class ViewActivity : AppCompatActivity() {

    private val binding by lazy { ActivityViewBinding.inflate(layoutInflater) }

    private val noticeAdapter by lazy { NoticeAdapter(notices) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.rvNotice.apply {
            adapter = noticeAdapter
            val colorDrawable = ColorDrawable(ContextCompat.getColor(context, R.color.gray_300))
            val dividerItemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            dividerItemDecoration.setDrawable(colorDrawable)
            addItemDecoration(dividerItemDecoration)
        }
    }
}