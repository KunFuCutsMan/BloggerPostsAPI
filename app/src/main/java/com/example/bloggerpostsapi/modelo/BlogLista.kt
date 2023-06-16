package com.example.bloggerpostsapi.modelo

import org.json.JSONObject

data class BlogLista(private val data: JSONObject) {
    val kind = data.getString("kind")
    val nextPageToken = data.getString("nextPageToken")
    val items = ArrayList<Blog>()

    init {
        var listadoItems = data.getJSONArray("items")

        for ( i in 0..listadoItems.length()-1 ) {
            items.add( Blog( listadoItems[i] as JSONObject ) )
        }
    }
}