package com.example.mynotes2

import android.app.Application
import com.example.mynotes2.database.NotesDatabase

class NotesApplication : Application() {
    private val database by lazy { NotesDatabase.getInstance(this) }
    val repository by lazy {NoteRepository(database.notesDatabaseDAO())}
}