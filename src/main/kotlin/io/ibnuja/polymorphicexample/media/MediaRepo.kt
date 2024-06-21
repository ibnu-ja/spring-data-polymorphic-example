package io.ibnuja.polymorphicexample.media

import org.springframework.data.jpa.repository.JpaRepository

interface MediaRepo : JpaRepository<Media, Long> {

}