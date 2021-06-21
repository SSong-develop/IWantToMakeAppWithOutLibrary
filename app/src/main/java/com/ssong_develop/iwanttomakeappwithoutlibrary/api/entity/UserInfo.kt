package com.ssong_develop.iwanttomakeappwithoutlibrary.api.entity

import kotlinx.serialization.Serializable

@Serializable
data class UserInfo(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company

)
