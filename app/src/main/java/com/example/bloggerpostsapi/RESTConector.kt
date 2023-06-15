package com.example.bloggerpostsapi

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import java.lang.Exception

class RESTConector(val contexto: Context ) {

    private val QUEUE: RequestQueue

    init {
        QUEUE = Volley.newRequestQueue(contexto)
    }

    fun get(url: String, func: (JSONObject) -> Unit) {
        var jsonReq = JsonObjectRequest( url,
            Response.Listener {
                func.invoke(it)
            },
            Response.ErrorListener {
                Log.println(Log.ERROR,"BloggerAPIConnector",it.message ?: "Hubo un error con la API" )

                try {
                    Toast
                        .makeText(contexto,"Hubo un error con el request: ${it.networkResponse.statusCode}", Toast.LENGTH_SHORT)
                        .show()
                }
                catch ( e: Exception ) {
                    Log.println(Log.ERROR,"BloggerAPIConnector",e.toString())
                }
            })

        QUEUE.add(jsonReq)
    }

    fun post(url: String, func: (JSONObject) -> Unit) {
        var jsonReq = JsonObjectRequest( url,
            Response.Listener {
                func.invoke(it)
            },
            Response.ErrorListener {
                Log.println(Log.ERROR,"BloggerAPIConnector",it.message ?: "Hubo un error con la API" )

                try {
                    Toast
                        .makeText(contexto,"Hubo un error con el request: ${it.networkResponse.statusCode}", Toast.LENGTH_SHORT)
                        .show()
                }
                catch ( e: Exception ) {
                    Log.println(Log.ERROR,"BloggerAPIConnector",e.toString())
                }
            })

        QUEUE.add(jsonReq)
    }
}