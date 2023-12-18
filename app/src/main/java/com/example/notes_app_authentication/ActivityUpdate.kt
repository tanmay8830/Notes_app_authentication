package com.example.notes_app_authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.notes_app_authentication.databinding.ActivityUpdateBinding

class ActivityUpdate : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateBinding
    private lateinit var db:NotesDataBaseHelper
    private var noteID : Int = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)


        db = NotesDataBaseHelper(this)
        noteID = intent.getIntExtra("note_id" , -1)
        if (noteID == -1){
            finish()
            return
        }

        val note =db.getNotesByID(noteID)
        binding.updatetitleEditText.setText(note.title)
        binding.updatecontentEditText.setText(note.descontent)


        binding.updateDoneButton.setOnClickListener {
            val newTitle = binding.updatetitleEditText.text.toString()
            val newdescontent = binding.updatecontentEditText.text.toString()
            val NoteUpdate = NotesDataClass(noteID, newTitle,newdescontent)
            db.NoteUpdate(NoteUpdate)
            finish()
            Toast.makeText(this,"The Note Has Been Upadated", Toast.LENGTH_SHORT).show()
        }

    }
}