package org.example.urlshortnerdemo.controller

import org.example.urlshortnerdemo.controller.request.CreateShortLinkRequest
import org.example.urlshortnerdemo.controller.response.ShortLinkResponse
import org.example.urlshortnerdemo.exceptions.NotFoundException
import org.example.urlshortnerdemo.service.ShortUrlService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/short-links")
class ShortUrlController(val service: ShortUrlService) {
    @PostMapping("")
    fun createShortLinks(@RequestBody data: CreateShortLinkRequest): ShortLinkResponse {
        val shortUrl = service.createShortUrl(data.url)
        return ShortLinkResponse(
            shortUrlId = shortUrl.shortId,
            url = shortUrl.originalUrl,
            createdAt = shortUrl.createdAt
        )
    }

    @GetMapping("/{shortUrlId}")
    fun getShortUrl(@PathVariable shortUrlId: String): ShortLinkResponse {
        val shortUrl = service.getShortUrl(shortUrlId) ?: throw NotFoundException()

        return ShortLinkResponse(
            shortUrlId = shortUrl.shortId,
            url = shortUrl.originalUrl,
            createdAt = shortUrl.createdAt
        )
    }

    @GetMapping("/redirect/{id}")
    fun redirect(@PathVariable id: String): ResponseEntity<Void> {
        return ResponseEntity.status(302).header("Location", "https://google.com").build()
    }
}
