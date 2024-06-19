package org.example.urlshortnerdemo.service

import com.github.f4b6a3.uuid.UuidCreator
import com.github.f4b6a3.uuid.codec.base.Base62Codec
import com.github.f4b6a3.uuid.enums.UuidNamespace
import org.example.urlshortnerdemo.model.ShortUrl
import org.example.urlshortnerdemo.repository.ShortUrlRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ShortUrlService(val repository: ShortUrlRepository) {
    fun createShortUrl(url: String): ShortUrl {
        val uuid: UUID = UuidCreator.getNameBasedMd5(UuidNamespace.NAMESPACE_URL, url)
        val shortId: String = Base62Codec.INSTANCE.encode(uuid)

        val shortUrl = ShortUrl(
            originalUrl = url,
            shortId = shortId,
        )
        return repository.save(shortUrl)
    }

    fun getShortUrl(shortUrlId: String): ShortUrl? {
        return repository.findByShortId(shortUrlId)
    }
}
