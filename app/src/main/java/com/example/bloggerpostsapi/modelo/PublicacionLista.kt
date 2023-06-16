package com.example.bloggerpostsapi.modelo

import org.json.JSONObject

data class PublicacionLista(private val data: JSONObject) {
    val kind = data.getString("kind")
    val nextPageToken = data.optString("nextPageToken")
    val items = ArrayList<Publicacion>()

    init {
        var listadoItems = data.getJSONArray("items")

        for ( i in 0..listadoItems.length()-1 ) {
            items.add( Publicacion( listadoItems[i] as JSONObject ) )
        }
    }
}