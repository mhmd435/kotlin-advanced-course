package com.besenior.kotlinadvancedcourse.adapters

import android.view.View
import androidx.constraintlayout.utils.widget.ImageFilterButton
import com.besenior.kotlinadvancedcourse.room.entities.NoteEntity

interface CardClickListener {
    fun onItemClickListener(noteEntity: NoteEntity)

    fun onMenuItemClickListener(imageFilterButton: View, noteEntity: NoteEntity)
}