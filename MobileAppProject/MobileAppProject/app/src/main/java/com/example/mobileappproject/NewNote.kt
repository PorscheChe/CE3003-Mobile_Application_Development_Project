package com.example.mobileappproject

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.DialogFragment


class NewNote:DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        val inflater = activity?.layoutInflater
        val dialogView = inflater!!.inflate(R.layout.new_note,null)

        val editTitle = dialogView.findViewById<EditText>(R.id.textTitle)
        val editDesc = dialogView.findViewById<EditText>(R.id.textDesc)
        val checkFav = dialogView.findViewById<CheckBox>(R.id.checkFav)
        val checkImportant = dialogView.findViewById<CheckBox>(R.id.checkImportant)
        val OkBtn = dialogView.findViewById<Button>(R.id.btnOK)
        val CancelBtn = dialogView.findViewById<Button>(R.id.btnCancel)

        builder.setView(dialogView).setMessage("Add New Note")
        CancelBtn?.setOnClickListener{
            dismiss()
        }
        OkBtn?.setOnClickListener{
            val newNote = Note()
            newNote.title = editTitle.text.toString()
            newNote.description = editDesc.text.toString()
            newNote.favorite = checkFav.isChecked
            newNote.important = checkImportant.isChecked
            val callActivity = activity as MainActivity?

            callActivity!!.createNewNote(newNote)
            dismiss()
        }
        return builder.create()

        /*fun edit(){
            val newNote = Note()
            newNote.title = editTitle.text.toString()
            newNote.description = editDesc.text.toString()
            newNote.favorite = checkFav.isChecked
            newNote.important = checkImportant.isChecked
            val callActivity = activity as MainActivity?
        }*/
    }
}