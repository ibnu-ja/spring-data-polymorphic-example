package io.ibnuja.polymorphicexample.media

import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/media")
@RestController
class MediaController(private val mediaRepo: MediaRepo) {
	@PostMapping
	fun store(@RequestBody @Valid request: MediaRequest) {
		val media = Media(name = request.name)
		mediaRepo.save(
			media
		)
	}
}