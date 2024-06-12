package org.example.urlshortnerdemo

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.example.urlshortnerdemo.service.ShortUrlService
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration(classes = [ShortUrlService::class])
@DataJpaTest
@EnableJpaRepositories(basePackages = ["org.example.urlshortnerdemo.repository"])
@EntityScan(basePackages = ["org.example.urlshortnerdemo.model"])
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ShortUrlServiceTest(service: ShortUrlService): FunSpec(
    {
        test("ShortUrlService should be able to save a short url") {
            val shortUrl = service.createShortUrl("https://www.google.com")
            shortUrl.originalUrl shouldBe "https://www.google.com"
            shortUrl.shortId.length shouldBe 6
        }
    }
)
