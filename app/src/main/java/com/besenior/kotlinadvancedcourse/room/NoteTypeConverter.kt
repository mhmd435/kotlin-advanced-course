package com.besenior.kotlinadvancedcourse.room

import androidx.room.TypeConverter
import com.besenior.kotlinadvancedcourse.models.NotesModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class NoteTypeConverter {

    @TypeConverter
    fun tojson(notesModel: NotesModel): String? {
        if (notesModel == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<NotesModel?>() {}.getType()
        return gson.toJson(notesModel, type)
    }

    @TypeConverter
    fun toDataClass(note: String?): NotesModel? {
        if (note == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<NotesModel?>() {}.getType()
        return gson.fromJson(note, type)
    }
}