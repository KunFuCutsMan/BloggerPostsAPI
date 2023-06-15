package com.example.bloggerpostsapi

import android.app.AlertDialog
import android.content.Context
import android.widget.Toast
import org.json.JSONObject

class BloggerAPIConnector( private val contexto: Context ) {
    private val GOOGLE_API_KEY: String
    private val con: RESTConector

    init {
        con = RESTConector(contexto)
        GOOGLE_API_KEY = contexto.getString( R.string.GOOGLE_API_KEY )
    }

    fun obtenBlogDeURL(urlBlog: String, res: (JSONObject) -> Unit) {
        var req = "https://www.googleapis.com/blogger/v3/blogs/byurl?url=$urlBlog&key=$GOOGLE_API_KEY"
        con.get( req ) {res.invoke(it) }
    }
}