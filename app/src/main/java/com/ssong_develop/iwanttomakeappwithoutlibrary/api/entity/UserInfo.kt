package com.ssong_develop.iwanttomakeappwithoutlibrary.api.entity

import kotlinx.serialization.Serializable

@Serializable
data class UserInfo(
    val id : Int,
    val name : String,
    val avatar : String,
    val email : String
)
