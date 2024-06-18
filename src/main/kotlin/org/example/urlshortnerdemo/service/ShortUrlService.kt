package org.example.urlshortnerdemo.service

import org.example.urlshortnerdemo.model.ShortUrl
import org.example.urlshortnerdemo.repository.ShortUrlRepository
import org.springframework.stereotype.Service
import java.util.Base64

@Service
class ShortUrlService(val repository: ShortUrlRepository) {
    fun createShortUrl(url: String): ShortUrl {
        val shortId: String = Base64.getUrlEncoder().encode(url.toByteArray()).toString(Charsets.UTF_8)

        val shortUrl = ShortUrl(
            originalUrl = url,
            shortId = shortId,
        )
        return repository.save(shortUrl)
    }

    fun getShortUrl(shortUrlId: String): ShortUrl? {
        return repository.findByShortId(shortUrlId)
    }

    fun findShortUrls(): List<ShortUrl> {
        return repository.findAll().toList()
    }
}
