package org.example.urlshortnerdemo.repository

import org.example.urlshortnerdemo.model.ShortUrl
import org.springframework.data.repository.CrudRepository

interface ShortUrlRepository: CrudRepository<ShortUrl, Long> {
    fun findByShortId(shortUrlId: String): ShortUrl?
    fun findByOriginalUrl(originalUrl: String): ShortUrl?
    fun findAllByOrderByCreatedAtDesc(): List<ShortUrl>
}
