package com.ssong_develop.iwanttomakeappwithoutlibrary.api.repository

import android.util.Log
import androidx.lifecycle.LifecycleCoroutineScope
import com.ssong_develop.iwanttomakeappwithoutlibrary.JsonParser
import com.ssong_develop.iwanttomakeappwithoutlibrary.api.entity.UserInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.plus
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.net.HttpURLConnection
import java.net.URL

class MainRepository{

    fun getUser(): List<UserInfo> {
        val urlBuilder = StringBuilder("https://jsonplaceholder.typicode.com/users")
        val url = URL(urlBuilder.toString())
        val dataBuilder = StringBuilder()
        val userList = mutableListOf<UserInfo>()
        val format = Json { coerceInputValues = true }
        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "GET"
            inputStream.bufferedReader().use {
                it.lines().forEach { line ->
                    dataBuilder.append(line)
                }
            }
        }
        val jsonArray = JsonParser.stringToJsonArray(dataBuilder.toString())
        synchronized(userList){
            for (i in 0 until jsonArray.length()) {
                val parseData = format.decodeFromString<UserInfo>(jsonArray[i].toString())
                userList.add(parseData)
            }
        }
        return userList
    }
}