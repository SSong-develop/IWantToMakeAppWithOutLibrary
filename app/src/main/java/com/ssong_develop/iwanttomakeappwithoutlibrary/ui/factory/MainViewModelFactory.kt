package com.ssong_develop.iwanttomakeappwithoutlibrary.ui.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ssong_develop.iwanttomakeappwithoutlibrary.api.repository.MainRepository
import com.ssong_develop.iwanttomakeappwithoutlibrary.ui.viewmodel.MainViewModel

class MainViewModelFactory(
    private val mainRepository: MainRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        require(modelClass.isAssignableFrom(MainViewModel::class.java)){"Unknown class name"}
        return MainViewModel(mainRepository) as T
    }
}