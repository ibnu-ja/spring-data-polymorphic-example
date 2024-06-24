package io.ibnuja.polymorphicexample.post

import org.springframework.data.jpa.repository.JpaRepository

interface PostRepo : JpaRepository<Post, Int> {
}