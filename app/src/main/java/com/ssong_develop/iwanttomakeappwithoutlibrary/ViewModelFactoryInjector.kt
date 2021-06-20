package com.ssong_develop.iwanttomakeappwithoutlibrary

import com.ssong_develop.iwanttomakeappwithoutlibrary.api.repository.MainRepository
import com.ssong_develop.iwanttomakeappwithoutlibrary.ui.factory.MainViewModelFactory

object ViewModelFactoryInjector {

    private fun provideMainRepository() = MainRepository()

    fun provideMainViewModelFactory() = MainViewModelFactory(provideMainRepository())
}