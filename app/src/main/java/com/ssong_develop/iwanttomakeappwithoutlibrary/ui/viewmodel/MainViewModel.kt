package com.ssong_develop.iwanttomakeappwithoutlibrary.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssong_develop.iwanttomakeappwithoutlibrary.api.entity.UserInfo
import com.ssong_develop.iwanttomakeappwithoutlibrary.api.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _userList = MutableLiveData<List<UserInfo>>()
    val userList: LiveData<List<UserInfo>>
        get() = _userList

    fun fetchUser() = viewModelScope.launch(Dispatchers.IO) {
        runCatching {
            mainRepository.getUser()
        }.onSuccess {
            _userList.postValue(it)
        }.onFailure {
            throw it
        }
    }
}