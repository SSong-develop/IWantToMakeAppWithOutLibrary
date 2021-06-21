package com.ssong_develop.iwanttomakeappwithoutlibrary.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ssong_develop.iwanttomakeappwithoutlibrary.R
import com.ssong_develop.iwanttomakeappwithoutlibrary.ViewModelFactoryInjector
import com.ssong_develop.iwanttomakeappwithoutlibrary.ui.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel> {
        ViewModelFactoryInjector.provideMainViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.fetchUser()
    }
}