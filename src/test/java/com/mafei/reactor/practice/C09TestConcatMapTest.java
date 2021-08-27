package com.mafei.reactor.practice;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

class C09TestConcatMapTest {

    @Test
    void concatMap() {

        Flux<String> concatMap = new C09TestConcatMap().concatMap();
        StepVerifier
                .create(concatMap)
                .expectNext("M", "A", "F", "E", "I", "R", "A", "M", "A", "N")
                .verifyComplete();
    }
}