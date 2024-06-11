package org.example.urlshortnerdemo.controller

import org.example.urlshortnerdemo.model.ShortUrl
import org.example.urlshortnerdemo.service.ShortUrlService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/short-links")
class ShortUrlController(val service: ShortUrlService) {
    @PostMapping("")
    fun getShortLinks(@RequestBody url: String?): String {
        if (url == null) {
            return "Need url"
        }
        val shortUrl = service.createShortUrl(url)
        return shortUrl.shortId
    }

    @GetMapping("/{id}")
    fun getTest(@PathVariable id: String): String {
        return "Hello World $id"
    }
}
