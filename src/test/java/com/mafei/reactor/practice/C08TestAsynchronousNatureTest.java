package com.mafei.reactor.practice;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

class C08TestAsynchronousNatureTest {

    @Test
    void flatMapAsync() {
        Flux<String> flatMapAsync = new C08TestAsynchronousNature().flatMapAsync();
        StepVerifier
                .create(flatMapAsync)
                .expectNext("M", "A", "F", "I", "R", "A", "M", "A", "N")
                .verifyComplete();
    }
}