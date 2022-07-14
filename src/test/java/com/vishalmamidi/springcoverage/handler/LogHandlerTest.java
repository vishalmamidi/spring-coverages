package com.vishalmamidi.springcoverage.handler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.mock.web.reactive.function.server.MockServerRequest;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;

class LogHandlerTest {

    @InjectMocks
    LogHandler logHandler = new LogHandler();



    @Test
    @DisplayName("Should not throw an exception")
    void justLog() {

        assertDoesNotThrow(() -> {
            logHandler.justLog(MockServerRequest.builder().body(Mono.empty()));
        });

    }

    @Test
    void justLogPost() {
        assertDoesNotThrow(() -> {
            logHandler.justLogPost(MockServerRequest.builder().body(Mono.empty()));
        });

        assertDoesNotThrow(() -> {
            logHandler.justLogPost(MockServerRequest.builder()
                    .body(Mono.just(Mono.just("vishal"))));
        });
    }

    @Test
    void contextLoads() {
    }
}