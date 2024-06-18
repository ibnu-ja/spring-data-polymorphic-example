package io.ibnuja.polymorphicexample.post

import jakarta.persistence.*

@Entity
class Post(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long = 0,

	@Column(nullable = false)
	val title: String,

	val body: String
)