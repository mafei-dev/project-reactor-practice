package com.mafei.reactor.practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

class C03StreamEventsWithFluxTest {
    C03StreamEventsWithFlux c03StreamEventsWithFlux = new C03StreamEventsWithFlux();

    @BeforeEach
    void setUp() {
    }

    @Test
    void namesFlux() {
        Flux<String> namesFlux = c03StreamEventsWithFlux.namesFlux();
        StepVerifier
                .create(namesFlux)
                .expectNextCount(4)
                .verifyComplete();
    }
}