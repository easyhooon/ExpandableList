package com.kenshi.expandablelist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kenshi.expandablelist.compose.ComposeActivity
import com.kenshi.expandablelist.databinding.ActivityMainBinding
import com.kenshi.expandablelist.view.ViewActivity

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initListener()
    }

    private fun initListener() {
        with(binding) {
            btnView.setOnClickListener {
                startActivity(Intent(this@MainActivity, ViewActivity::class.java))
            }
            btnCompose.setOnClickListener {
                startActivity(Intent(this@MainActivity, ComposeActivity::class.java))
            }
        }
    }
}