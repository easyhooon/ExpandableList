package com.kenshi.expandablelist.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kenshi.expandablelist.Notices.notices
import com.kenshi.expandablelist.R
import com.kenshi.expandablelist.compose.extension.addDivider
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
            addDivider(R.color.gray_300)
        }
    }
}