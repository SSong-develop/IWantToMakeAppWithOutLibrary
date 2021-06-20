package com.ssong_develop.iwanttomakeappwithoutlibrary

import com.ssong_develop.iwanttomakeappwithoutlibrary.api.entity.UserInfo
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.json.JSONArray

object JsonParser {
    fun stringToJsonArray(data: String): JSONArray = JSONArray(data)
}