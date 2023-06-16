package com.example.bloggerpostsapi.modelo

import org.json.JSONObject

data class Publicacion(private val data: JSONObject ) {
    val kind = data.getString("kind")
    val id = data.getString("id")
    val blogID = data.getJSONObject("blog").getString("id")
    val published = data.getString("published")
    val updated = data.getString("updated")
    val selfLink = data.getString("selfLink")
    val title = data.getString("title")
    val content = data.getString("content")
    val author = Author(data.getJSONObject("author"))
    val replies = Replies(data.getJSONObject("replies"))
}

data class Author(private val data: JSONObject) {
    val id = data.getString("id")
    val displayName = data.getString("displayName")
    val url = data.getString("url")
    val imageURL = data.getJSONObject("image").getString("url")
}

data class Replies(private val data: JSONObject) {
    val totalItems = data.getString("totalItems")
    val selfLink = data.getString("selfLink")
}