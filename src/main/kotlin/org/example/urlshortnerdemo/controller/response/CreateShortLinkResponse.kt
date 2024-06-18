package org.example.urlshortnerdemo.controller.response

import java.time.ZonedDateTime

data class CreateShortLinkResponse (
    val shortUrlId: String,
    val url: String,
    val createdAt: ZonedDateTime,
)