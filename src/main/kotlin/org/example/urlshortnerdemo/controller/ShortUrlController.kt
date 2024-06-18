package org.example.urlshortnerdemo.controller

import jakarta.servlet.http.HttpServletResponse
import jakarta.websocket.server.PathParam
import org.example.urlshortnerdemo.controller.request.CreateShortLinkRequest
import org.example.urlshortnerdemo.controller.response.CreateShortLinkResponse
import org.example.urlshortnerdemo.model.ShortUrl
import org.example.urlshortnerdemo.service.ShortUrlService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/short-links")
class ShortUrlController(val service: ShortUrlService) {
    @PostMapping("")
    fun createShortLinks(@RequestBody data: CreateShortLinkRequest): CreateShortLinkResponse {
        val shortUrl = service.createShortUrl(data.url)
        return CreateShortLinkResponse(
            shortUrlId = shortUrl.shortId,
            url = shortUrl.originalUrl,
            createdAt = shortUrl.createdAt
        )
    }

    @GetMapping("/{id}")
    fun getTest(@PathVariable id: String): String {
        return "Hello World $id"
    }

    @GetMapping("/redirect/{id}")
    fun redirect(@PathVariable id: String): ResponseEntity<Void> {
        return ResponseEntity.status(302).header("Location", "https://google.com").build()
    }
}
