package com.bastienvizzini.teammates.models

import java.util.*

data class Message (
    val message: String? = null,
    val dateCreated: Date? = null,
    val userSenderUid: String? = null,
    val urlImage: String? = null
) {

}