package com.example.bloggerpostsapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.lang.Appendable
import java.util.function.Consumer

class EntradaContenidoActivity : AppCompatActivity() {

    lateinit var blogID: String
    lateinit var postID: String
    lateinit var connector: BloggerAPIConnector

    lateinit var txtPubTitulo: TextView
    lateinit var txtPubAutor: TextView
    lateinit var txtPubFecha: TextView
    lateinit var lnlPubContenido: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrada_contenido)

        blogID = intent.getStringExtra("blogID")!!
        postID = intent.getStringExtra("postID")!!

        connector = BloggerAPIConnector(this)

        txtPubTitulo = findViewById(R.id.txt_pub_titulo)
        txtPubAutor = findViewById(R.id.txt_pub_autor)
        txtPubFecha = findViewById(R.id.txt_pub_fecha)
        lnlPubContenido = findViewById(R.id.lnl_pub_contenido)
    }

    override fun onStart() {
        super.onStart()
        connector.obtenPublicacionEspecifica(blogID, postID) {
            txtPubTitulo.text = it.title
            txtPubAutor.text = it.author.displayName
            txtPubFecha.text = it.published.substringBefore("T")

            parseaContenido( Jsoup.parse(it.content) )
        }
    }

    private fun parseaContenido(doc: Document) {
        var body = doc.body()

        body.children().forEach {
            var parrafo = it.text()

            var txtView = TextView(this)
            txtView.text = parrafo

            lnlPubContenido.addView(txtView)
        }
    }
}