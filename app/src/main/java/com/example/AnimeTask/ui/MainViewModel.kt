package com.example.AnimeTask.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.AnimeTask.data.HomeRoute
import com.example.AnimeTask.data.repository.MainRepository
import com.example.AnimeTask.remote.NetworkHelper
import com.example.AnimeTask.utils.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {
    private val _animList = MutableLiveData<ApiResult<HomeRoute>>()
    val aminListLiveData: LiveData<ApiResult<HomeRoute>> = _animList

    fun loadAnimeListData() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = mainRepository.getAnimeList()
            _animList.postValue(response)
        }
    }
}