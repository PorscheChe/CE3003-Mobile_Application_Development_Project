package com.example.mobileappproject

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.DialogFragment

class ShowNote : DialogFragment() {
    private var note: Note? = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(this.activity)
        val inflater = requireActivity().layoutInflater
        val dialogView = inflater.inflate(R.layout.show_note,null)

        val txtTitle = dialogView.findViewById(R.id.textViewTitle) as TextView
        val txtDesc = dialogView.findViewById(R.id.textviewDesc) as TextView
        val FavIcon = dialogView.findViewById<ImageView>(R.id.favoriteImgView)
        val ImportantIcon = dialogView.findViewById<ImageView>(R.id.Important)


        txtTitle.text = note!!.title
        txtDesc.text = note!!.description


        if(!note!!.favorite){
            FavIcon.visibility = View.GONE
        }
        if(!note!!.important){
            ImportantIcon.visibility = View.GONE
        }
        val btnOk = dialogView.findViewById<Button>(R.id.button2)
        builder.setView(dialogView).setMessage("Your Note")
        btnOk.setOnClickListener{
            dismiss()
        }
        return builder.create()
    }

    fun sendNoteSelected(noteSelected: Note){
        note = noteSelected
    }
}