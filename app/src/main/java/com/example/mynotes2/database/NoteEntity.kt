package com.example.mynotes2.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "notes_table")
data class NoteEntity(

    @PrimaryKey(autoGenerate = true)
    var id:Long = 0L,

    @ColumnInfo(name = "creation_time")
    val time:Long = System.currentTimeMillis(),

    @ColumnInfo(name = "importance")
    var importance:Int = -1,

    @ColumnInfo(name = "the_note")
    var note:String = ""
): Serializable
