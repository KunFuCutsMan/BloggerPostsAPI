package com.example.bloggerpostsapi.modelo

import org.json.JSONObject

data class Blog(private val data: JSONObject) {
    val kind = data.getString("kind")
    val id = data.getString("id")
    val name = data.getString("name")
    val description = data.getString("description")
    val published = data.getString("published")
    val updated = data.getString("updated")
    val url = data.getString("url")
    val selfLink = data.getString("selfLink")
    val posts = Posts(data.getJSONObject("posts"))
    val pages = Pages(data.getJSONObject("pages"))
}

data class Posts(private val data: JSONObject) {
    val totalItems = data.getInt("totalItems")
    val selfLink = data.getString("selfLink")
}

data class Pages(private val data: JSONObject) {
    val totalItems = data.getInt("totalItems")
    val selfLink = data.getString("selfLink")
}

data class Locale(private val data: JSONObject) {
    val language = data.getInt("totalItems")
    val country = data.getString("selfLink")
    val variant = data.optString("variant")
}