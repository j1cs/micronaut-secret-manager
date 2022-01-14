package me.j1cs;

import io.micronaut.context.annotation.Value;
import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@ExecuteOn(TaskExecutors.IO)
@Controller("/products")
public class ProductController {

    @Value("${service.var}")
    private String value;
    private final ProductRepository repository;

    @Post()
    public Publisher<Response> post(@Body Mono<Request> requestMono) {
        return requestMono
                .map(request -> repository.save(request.getName()))
                .map(product -> Response.builder().name(product.getName()).build());
    }

    @Get
    public String get() {
        return value;
    }
}