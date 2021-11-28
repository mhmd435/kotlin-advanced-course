package com.besenior.kotlinadvancedcourse.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.besenior.kotlinadvancedcourse.models.NotesModel
import com.besenior.kotlinadvancedcourse.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val repository: AppRepository
): ViewModel() {


    fun insertNoteToDatabase(noteModel: NotesModel) {
        viewModelScope.launch (Dispatchers.IO){
            repository.insertNote(noteModel)
        }
    }


}