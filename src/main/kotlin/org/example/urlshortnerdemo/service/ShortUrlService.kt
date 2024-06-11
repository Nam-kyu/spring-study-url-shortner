package org.example.urlshortnerdemo.service

import org.example.urlshortnerdemo.model.ShortUrl
import org.example.urlshortnerdemo.repository.ShortUrlRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ShortUrlService(val repository: ShortUrlRepository) {
    fun createShortUrl(url: String): ShortUrl {
        val shortUrl = ShortUrl(
            originalUrl = url,
            shortId = UUID.randomUUID().toString().substring(0, 6)
        )
        return repository.save(shortUrl)
    }

    fun findByShortId(id: Long): Optional<ShortUrl> {
        return repository.findById(id)
    }

    fun findShortUrls(): List<ShortUrl> {
        return repository.findAll().toList()
    }
}
