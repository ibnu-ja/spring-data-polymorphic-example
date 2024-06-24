package io.ibnuja.polymorphicexample.post

import io.ibnuja.polymorphicexample.embedded.AuditMetadata
import io.ibnuja.polymorphicexample.media.Mediable
import jakarta.persistence.*

@Entity
class Post(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long = 0,

	@Column(nullable = false)
	val title: String,

	val body: String,

	@Embedded
	var auditingMetadata: AuditMetadata? = null
): Mediable