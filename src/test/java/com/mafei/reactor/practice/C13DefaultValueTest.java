package com.mafei.reactor.practice;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

class C13DefaultValueTest {

    @Test
    void nameFluxTransform() {
        Flux<String> stringFlux = new C13DefaultValue()
                .nameFluxTransform()
                .defaultIfEmpty("no_data3");
        StepVerifier.create(stringFlux)
                .expectNext("no_data1")
                .verifyComplete();

    }

    @Test
    void nameFluxTransformWithoutDefault() {
        Flux<String> stringFlux = new C13DefaultValue()
                .nameFluxTransformWithoutDefault();
        StepVerifier.create(stringFlux)
                .expectNextCount(0)
                .verifyComplete();
    }

    @Test
    void nameFluxTransformWithSwitchIf() {
        Flux<String> stringFlux = new C13DefaultValue()
                .nameFluxTransformWithSwitchIf();
        StepVerifier.create(stringFlux)
                .expectNextCount(0)
                .verifyComplete();
    }
}