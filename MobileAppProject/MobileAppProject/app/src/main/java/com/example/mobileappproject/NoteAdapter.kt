package com.example.mobileappproject

import android.media.Image
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.security.KeyStore

class NoteAdapter (
    private val mainActivity: MainActivity,
    private val noteList: List<Note>):
    RecyclerView.Adapter<NoteAdapter.ListItemHolder>(){
    inner class ListItemHolder(view:View): RecyclerView.ViewHolder(view),View.OnClickListener {
        internal var title = view.findViewById<View>(R.id.listTitle) as TextView
        internal var desc = view.findViewById<View>(R.id.listDesc) as TextView
        internal var favo = view.findViewById<View>(R.id.listFav) as ImageView
        internal var imp = view.findViewById<View>(R.id.listImportant) as ImageView
        private var delBtn = view.findViewById<ImageView>(R.id.listDelete)
        private var editBtn = view.findViewById<ImageView>(R.id.listEdit)

        init {
            editBtn.setOnClickListener{
               mainActivity.editList(adapterPosition, Note())
            }
        }
        init {
            delBtn.setOnClickListener{
                removeFromList(adapterPosition)
            }
        }

        init {
            view.isClickable = true
            view.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            mainActivity.showNote(adapterPosition)
        }


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapter.ListItemHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ListItemHolder(itemView)
    }

    override fun onBindViewHolder(holder: NoteAdapter.ListItemHolder, position: Int) {
        val note = noteList[position]
        holder.title.text = note.title
        holder.desc.text = note.description

        if(!note.favorite){
            holder.favo.visibility = View.GONE
        }
        if(!note.important){
            holder.imp.visibility = View.GONE
        }


    }
    override fun getItemCount(): Int {
        if(noteList!=null){
            return noteList.size
        }
        return -1

    }
    fun removeFromList(position: Int){
        mainActivity.removeList(position)
    }
}