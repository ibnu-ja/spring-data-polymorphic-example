package io.ibnuja.polymorphicexample.post

import jakarta.validation.constraints.NotBlank

data class PostRequest(
	@NotBlank
	val title: String,

	val body: String,

	val mediaId: Long
)