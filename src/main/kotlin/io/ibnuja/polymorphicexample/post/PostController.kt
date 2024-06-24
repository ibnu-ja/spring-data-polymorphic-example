package io.ibnuja.polymorphicexample.post

import io.ibnuja.polymorphicexample.media.MediaRepo
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/post")
class PostController(
	private val mediaRepo: MediaRepo,
	private val postRepo: PostRepo
) {
	@PostMapping
	fun store(@RequestBody @Valid request: PostRequest) {
		val mediaOptional = mediaRepo.findById(request.mediaId)
		if (mediaOptional.isPresent) {
			val media = mediaOptional.get()

			val post = Post(
				title = request.title,
				body = request.body
			)

			// Save the post to get its ID
			postRepo.save(post)

			// Update media with the new post
			val updatedModels = media.models
			updatedModels.add(post)
			media.models = updatedModels

			// Save the updated media
			mediaRepo.save(media)
		} else {
			// Handle media not found case, maybe throw an exception or return an error response
		}
	}
}