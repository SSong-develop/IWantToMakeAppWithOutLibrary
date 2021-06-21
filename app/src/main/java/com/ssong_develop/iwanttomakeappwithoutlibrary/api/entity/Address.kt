package com.ssong_develop.iwanttomakeappwithoutlibrary.api.entity

import kotlinx.serialization.Serializable

@Serializable
data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: Geometry
)
