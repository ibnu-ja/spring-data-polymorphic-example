package io.ibnuja.polymorphicexample.product

import jakarta.persistence.*

@Entity
class Product(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long = 0,

	@Column(nullable = false)
	val name: String
)