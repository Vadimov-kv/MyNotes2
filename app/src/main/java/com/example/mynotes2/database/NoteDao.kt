package com.example.mynotes2

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mynotes2.database.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDatabaseDAO {
    @Insert
    fun insert(item: NoteEntity)

    @Update
    fun update(item: NoteEntity)

    @Query("SELECT * from notes_table WHERE id = :key")
    fun get(key:Long): NoteEntity

    @Query("DELETE FROM notes_table")
    fun clear()

    @Query("SELECT * FROM notes_table ORDER BY id DESC")
    fun getAllNotes(): Flow<List<NoteEntity>>

    @Query("SELECT * FROM notes_table ORDER BY id DESC LIMIT 1")
    fun getLast(): NoteEntity?

}
