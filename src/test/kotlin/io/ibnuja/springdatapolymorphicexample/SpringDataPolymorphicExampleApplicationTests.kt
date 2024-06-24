package io.ibnuja.springdatapolymorphicexample

import io.ibnuja.polymorphicexample.media.Media
import io.ibnuja.polymorphicexample.media.MediaRepo
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals

@SpringBootTest
class SpringDataPolymorphicExampleApplicationTests(
	private val mediaRepo: MediaRepo
) {

	@Test
	@Order(1)
	fun createMedia() {
		val media = mediaRepo.save(Media(name = "file1"))
		assertEquals(media.id, 1L)
		assertEquals(media.name, "file1")
	}
}
