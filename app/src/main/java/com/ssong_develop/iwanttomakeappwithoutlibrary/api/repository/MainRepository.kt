package com.ssong_develop.iwanttomakeappwithoutlibrary.api.repository

import android.util.Log
import com.ssong_develop.iwanttomakeappwithoutlibrary.api.entity.UserInfo
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import org.json.JSONArray
import java.net.HttpURLConnection
import java.net.URL


// https://5e510330f2c0d300147c034c.mockapi.io/
class MainRepository {

    // suspend function으로 만들어서 viewModel에서 Dispatcher.IO에서 call할 예정입니다.

    // json으로 오는게 아니라 jsonArray로 와야합니다.
    // stringBuilder로 받아오면 안되는거 같은데
    // 어떻게 받아와야 할까 고민을 해봅시다.

    // 데이터자체는 오고 있습니다.
    // 고민해보자 이말이다~
    suspend fun getUser(): StringBuilder {
        val urlBuilder = StringBuilder("https://5e510330f2c0d300147c034c.mockapi.io/users")
        val url = URL(urlBuilder.toString())
        val dataBuilder = StringBuilder()
        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "GET"
            inputStream.bufferedReader().use {
                it.lines().forEach { line ->
                    dataBuilder.append(line)
                }
            }
        }
        Log.d("hello",dataBuilder.toString())
        return dataBuilder
    }

    suspend fun getUserWithHttpClient() {
        val httpClient = HttpClient
    }
}