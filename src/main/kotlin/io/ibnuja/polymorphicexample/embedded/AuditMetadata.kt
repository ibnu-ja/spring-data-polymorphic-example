package io.ibnuja.polymorphicexample.embedded

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant

class AuditMetadata {
	@CreatedDate
	private val createdAt: Instant = Instant.now()

	@LastModifiedDate
	private var modifiedAt: Instant? = Instant.now()
}