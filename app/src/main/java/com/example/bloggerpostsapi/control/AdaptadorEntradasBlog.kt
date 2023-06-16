package com.example.bloggerpostsapi.control

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.bloggerpostsapi.EntradaContenidoActivity
import com.example.bloggerpostsapi.R
import com.example.bloggerpostsapi.modelo.PublicacionLista

class AdaptadorEntradasBlog(private val LISTA: PublicacionLista): RecyclerView.Adapter<TargetaPublicacion>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TargetaPublicacion {
        var vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.targeta_publicacion, parent, false)

        return TargetaPublicacion(vista)
    }

    override fun getItemCount(): Int {
        return LISTA.items.size
    }

    override fun onBindViewHolder(holder: TargetaPublicacion, position: Int) {
        var pub = LISTA.items[position]
        holder.TXT_TARGETA_TITULO.text = pub.title
        holder.TXT_TARGETA_FEC_PUBLICACION.text = pub.published.replace("T","\n")
        holder.TXT_TARGETA_AUTOR.text = pub.author.displayName
        holder.TXT_TARGETA_COMENTARIOS.text = "Comentarios:\n${pub.replies.totalItems}"
        holder.BTN_TARGETA_PUBLICACION.setOnClickListener {
            // Comienza la actividad del contenido
            var intento = Intent( holder.CONTEXTO, EntradaContenidoActivity::class.java )
            intento.putExtra("postID", pub.id)
            intento.putExtra("blogID", pub.blogID)
            startActivity(holder.CONTEXTO, intento, null)
        }
    }
}

data class TargetaPublicacion(private val vista: View): RecyclerView.ViewHolder(vista) {
    val TXT_TARGETA_TITULO = vista.findViewById<TextView>(R.id.txt_targeta_titulo)
    val TXT_TARGETA_FEC_PUBLICACION = vista.findViewById<TextView>(R.id.txt_targeta_fec_publicacion)
    val TXT_TARGETA_AUTOR = vista.findViewById<TextView>(R.id.txt_targeta_autor)
    val TXT_TARGETA_COMENTARIOS = vista.findViewById<TextView>(R.id.txt_targeta_comentarios)
    val BTN_TARGETA_PUBLICACION = vista.findViewById<Button>(R.id.btn_targeta_publicacion)
    val CONTEXTO = vista.context
}