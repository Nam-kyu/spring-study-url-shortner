package org.example.urlshortnerdemo.exceptions

import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(code = org.springframework.http.HttpStatus.NOT_FOUND, reason = "Not Found")
class NotFoundException : RuntimeException() {
}
