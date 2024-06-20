package io.ibnuja.polymorphicexample.product

import io.ibnuja.polymorphicexample.embedded.AuditMetadata
import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Product(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long = 0,

	@Column(nullable = false)
	val name: String,

	@Embedded
	val auditingMetadata: AuditMetadata? = null
)
