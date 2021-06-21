package com.ssong_develop.iwanttomakeappwithoutlibrary.api.entity

import kotlinx.serialization.Serializable

@Serializable
data class Company(
    val name: String,
    val catchPhrase: String,
    val bs: String
)
