package com.besenior.kotlinadvancedcourse.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.besenior.kotlinadvancedcourse.models.NotesModel

@Entity(tableName = "notetable")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    val notesModel: NotesModel
)
