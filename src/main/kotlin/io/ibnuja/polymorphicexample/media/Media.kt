package io.ibnuja.polymorphicexample.media

import io.ibnuja.polymorphicexample.embedded.AuditMetadata
import io.ibnuja.polymorphicexample.post.Post
import io.ibnuja.polymorphicexample.product.Product
import jakarta.persistence.*
import org.hibernate.annotations.*
import org.hibernate.annotations.CascadeType

@Entity
class Media(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long = 0,

	var name: String,

	@Embedded
	var auditingMetadata: AuditMetadata = AuditMetadata(),

	@ManyToAny
	@AnyKeyJavaClass(Long::class)
	@AnyDiscriminator(DiscriminatorType.STRING)
	@Column(name = "model_type")
	@AnyDiscriminatorValues(
		AnyDiscriminatorValue(discriminator = "post", entity = Post::class),
		AnyDiscriminatorValue(discriminator = "product", entity = Product::class),
	)
	@Cascade(CascadeType.ALL)
	@JoinTable(
		name = "model_has_media",
		joinColumns = [JoinColumn(name = "media_id")],
		inverseJoinColumns = [JoinColumn(name = "model_id")]
	)
	var models: MutableList<Mediable> = mutableListOf()
)