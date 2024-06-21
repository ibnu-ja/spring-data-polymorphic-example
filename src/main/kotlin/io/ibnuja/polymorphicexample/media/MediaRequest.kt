package io.ibnuja.polymorphicexample.media

import jakarta.validation.constraints.NotBlank

data class MediaRequest(
	@NotBlank
	val name: String
)
