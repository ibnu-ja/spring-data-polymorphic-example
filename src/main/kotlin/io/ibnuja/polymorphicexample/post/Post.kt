package io.ibnuja.polymorphicexample.post

import io.ibnuja.polymorphicexample.embedded.AuditMetadata
import io.ibnuja.polymorphicexample.media.Media
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
	val auditingMetadata: AuditMetadata? = null,

	@Embedded
	val mediable: Mediable
) : Mediable {
	@Transient
	private val mediaList: MutableList<Media> = mutableListOf()

	override fun addMedia(media: Media) {
		mediaList.add(media)
	}

	override fun removeMedia(media: Media) {
		mediaList.remove(media)
	}

	fun getMediaList(): List<Media> {
		return mediaList
	}
}