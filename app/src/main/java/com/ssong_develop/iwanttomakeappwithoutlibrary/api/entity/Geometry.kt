package com.ssong_develop.iwanttomakeappwithoutlibrary.api.entity

import kotlinx.serialization.Serializable

@Serializable
data class Geometry(
    val lat : String,
    val lng : String
)