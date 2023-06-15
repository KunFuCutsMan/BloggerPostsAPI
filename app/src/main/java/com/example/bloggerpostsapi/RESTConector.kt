package com.example.bloggerpostsapi

import android.content.Context
import android.util.Log
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class RESTConector(val contexto: Context ) {

    private val GOOGLE_API_KEY: String
    private val QUEUE: RequestQueue

    init {
        GOOGLE_API_KEY = contexto.getString( R.string.GOOGLE_API_KEY )
        QUEUE = Volley.newRequestQueue(contexto)
    }

    fun get(url: String, func: (JSONObject) -> Unit) {
        var jsonReq = JsonObjectRequest( url,
            Response.Listener {
                func.invoke(it)
            },
            Response.ErrorListener {
                Log.println(Log.ERROR,"BloggerAPIConnector",it.toString() )
            })

        QUEUE.add(jsonReq)
    }

    fun post(url: String, func: (JSONObject) -> Unit) {
        var jsonReq = JsonObjectRequest( url,
            Response.Listener {
                func.invoke(it)
            },
            Response.ErrorListener {
                Log.println(Log.ERROR, "BloggerAPIConnector",it.toString())
            })

        QUEUE.add(jsonReq)
    }
}