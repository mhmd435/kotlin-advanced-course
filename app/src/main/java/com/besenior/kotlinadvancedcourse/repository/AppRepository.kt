package com.besenior.kotlinadvancedcourse.repository

import com.besenior.kotlinadvancedcourse.models.NotesModel
import com.besenior.kotlinadvancedcourse.room.AppDatabase
import com.besenior.kotlinadvancedcourse.room.entities.NoteEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AppRepository @Inject constructor(
    appDatabase: AppDatabase
){

    private val roomDao = appDatabase.roomDao()

    fun insertNote(noteModel: NotesModel) {
        val noteEntity = NoteEntity(0,noteModel)
        roomDao.insert(noteEntity)
    }

    fun UpdateNote(noteEntity: NoteEntity) {
        roomDao.update(noteEntity)
    }

    fun deleteNote(noteEntity: NoteEntity) {
        roomDao.delete(noteEntity)
    }

    fun getAllData(): Flow<List<NoteEntity>> {
        return roomDao.getAll()
    }



}