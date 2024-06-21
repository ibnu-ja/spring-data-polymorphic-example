package io.ibnuja.polymorphicexample.product

import io.ibnuja.polymorphicexample.embedded.AuditMetadata
import io.ibnuja.polymorphicexample.media.Media
import io.ibnuja.polymorphicexample.media.Mediable
import jakarta.persistence.*
import org.hibernate.annotations.Any

@Entity
class Product(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long = 0,

	@Column(nullable = false)
	val name: String,

	@Embedded
	val auditingMetadata: AuditMetadata? = null,
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