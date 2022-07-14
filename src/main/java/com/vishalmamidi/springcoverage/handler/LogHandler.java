package com.vishalmamidi.springcoverage.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Objects;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
@Slf4j
public class LogHandler {
    public Mono<ServerResponse> justLog(ServerRequest request) {
        log.info("logging: {}", request);
        return ServerResponse.status(HttpStatus.ACCEPTED)
                .contentType(APPLICATION_JSON)
                .body(Mono.just("Awesome!, Deploy  Successfully.\ncurrent time:" + java.time.LocalDateTime.now()), String.class);
    }

    public Mono<ServerResponse> justLogPost(ServerRequest request) {
        Mono<String> logMono = request.bodyToMono(String.class);

        return logMono.flatMap(requestString -> {
            if(Objects.equals(requestString, "vishal")){
                log.info("you have sent vishal");
            }
            log.info("you have not sent vishal");
            return ServerResponse.status(HttpStatus.ACCEPTED)
                    .contentType(APPLICATION_JSON)
                    .body(Mono.just(java.time.LocalDateTime.now().toString()), String.class);
        });
    }
}