package com.ssong_develop.iwanttomakeappwithoutlibrary.ui.activity

import android.os.Bundle
import android.widget.LinearLayout.VERTICAL
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ssong_develop.iwanttomakeappwithoutlibrary.R
import com.ssong_develop.iwanttomakeappwithoutlibrary.ViewModelFactoryInjector
import com.ssong_develop.iwanttomakeappwithoutlibrary.databinding.ActivityMainBinding
import com.ssong_develop.iwanttomakeappwithoutlibrary.ui.adapter.UserListAdapter
import com.ssong_develop.iwanttomakeappwithoutlibrary.ui.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private lateinit var userAdapter : UserListAdapter

    private val viewModel by viewModels<MainViewModel> {
        ViewModelFactoryInjector.provideMainViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        userAdapter = UserListAdapter()
        observeData()
        viewModel.fetchUser()

        binding.userList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(DividerItemDecoration(this@MainActivity,VERTICAL))
            adapter = userAdapter
        }
    }

    private fun observeData() {
        viewModel.userList.observe(this){
            userAdapter.submitList(it)
        }
    }
}