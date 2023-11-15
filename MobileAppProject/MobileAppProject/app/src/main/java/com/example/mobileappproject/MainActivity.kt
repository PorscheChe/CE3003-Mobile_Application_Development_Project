package com.example.mobileappproject

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private var noteList = ArrayList<Note>()
    private var recyclerView: RecyclerView? = null
    private var adapter: NoteAdapter? = null

    fun createNewNote(n:Note){
        noteList.add(n)
        adapter!!.notifyDataSetChanged()

    }
    fun showNote(noteToShow:Int){
        val dialog = ShowNote()
        dialog.sendNoteSelected(noteList[noteToShow])
        dialog.show(supportFragmentManager,"Show")
    }
    fun removeList(position: Int){
        noteList.removeAt(position)
        adapter!!.notifyItemRemoved(position)

    }
    fun editList(position: Int){
        noteList.removeAt(position)
        adapter!!.notifyItemRemoved(position)
        val dialog = NewNote()
        dialog.show(supportFragmentManager,"Edit")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val floatingActionButton = findViewById<FloatingActionButton>(R.id.fab)

        floatingActionButton.setOnClickListener {
            val dialog = NewNote()
            dialog.show(supportFragmentManager,"FAB")
        }
        recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView
        adapter = NoteAdapter(this, noteList)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.itemAnimator = DefaultItemAnimator()

        recyclerView!!.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))
        recyclerView!!.adapter = adapter
    }
}


