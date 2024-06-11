package org.example.urlshortnerdemo

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.example.urlshortnerdemo.service.ShortUrlService
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration(classes = [ShortUrlService::class])
class ShortUrlServiceTest(service: ShortUrlService): FunSpec(
    {
        test("ShortUrlService should be able to save a short url") {
            val shortUrl = service.createShortUrl("https://www.google.com")
            shortUrl.originalUrl shouldBe "https://www.google.com"
            shortUrl.shortId.length shouldBe 6
        }
    }
)
