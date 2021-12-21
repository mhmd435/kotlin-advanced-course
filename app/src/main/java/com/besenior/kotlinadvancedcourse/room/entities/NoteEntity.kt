package com.besenior.kotlinadvancedcourse.room.entities

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.besenior.kotlinadvancedcourse.models.NotesModel

@Entity(tableName = "notetable")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    val notesModel: NotesModel
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        TODO("notesModel")
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(uid)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NoteEntity> {
        override fun createFromParcel(parcel: Parcel): NoteEntity {
            return NoteEntity(parcel)
        }

        override fun newArray(size: Int): Array<NoteEntity?> {
            return arrayOfNulls(size)
        }
    }
}
