package org.example.urlshortnerdemo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/short-links")
class ShortnerController {
    @GetMapping("")
    fun getShortLinks(): String {
        return "Hello World"
    }

    @GetMapping("/{id}")
    fun getTest(@PathVariable id: String): String {
        return "Hello World $id"
    }
}