package com.example.bloggerpostsapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    lateinit var txtBuscaBlogURL: EditText
    lateinit var btnBuscaBlogURL: Button
    lateinit var connector: BloggerAPIConnector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connector = BloggerAPIConnector(baseContext)

        txtBuscaBlogURL = findViewById(R.id.txt_buscaBlogURL)
        btnBuscaBlogURL = findViewById(R.id.btn_buscaBlogURL)

        btnBuscaBlogURL.setOnClickListener { encuentraBlogDeURL() }
    }

    private fun encuentraBlogDeURL() {
        var urlBlog = txtBuscaBlogURL.text.toString().trim()

        if (urlBlog.isBlank())
            return

        connector.obtenBlogDeURL(urlBlog) {

            AlertDialog.Builder(this)
                .setTitle("Blog Encontrado")
                .setMessage("Encontramos un blog bajo el nombre: ${it["name"]}")
                .show()
        }
    }
}