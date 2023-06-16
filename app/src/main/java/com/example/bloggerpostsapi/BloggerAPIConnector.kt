package com.example.bloggerpostsapi

import android.content.Context
import com.example.bloggerpostsapi.modelo.Blog
import com.example.bloggerpostsapi.modelo.Publicacion
import com.example.bloggerpostsapi.modelo.PublicacionLista

class BloggerAPIConnector( private val contexto: Context ) {
    private val GOOGLE_API_KEY: String
    private val con: RESTConector

    init {
        con = RESTConector(contexto)
        GOOGLE_API_KEY = contexto.getString( R.string.GOOGLE_API_KEY )
    }

    fun obtenBlogDeURL(urlBlog: String, res: (Blog) -> Unit) {
        var req = "https://www.googleapis.com/blogger/v3/blogs/byurl?url=$urlBlog&key=$GOOGLE_API_KEY"
        con.get( req ) {res.invoke( Blog(it) )}
    }

    fun obtenEntradasDeBlog(blogID: String, res: (PublicacionLista) -> Unit) {
        var req = "https://www.googleapis.com/blogger/v3/blogs/$blogID/posts?key=$GOOGLE_API_KEY"
        con.get( req ) {res.invoke( PublicacionLista(it) )}
    }

    fun obtenPublicacionEspecifica(blogID: String, postID: String, res: (Publicacion) -> Unit) {
        var req = "https://www.googleapis.com/blogger/v3/blogs/$blogID/posts/$postID?key=$GOOGLE_API_KEY"
        con.get( req ) {res.invoke( Publicacion(it) )}
    }
}