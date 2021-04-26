package com.example.mynotes2

import androidx.annotation.WorkerThread
import com.example.mynotes2.database.NoteEntity
import kotlinx.coroutines.flow.Flow

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class NoteRepository(private val noteDao: NotesDatabaseDAO ) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allNotes: Flow<List<NoteEntity>> = noteDao.getAllNotes()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(note: NoteEntity) {
        noteDao.insert(note)
    }

    suspend fun clear(){
        noteDao.clear()
    }

    suspend fun update(note: NoteEntity){
        noteDao.update(note)
    }

    suspend fun get(id:Long){
        noteDao.get(id)
    }
}