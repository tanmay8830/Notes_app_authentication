package com.example.notes_app_authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.notes_app_authentication.databinding.ActivityAddNoteBinding

class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var db:NotesDataBaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NotesDataBaseHelper(this)

        binding.SaveButton.setOnClickListener {
            val title = binding.titleEditText.text.toString()
            val descontent = binding.contentEditText.text.toString()
            val note = NotesDataClass(0 ,title , descontent )
            db.insertNote(note)
            finish()
            Toast.makeText(this,"Note Has Been Saved", Toast.LENGTH_SHORT).show()
        }
    }

}