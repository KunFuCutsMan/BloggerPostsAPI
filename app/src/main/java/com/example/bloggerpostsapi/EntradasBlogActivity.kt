package com.example.bloggerpostsapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bloggerpostsapi.control.AdaptadorEntradasBlog

class EntradasBlogActivity : AppCompatActivity() {

    lateinit var blogID: String
    lateinit var connector: BloggerAPIConnector
    lateinit var rcvEntradasBlog: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entradas_blog)

        blogID = intent.getStringExtra("blogID")!!
        connector = BloggerAPIConnector(this)

        rcvEntradasBlog = findViewById(R.id.rcv_entradas_blog)
    }

    override fun onStart() {
        super.onStart()
        connector.obtenEntradasDeBlog(blogID) {
            rcvEntradasBlog.adapter = AdaptadorEntradasBlog(it)
            rcvEntradasBlog.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        }
    }
}