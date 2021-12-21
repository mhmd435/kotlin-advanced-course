package com.besenior.kotlinadvancedcourse.adapters

import com.besenior.kotlinadvancedcourse.room.entities.NoteEntity

interface CardClickListener {
    fun onItemClickListener(noteEntity: NoteEntity)
}