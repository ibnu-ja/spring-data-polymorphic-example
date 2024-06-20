package io.ibnuja.polymorphicexample.media

import io.ibnuja.polymorphicexample.embedded.AuditMetadata
import jakarta.persistence.*

@Entity
class Media(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long = 0,

	val name: String,

	@Embedded
	val auditingMetadata: AuditMetadata? = null
)