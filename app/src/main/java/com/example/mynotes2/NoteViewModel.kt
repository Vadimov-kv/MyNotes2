package com.example.mynotes2

import androidx.lifecycle.*
import com.example.mynotes2.database.NoteEntity
import kotlinx.coroutines.launch

class NoteViewModel (private val repository: NoteRepository) : ViewModel() {
    // TODO: Implement the ViewModel
    // Using LiveData and caching what allWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allWords: LiveData<List<NoteEntity>> = repository.allNotes.asLiveData()

    fun insert(noteItem: NoteEntity) = viewModelScope.launch {
        repository.insert(noteItem)
    }

    fun get(id: Long) = viewModelScope.launch {
        repository.get(id)
    }

    fun update(noteItem: NoteEntity) = viewModelScope.launch {
        repository.update(noteItem)
    }

}

class WordViewModelFactory(private val repository: NoteRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return NoteViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }



