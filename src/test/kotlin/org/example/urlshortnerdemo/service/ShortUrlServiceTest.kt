package org.example.urlshortnerdemo.service

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.example.urlshortnerdemo.model.ShortUrl
import org.example.urlshortnerdemo.repository.ShortUrlRepository

class ShortUrlServiceTest : FunSpec({
    var repository = mockk<ShortUrlRepository>()
    var service = ShortUrlService(repository)

    test("createShortUrl") {
        every { repository.save(any()) } returns ShortUrl(originalUrl = "https://www.google.com", shortId = "123456")

        val shortUrl = service.createShortUrl(url = "https://www.google.com")

        shortUrl.originalUrl shouldBe "https://www.google.com"
        shortUrl.shortId shouldBe "123456"
    }

    test("getShortUrl") {
        every { repository.findByShortId("123456") } returns ShortUrl(originalUrl = "https://www.google.com", shortId = "123456")

        val shortUrl = service.getShortUrl(shortUrlId = "123456")

        shortUrl?.originalUrl shouldBe "https://www.google.com"
        shortUrl?.shortId shouldBe "123456"
    }

    test("getShortUrl with invalid shortUrlId") {
        every { repository.findByShortId("123456") } returns null

        val shortUrl = service.getShortUrl(shortUrlId = "123456")

        shortUrl shouldBe null
    }
})
