package com.ssong_develop.iwanttomakeappwithoutlibrary

import com.ssong_develop.iwanttomakeappwithoutlibrary.api.entity.UserInfo
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.json.JSONArray

object JsonParser {
    fun stringToJsonArray(data: String): JSONArray = JSONArray(data)

    fun jsonArrayToUserInfoList(jsonArray: JSONArray): MutableList<UserInfo> {
        val userList = mutableListOf<UserInfo>()
        val format = Json { coerceInputValues = true }
        synchronized(userList){
            for (i in 0 until jsonArray.length()) {
                val parseData = format.decodeFromString<UserInfo>(jsonArray[i].toString())
                userList.add(parseData)
            }
        }
        return userList
    }
}