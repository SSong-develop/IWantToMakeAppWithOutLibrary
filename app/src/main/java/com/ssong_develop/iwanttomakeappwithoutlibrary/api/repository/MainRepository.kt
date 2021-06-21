package com.ssong_develop.iwanttomakeappwithoutlibrary.api.repository

import com.ssong_develop.iwanttomakeappwithoutlibrary.JsonParser
import com.ssong_develop.iwanttomakeappwithoutlibrary.api.entity.UserInfo
import java.net.HttpURLConnection
import java.net.URL

class MainRepository {

    fun getUser(): List<UserInfo> {
        val urlBuilder = StringBuilder("https://jsonplaceholder.typicode.com/users")
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
        val jsonArray = JsonParser.stringToJsonArray(dataBuilder.toString())

        return JsonParser.jsonArrayToUserInfoList(jsonArray)
    }
}