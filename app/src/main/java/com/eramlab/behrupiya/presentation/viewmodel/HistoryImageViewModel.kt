package com.eramlab.behrupiya.presentation.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.File
class HistoryImageViewModel(application: Application):  AndroidViewModel(application){

    private val _imageFiles = MutableStateFlow<List<File>>(emptyList())
    val imageFiles: StateFlow<List<File>> = _imageFiles

    init {
        loadImageFiles()
    }

    private fun loadImageFiles() {
        viewModelScope.launch {
            val files = getAllGeneratedImageFiles(getApplication())
            _imageFiles.value = files
        }
    }
    private fun getAllGeneratedImageFiles(context: Context): List<File> {
        val folder = File(context.filesDir, "generated_images")
        return if (folder.exists() && folder.isDirectory) {
            folder.listFiles()?.filter { it.isFile }?.sortedByDescending { it.lastModified() } ?: emptyList()
        } else {
            emptyList()
        }
    }

}