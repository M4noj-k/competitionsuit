package com.example.AnimeTask.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.AnimeTask.R
import com.example.AnimeTask.utils.ApiResult
import com.example.AnimeTask.utils.Exception
import com.example.AnimeTask.utils.Loading
import com.example.AnimeTask.utils.Success
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        observeData()
    }

    private fun observeData() {
        mainViewModel.loadAnimeListData()
    }

    private fun initData() {
        mainViewModel.aminListLiveData.observe(this){
            when(it){
                is Success -> Toast.makeText(this, Gson().toJson(it.data.data), Toast.LENGTH_LONG).show()
                is Loading -> {
                // Show loader
                }
                is Error -> {
                    // Hanlde error
                }

                is Exception -> {
                    // Show message
                }
            }
        }
    }
}