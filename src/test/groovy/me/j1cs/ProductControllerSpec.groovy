package me.j1cs

import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import spock.lang.AutoCleanup
import spock.lang.Specification
import spock.lang.Shared

import jakarta.inject.Inject

@MicronautTest
class ProductControllerSpec extends Specification {

    @Shared @Inject
    EmbeddedServer embeddedServer

    @Shared @AutoCleanup @Inject @Client("/")
    HttpClient client

    void "test index"() {
        given:
        HttpResponse response = client.toBlocking().exchange("/product")

        expect:
        response.status == HttpStatus.OK
    }
}
