package io.ibnuja.polymorphicexample.media

import io.ibnuja.polymorphicexample.embedded.AuditMetadata
import io.ibnuja.polymorphicexample.post.Post
import io.ibnuja.polymorphicexample.product.Product
import jakarta.persistence.*
import org.hibernate.annotations.AnyDiscriminatorValue
import org.hibernate.annotations.AnyDiscriminatorValues
import org.hibernate.annotations.AnyKeyJavaClass
import org.hibernate.annotations.ManyToAny

@Entity
class Media(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long = 0,

	var name: String,

	@Embedded
	var auditingMetadata: AuditMetadata = AuditMetadata(),
	@ManyToAny
	@Column(name = "model_type")
	@AnyKeyJavaClass(Long::class)
	@AnyDiscriminatorValues(
		AnyDiscriminatorValue(
			discriminator = "post", entity = Post::class
		),
		AnyDiscriminatorValue(
			discriminator = "product", entity = Product::class
		)
	)
	@JoinTable(
		name = "model_has_media",
		joinColumns = [JoinColumn(name = "media_id")],
		inverseJoinColumns = [JoinColumn(name = "attachable_id")]
	)
	val model: MutableList<Mediable> = mutableListOf() // Specify the type explicitly
) {
	init {
		model.forEach { it.addMedia(this) }
	}
}