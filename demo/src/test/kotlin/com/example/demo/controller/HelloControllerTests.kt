package com.example.demo.controller

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.*
import org.springframework.web.client.RestTemplate

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class HelloControllerTests {
    @LocalServerPort
    private val port = 8080

    private val restTemplate: RestTemplate = RestTemplate()

    @Test
    @Throws(Exception::class)
    fun helloTest() {
        val url = "http://localhost:$port/"
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        val entity: HttpEntity<Any> = HttpEntity<Any>(headers)
        val response: ResponseEntity<String> = restTemplate.exchange(url, HttpMethod.GET, entity, String::class.java)
        Assertions.assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
    }

}
