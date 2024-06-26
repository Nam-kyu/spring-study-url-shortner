package org.example.urlshortnerdemo.model

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.ZonedDateTime
import java.util.Date

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "short_urls")
data class ShortUrl (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(unique = true, name = "short_id", nullable = false)
    var shortId: String,
    @Column(name = "original_url", nullable = false)
    var originalUrl: String,
    @Column(name = "created_at", updatable = false, nullable = false)
    @CreatedDate
    var createdAt: ZonedDateTime,
    @Column(name = "updated_at")
    @LastModifiedDate
    var updatedAt: ZonedDateTime,
    @Column(name = "expires_at")
    var expiresAt: ZonedDateTime? = null,
) {
    constructor(shortId: String, originalUrl: String) : this(
        null,
        shortId,
        originalUrl,
        ZonedDateTime.now(),
        ZonedDateTime.now()
    )
}
